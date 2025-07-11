
package com.navercorp.pinpoint.collector.handler.grpc;

import com.navercorp.pinpoint.collector.handler.SimpleHandler;
import com.navercorp.pinpoint.collector.sampler.Sampler;
import com.navercorp.pinpoint.collector.sampler.SpanSamplerFactory;
import com.navercorp.pinpoint.collector.service.TraceService;
import com.navercorp.pinpoint.common.hbase.RequestNotPermittedException;
import com.navercorp.pinpoint.common.profiler.logging.LogSampler;
import com.navercorp.pinpoint.common.server.bo.BasicSpan;
import com.navercorp.pinpoint.common.server.bo.SpanChunkBo;
import com.navercorp.pinpoint.common.server.bo.grpc.BindAttribute;
import com.navercorp.pinpoint.common.server.bo.grpc.GrpcSpanFactory;
import com.navercorp.pinpoint.grpc.MessageFormatUtils;
import com.navercorp.pinpoint.grpc.trace.PSpanChunk;
import com.navercorp.pinpoint.grpc.trace.PSpanEvent;
import com.navercorp.pinpoint.grpc.trace.PTransactionId;
import com.navercorp.pinpoint.io.request.BindAttributes;
import com.navercorp.pinpoint.io.request.ServerHeader;
import com.navercorp.pinpoint.io.request.ServerRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author emeroad
 */
@Service
public class GrpcSpanChunkHandler implements SimpleHandler<PSpanChunk> {

    private final Logger logger = LogManager.getLogger(getClass());
    private final LogSampler infoLog = new LogSampler(1000);
    private final LogSampler warnLog = new LogSampler(100);
    private final boolean isDebug = logger.isDebugEnabled();

    private final TraceService[] traceServices;

    private final GrpcSpanFactory spanFactory;

    private final Sampler<BasicSpan> sampler;

    public GrpcSpanChunkHandler(TraceService[] traceServices, GrpcSpanFactory spanFactory, SpanSamplerFactory spanSamplerFactory) {
        this.traceServices = Objects.requireNonNull(traceServices, "traceServices");
        this.spanFactory = Objects.requireNonNull(spanFactory, "spanFactory");
        this.sampler = spanSamplerFactory.createBasicSpanSampler();

        logger.info("TraceServices {}", Arrays.toString(traceServices));
    }

    @Override
    public void handleSimple(ServerRequest<PSpanChunk> serverRequest) {
        final PSpanChunk spanChunk = serverRequest.getData();
        final ServerHeader header = serverRequest.getHeader();
        final BindAttribute attribute = BindAttributes.of(header, serverRequest.getRequestTime());
        handleSpanChunk(attribute, spanChunk);
    }


    private void handleSpanChunk(BindAttribute attribute, PSpanChunk spanChunk) {
        if (isDebug) {
            logger.debug("Handle PSpanChunk={}", createSimpleSpanChunkLog(spanChunk));
        }
        final SpanChunkBo spanChunkBo = spanFactory.buildSpanChunkBo(spanChunk, attribute);
        if (!sampler.isSampling(spanChunkBo)) {
            if (isDebug) {
                logger.debug("unsampled PSpanChunk={}", createSimpleSpanChunkLog(spanChunk));
            } else {
                infoLog.log(() -> {
                    if (logger.isInfoEnabled()) {
                        logger.info("unsampled PSpanChunk={}", createSimpleSpanChunkLog(spanChunk));
                    }
                });
            }
            return;
        }
        for (TraceService traceService : traceServices) {
            try {
                traceService.insertSpanChunk(spanChunkBo);
            } catch (RequestNotPermittedException notPermitted) {
                warnLog.log(c -> logger.warn("Failed to handle SpanChunk RequestNotPermitted:{} {}", notPermitted.getMessage(), c));
            } catch (Throwable e) {
                logger.warn("Failed to handle SpanChunk={}", MessageFormatUtils.debugLog(spanChunk), e);
            }
        }
    }

    private String createSimpleSpanChunkLog(PSpanChunk spanChunk) {
        if (!isDebug) {
            return "";
        }
        long spanId = spanChunk.getSpanId();
        PTransactionId transactionId = spanChunk.getTransactionId();
        final List<PSpanEvent> spanEventList = spanChunk.getSpanEventList();

        return SpanLog.debugLog(transactionId, spanId, spanEventList);
    }

    @Override
    public String toString() {
        return "GrpcSpanChunkHandler";
    }
}