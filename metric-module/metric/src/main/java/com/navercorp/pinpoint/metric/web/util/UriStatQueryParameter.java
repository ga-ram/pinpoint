package com.navercorp.pinpoint.metric.web.util;

import java.util.concurrent.TimeUnit;

public class UriStatQueryParameter extends QueryParameter {
    private final String serviceName;
    private final String applicationName;
    private final String agentId;
    private final String uri;

    protected UriStatQueryParameter(Builder builder) {
        super(builder.range, builder.timePrecision, builder.limit);
        this.serviceName = builder.serviceName;
        this.applicationName = builder.applicationName;
        this.agentId = builder.agentId;
        this.uri = builder.uri;
    }

    public static class Builder extends QueryParameter.Builder {
        private String serviceName;
        private String applicationName;
        private String agentId;
        private String uri;

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public void setApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }

        public void setUri(String uri) { this.uri = uri; }

        @Override
        public UriStatQueryParameter build() {
            if (timePrecision == null) {
                this.timePrecision = TimePrecision.newTimePrecision(TimeUnit.MILLISECONDS, 30000);
            }
            this.limit = estimateLimit();
            return new UriStatQueryParameter(this);
        }
    }
}
