package com.navercorp.pinpoint.batch.alarm.vo;

import java.sql.Date;
import java.util.Objects;

public class PinotAlarmHistory {
    private final String ruleId;
    private final Date timestamp;

    public PinotAlarmHistory(String ruleId, long timestamp) {
        this.ruleId = Objects.requireNonNull(ruleId, "ruleId");
        this.timestamp = new Date(timestamp);
    }

    public PinotAlarmHistory(String ruleId, Date timestamp) {
        this.ruleId = Objects.requireNonNull(ruleId, "ruleId");
        this.timestamp = Objects.requireNonNull(timestamp, "timestamp");
    }

    public String getRuleId() {
        return ruleId;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
