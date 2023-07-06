package com.navercorp.pinpoint.batch.alarm.checker.uristat;

import com.navercorp.pinpoint.batch.alarm.checker.DoubleValueAlarmChecker;
import com.navercorp.pinpoint.batch.alarm.collector.ApdexDataCollector;
import com.navercorp.pinpoint.batch.alarm.condition.AlarmCondition;
import com.navercorp.pinpoint.batch.alarm.vo.PinotAlarmRule;

import java.util.List;

public class UriApdexChecker extends DoubleValueAlarmChecker {
    public UriApdexChecker(List<PinotAlarmRule> rules, ApdexDataCollector dataCollector, AlarmCondition<Double> alarmCondition) {
        super(rules, "", dataCollector, alarmCondition);
    }
}
