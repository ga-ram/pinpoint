package com.navercorp.pinpoint.batch.alarm.checker.uristat;

import com.navercorp.pinpoint.batch.alarm.checker.LongValueAlarmChecker;
import com.navercorp.pinpoint.batch.alarm.collector.FailureCountDataCollector;
import com.navercorp.pinpoint.batch.alarm.condition.AlarmCondition;
import com.navercorp.pinpoint.batch.alarm.vo.PinotAlarmRule;

import java.util.List;

public class UriFailureCountChecker extends LongValueAlarmChecker {
    public UriFailureCountChecker(List<PinotAlarmRule> rules, FailureCountDataCollector dataCollector, AlarmCondition<Long> alarmCondition) {
        super(rules, "", dataCollector, alarmCondition);
    }
}
