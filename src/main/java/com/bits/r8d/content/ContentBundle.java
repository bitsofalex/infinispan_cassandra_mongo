package com.bits.r8d.content;

import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.ws.rs.Path;
import java.util.Map;

public class ContentBundle<T extends Configuration> implements ConfiguredBundle<T> {

    private final AnnotationConfigWebApplicationContext springContext;

    public ContentBundle(final AnnotationConfigWebApplicationContext context) {
        this.springContext = context;
    }

    @Override
    public void run(T configuration, Environment environment) throws Exception {
        registerResources(environment, springContext);
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {

    }


    private void registerResources(Environment environment, AnnotationConfigWebApplicationContext context) {
        context.register(InfinispanCacheConfig.class, ContentSpringContext.class, MetricsRegistryConfig.class);
        context.refresh();

        final Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(Path.class);
        for (final String beanName : beansWithAnnotation.keySet()) {
            final Object resource = beansWithAnnotation.get(beanName);
            environment.jersey().register(resource);
        }
    }
}
