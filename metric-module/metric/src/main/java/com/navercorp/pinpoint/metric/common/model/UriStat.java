package com.navercorp.pinpoint.metric.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class UriStat {
    private final long EMPTY_NUMBER = 0L;
    private final String serviceName;
    private final String applicationName;
    private final String agentId;
    private final String uri;
    private final long count;
    private final long maxLatencyMs;
    private final long totalTimeMs;
    private final int[] totalHistogram;
    private final int[] failureHistogram;
    private final long timestamp;
    private final int version;

    public UriStat(long timestamp, String serviceName, String applicationName, String agentId, String uri, long count, long maxLatencyMs, long totalTimeMs, int[] totalHistogram, int[] failureHistogram, int version) {
        this.timestamp = timestamp;
        this.serviceName = Objects.requireNonNull(serviceName, "serviceName");
        this.applicationName = StringPrecondition.requireHasLength(applicationName, "applicationName");
        this.agentId = StringPrecondition.requireHasLength(agentId, "agentId");
        this.uri = StringPrecondition.requireHasLength(uri, "uri");
        this.count = count;
        this.maxLatencyMs = maxLatencyMs;
        this.totalTimeMs = totalTimeMs;
        this.totalHistogram = Objects.requireNonNull(totalHistogram, "totalHistogram");
        this.failureHistogram = Objects.requireNonNull(failureHistogram, "totalHistogram");
        this.version = version;
    }

    public UriStat(long timestamp, double totalHistogram0, double totalHistogram1, double totalHistogram2, double totalHistogram3,
                   double totalHistogram4, double totalHistogram5, double totalHistogram6, double totalHistogram7,
                   double failureHistogram0, double failureHistogram1, double failureHistogram2, double failureHistogram3,
                   double failureHistogram4, double failureHistogram5, double failureHistogram6, double failureHistogram7, int version) {
        this.timestamp = timestamp;
        this.serviceName = StringUtils.EMPTY;
        this.applicationName = StringUtils.EMPTY;
        this.agentId = StringUtils.EMPTY;
        this.uri = StringUtils.EMPTY;
        this.count = EMPTY_NUMBER;
        this.maxLatencyMs = EMPTY_NUMBER;
        this.totalTimeMs = EMPTY_NUMBER;
        this.totalHistogram = new int[]{(int)totalHistogram0, (int)totalHistogram1, (int)totalHistogram2, (int)totalHistogram3, (int)totalHistogram4, (int)totalHistogram5, (int)totalHistogram6, (int)totalHistogram7};
        this.failureHistogram = new int[]{(int)failureHistogram0, (int)failureHistogram1, (int)failureHistogram2, (int)failureHistogram3, (int)failureHistogram4, (int)failureHistogram5, (int)failureHistogram6, (int)failureHistogram7};
        this.version = version;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getAgentId() { return agentId; }

    public String getUri() {
        return uri;
    }

    public long getCount() {
        return count;
    }

    public long getMaxLatencyMs() {
        return maxLatencyMs;
    }

    public long getTotalTimeMs() {
        return totalTimeMs;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getVersion() { return version; }

    public int getTotalHistogram0() { return totalHistogram[0]; }
    public int getTotalHistogram1() { return totalHistogram[1]; }
    public int getTotalHistogram2() { return totalHistogram[2]; }
    public int getTotalHistogram3() { return totalHistogram[3]; }
    public int getTotalHistogram4() { return totalHistogram[4]; }
    public int getTotalHistogram5() { return totalHistogram[5]; }
    public int getTotalHistogram6() { return totalHistogram[6]; }
    public int getTotalHistogram7() { return totalHistogram[7]; }

    public int getFailureHistogram0() { return failureHistogram[0]; }
    public int getFailureHistogram1() { return failureHistogram[1]; }
    public int getFailureHistogram2() { return failureHistogram[2]; }
    public int getFailureHistogram3() { return failureHistogram[3]; }
    public int getFailureHistogram4() { return failureHistogram[4]; }
    public int getFailureHistogram5() { return failureHistogram[5]; }
    public int getFailureHistogram6() { return failureHistogram[6]; }
    public int getFailureHistogram7() { return failureHistogram[7]; }

    @JsonIgnore
    public int[] getTotalHistogram() { return totalHistogram; }

    @JsonIgnore
    public int[] getFailureHistogram() { return failureHistogram; }

    @Override
    public String toString() {
        return "UriStat{" +
                "serviceName='" + serviceName + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", agentId='" + agentId + '\'' +
                ", uri=" + uri +
                ", count=" + count +
                ", maxLatencyMs=" + maxLatencyMs +
                ", totalTimeMs=" + totalTimeMs +
                ", totalHistogram=" + totalHistogram +
                ", failureHistogram=" + failureHistogram +
                ", timestamp=" + timestamp +
                '}';
    }

}
