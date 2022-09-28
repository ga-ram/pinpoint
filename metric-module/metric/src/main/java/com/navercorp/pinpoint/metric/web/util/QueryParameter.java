package com.navercorp.pinpoint.metric.web.util;

import com.navercorp.pinpoint.metric.common.model.Tag;

import java.util.List;

public abstract class QueryParameter {
    protected static final int TAG_SET_COUNT = 10;
    protected final Range range;
    protected final TimePrecision timePrecision;
    protected final long limit;

    protected QueryParameter(Range range, TimePrecision timePrecision, long limit) {
        this.range = range;
        this.timePrecision = timePrecision;
        this.limit = limit;
    }

    public Range getRange() { return range; }

    public TimePrecision getTimePrecision() {
        return timePrecision;
    }

    public long getLimit() {
        return limit;
    }

    public static abstract class Builder {
        protected Range range;
        protected TimePrecision timePrecision;
        protected int timeSize = 10000;
        protected long limit;

        public void setRange(Range range) {
            this.range = range;
        }

        public void setTimePrecision(TimePrecision timePrecision) {
            this.timePrecision = timePrecision;
        }

        public void setTimeSize(int timeSize) { this.timeSize = timeSize; }

        public long estimateLimit() {
            return (range.getRange() / timePrecision.getInterval() + 1) * TAG_SET_COUNT;
        }

        abstract public QueryParameter build();
    }
}
