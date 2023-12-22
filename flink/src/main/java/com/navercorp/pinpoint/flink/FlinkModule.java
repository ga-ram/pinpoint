/*
 * Copyright 2023 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.navercorp.pinpoint.flink;

import com.navercorp.pinpoint.common.config.Value;
import com.navercorp.pinpoint.common.hbase.HadoopResourceCleanerRegistry;
import com.navercorp.pinpoint.common.hbase.HbaseTableNameProvider;
import com.navercorp.pinpoint.common.hbase.config.HbaseMultiplexerProperties;
import com.navercorp.pinpoint.common.hbase.config.HbaseTemplateConfiguration;
import com.navercorp.pinpoint.common.server.cluster.zookeeper.config.ClusterConfigurationFactory;
import com.navercorp.pinpoint.common.server.hbase.config.HbaseClientConfiguration;
import com.navercorp.pinpoint.flink.cache.FlinkCacheConfiguration;
import com.navercorp.pinpoint.flink.config.FlinkExecutorConfiguration;
import com.navercorp.pinpoint.flink.dao.hbase.ApplicationDaoConfiguration;
import com.navercorp.pinpoint.flink.dao.hbase.DefaultStatisticsDaoInterceptor;
import com.navercorp.pinpoint.flink.function.DefaultApplicationStatBoWindowInterceptor;
import com.navercorp.pinpoint.flink.hbase.Hbase2HadoopResourceCleanerRegistry;
import com.navercorp.pinpoint.flink.process.DefaultTBaseFlatMapperInterceptor;
import org.apache.hadoop.hbase.shaded.org.apache.kerby.config.Resource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

import static org.apache.hadoop.hbase.shaded.org.apache.kerby.config.Resource.createPropertiesFileResource;

@Configuration
@ComponentScan(basePackages = {
        "com.navercorp.pinpoint.common.server.util"
})
@ImportResource({
        "classpath:applicationContext-flink.xml",
        "classpath:applicationContext-hbase.xml",
})
@Import({
        FlinkCacheConfiguration.class,
        ApplicationDaoConfiguration.class,
        FlinkExecutorConfiguration.class,
        HbaseClientConfiguration.class,
        HbaseTemplateConfiguration.class,

        ClusterConfigurationFactory.class
})
@PropertySource(name = "FlinkModule", value = {
        "classpath:profiles/${pinpoint.profiles.active:local}/hbase.properties",
        "classpath:profiles/${pinpoint.profiles.active:local}/pinpoint-flink.properties"
})
public class FlinkModule {
    @Value("${hbase.namespace:default}")
    private String hbaseNamespace;

    @Bean
    public HadoopResourceCleanerRegistry hbase2HadoopResourceCleanerRegistry() {
        return new Hbase2HadoopResourceCleanerRegistry();
    }

    @Bean
    @ConfigurationProperties(prefix = "hbase.client.async")
    public HbaseMultiplexerProperties hbaseMultiplexerProperties() {
        return new HbaseMultiplexerProperties();
    }

    @Bean
    public DefaultTBaseFlatMapperInterceptor tBaseFlatMapperInterceptor() {
        return new DefaultTBaseFlatMapperInterceptor();
    }

    @Bean
    public DefaultStatisticsDaoInterceptor statisticsDaoInterceptor() {
        return new DefaultStatisticsDaoInterceptor();
    }

    @Bean
    public DefaultApplicationStatBoWindowInterceptor applicationStatBoWindowInterceptor() {
        return new DefaultApplicationStatBoWindowInterceptor();
    }

    @Bean
    public HbaseTableNameProvider tableNameProvider() {
        return new HbaseTableNameProvider(hbaseNamespace);
    }
}
