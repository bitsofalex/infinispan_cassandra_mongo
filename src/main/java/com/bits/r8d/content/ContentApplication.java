package com.bits.r8d.content;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by alexl on 20/06/2014.
 */
public class ContentApplication extends Application<ContentConfiguration> {

    private final AnnotationConfigWebApplicationContext contentContext = new AnnotationConfigWebApplicationContext();

    public static void main(String[] args) throws Exception {
        new ContentApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ContentConfiguration> contentConfigurationBootstrap) {
        contentConfigurationBootstrap.addBundle(new ContentBundle<ContentConfiguration>(contentContext));
    }

    @Override
    public void run(final ContentConfiguration contentConfiguration, final Environment environment) throws Exception {
    }

}
