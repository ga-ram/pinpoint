package com.navercorp.pinpoint.batch.alarm.sender;

import com.navercorp.pinpoint.batch.alarm.checker.PinotAlarmChecker;
import org.springframework.stereotype.Component;

@Component
public class PinotAlarmMessageSenderImpl implements PinotAlarmMessageSender {
    @Override
    public void sendSms(PinotAlarmChecker checker, int index) {

    }

    @Override
    public void sendEmail(PinotAlarmChecker checker, int index) {

    }

    @Override
    public void sendWebhook(PinotAlarmChecker checker, int index) {

    }
}
