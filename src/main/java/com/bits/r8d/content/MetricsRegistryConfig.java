package com.bits.r8d.content;

import com.codahale.metrics.MetricRegistry;
import org.elasticsearch.metrics.ElasticsearchReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexl on 25/06/2014.
 */
@Configuration
public class MetricsRegistryConfig {
    @Bean
    public MetricRegistry getMetricRegistry() {
        return new MetricRegistry();
    }

    @Bean
    public ElasticsearchReporter getElasticsearchReporter(final MetricRegistry metricRegistry) throws Exception {
        final ElasticsearchReporter reporter = ElasticsearchReporter.forRegistry(metricRegistry)
                .hosts("localhost:8090")
                .build();
        reporter.start(60, TimeUnit.SECONDS);
        return reporter;
    }
}
