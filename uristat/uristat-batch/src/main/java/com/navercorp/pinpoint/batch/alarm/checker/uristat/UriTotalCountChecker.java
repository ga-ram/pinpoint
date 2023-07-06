package com.navercorp.pinpoint.batch.alarm.checker.uristat;

import com.navercorp.pinpoint.batch.alarm.checker.LongValueAlarmChecker;
import com.navercorp.pinpoint.batch.alarm.collector.TotalCountDataCollector;
import com.navercorp.pinpoint.batch.alarm.condition.AlarmCondition;
import com.navercorp.pinpoint.batch.alarm.vo.PinotAlarmRule;

import java.util.List;

public class UriTotalCountChecker extends LongValueAlarmChecker {
    public UriTotalCountChecker(List<PinotAlarmRule> rules, TotalCountDataCollector dataCollector, AlarmCondition<Long> alarmCondition) {
        super(rules, "", dataCollector, alarmCondition);
    }
}
