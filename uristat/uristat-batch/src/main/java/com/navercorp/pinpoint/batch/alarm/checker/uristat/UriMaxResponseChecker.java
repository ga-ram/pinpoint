package com.navercorp.pinpoint.batch.alarm.checker.uristat;

import com.navercorp.pinpoint.batch.alarm.checker.DoubleValueAlarmChecker;
import com.navercorp.pinpoint.batch.alarm.collector.MaxResponseDataCollector;
import com.navercorp.pinpoint.batch.alarm.condition.AlarmCondition;
import com.navercorp.pinpoint.batch.alarm.vo.PinotAlarmRule;

import java.util.List;

public class UriMaxResponseChecker extends DoubleValueAlarmChecker {
    public UriMaxResponseChecker(List<PinotAlarmRule> rules, MaxResponseDataCollector dataCollector, AlarmCondition<Double> alarmCondition) {
        super(rules, "ms", dataCollector, alarmCondition);
    }
}
