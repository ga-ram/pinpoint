package com.navercorp.pinpoint.batch;

import com.navercorp.pinpoint.batch.alarm.config.UriStatBatchDaoConfiguration;
import com.navercorp.pinpoint.pinot.config.PinotConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootConfiguration
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        TransactionAutoConfiguration.class,
        BatchAutoConfiguration.class
})
@ImportResource({
        "classpath:job/applicationContext-uriAlarmJob.xml",
        "classpath:applicationContext-pinot-batch-dao-config.xml"
})
@Import({
        UriStatBatchDaoConfiguration.class,
        PinotConfiguration.class
        /*
        BatchAppPropertySources.class,
        WebhookModule.class,*/
})
public class UriStatAlarmConfiguration {
    public UriStatAlarmConfiguration() {
    }
}
