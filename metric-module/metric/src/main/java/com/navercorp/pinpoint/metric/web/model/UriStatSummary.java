package com.navercorp.pinpoint.metric.web.model;

public class UriStatSummary {
    private final String uri;
    private final double totalCount;
    private final double failureCount;
    private final double maxTimeMs;
    private final double avgTimeMs;
    private final int version;

    public UriStatSummary(String uri, double totalCount, double failureCount, double maxTimeMs, double totalTimeMs, int version) {
        this.uri = uri;
        this.totalCount = totalCount;
        this.failureCount = failureCount;
        this.maxTimeMs = maxTimeMs;
        this.avgTimeMs = totalTimeMs / totalCount;
        this.version = version;
    }


    public String getUri() {
        return uri;
    }

    public double getTotalCount() {
        return totalCount;
    }

    public double getFailureCount() {
        return failureCount;
    }

    public double getMaxTimeMs() {
        return maxTimeMs;
    }

    public double getAvgTimeMs() {
        return avgTimeMs;
    }
}
