package com.navercorp.pinpoint.batch.alarm.checker.uristat;

import com.navercorp.pinpoint.batch.alarm.checker.DoubleValueAlarmChecker;
import com.navercorp.pinpoint.batch.alarm.collector.AvgResponseDataCollector;
import com.navercorp.pinpoint.batch.alarm.condition.AlarmCondition;
import com.navercorp.pinpoint.batch.alarm.vo.PinotAlarmRule;

import java.util.List;

public class UriAvgResponseChecker extends DoubleValueAlarmChecker {
    public UriAvgResponseChecker(List<PinotAlarmRule> rules, AvgResponseDataCollector dataCollector, AlarmCondition<Double> alarmCondition) {
        super(rules, "ms", dataCollector, alarmCondition);
    }
}
