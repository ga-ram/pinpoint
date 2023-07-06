package com.navercorp.pinpoint.batch.alarm.checker;


import com.navercorp.pinpoint.batch.alarm.checker.uristat.*;
import com.navercorp.pinpoint.batch.alarm.collector.*;
import com.navercorp.pinpoint.batch.alarm.condition.AlarmCondition;
import com.navercorp.pinpoint.batch.alarm.vo.PinotAlarmRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UriStatAlarmCheckerRegistry {
    public final Map<UriStatAlarmChecker, UriStatAlarmCheckerFactory> registry = new HashMap<>();

    public static UriStatAlarmCheckerRegistry newCheckerRegistry() {
        UriStatAlarmCheckerRegistry alarmCheckerRegistry = new UriStatAlarmCheckerRegistry();
        alarmCheckerRegistry.setup();
        return alarmCheckerRegistry;
    }

    private UriStatAlarmCheckerRegistry() {
    }

    public UriStatAlarmCheckerFactory getCheckerFactory(UriStatAlarmChecker name) {
        return registry.get(name);
    }

    private void put(UriStatAlarmChecker category, UriStatAlarmCheckerFactory factory) {
        this.registry.put(category, factory);
    }

    private void setup() {
        put(UriStatAlarmChecker.TOTAL_COUNT, new UriStatAlarmCheckerFactory() {
            @Override
            public PinotAlarmChecker<?> createChecker(List<PinotAlarmRule> rules, PinotDataCollector dataCollector, AlarmCondition alarmCondition) {
                return new UriTotalCountChecker(rules, (TotalCountDataCollector) dataCollector, alarmCondition);
            }
        });
        put(UriStatAlarmChecker.FAILURE_COUNT, new UriStatAlarmCheckerFactory() {
            @Override
            public PinotAlarmChecker<?> createChecker(List<PinotAlarmRule> rules, PinotDataCollector dataCollector, AlarmCondition alarmCondition) {
                return new UriFailureCountChecker(rules, (FailureCountDataCollector) dataCollector, alarmCondition);
            }
        });
        put(UriStatAlarmChecker.APDEX, new UriStatAlarmCheckerFactory() {
            @Override
            public PinotAlarmChecker<?> createChecker(List<PinotAlarmRule> rules, PinotDataCollector dataCollector, AlarmCondition alarmCondition) {
                return new UriApdexChecker(rules, (ApdexDataCollector) dataCollector, alarmCondition);
            }
        });
        put(UriStatAlarmChecker.AVG_RESPONSE_MS, new UriStatAlarmCheckerFactory() {
            @Override
            public PinotAlarmChecker<?> createChecker(List<PinotAlarmRule> rules, PinotDataCollector dataCollector, AlarmCondition alarmCondition) {
                return new UriAvgResponseChecker(rules, (AvgResponseDataCollector) dataCollector, alarmCondition);
            }
        });
        put(UriStatAlarmChecker.MAX_RESPONES_MS, new UriStatAlarmCheckerFactory() {
            @Override
            public PinotAlarmChecker<?> createChecker(List<PinotAlarmRule> rules, PinotDataCollector dataCollector, AlarmCondition alarmCondition) {
                return new UriMaxResponseChecker(rules, (MaxResponseDataCollector) dataCollector, alarmCondition);
            }
        });
    }
}
