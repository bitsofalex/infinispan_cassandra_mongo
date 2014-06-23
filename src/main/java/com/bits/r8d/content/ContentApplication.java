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
//        Configuration configuration = contentConfiguration.getInfinispanConfigurationBuilder()
//                .clustering()
//                .cacheMode(CacheMode.DIST_ASYNC)
//                .sync()
//                .build();
//        DefaultCacheManager cacheManager = new DefaultCacheManager();
        // registerResources(environment, cacheManager);
    }

//    private void registerResources(final Environment environment, final DefaultCacheManager cacheManager) {
//        final EntitiesResource entitiesResource = new EntitiesResource(cacheManager.getCache("entities"));
//        final ProductsResource productsResource = new ProductsResource(cacheManager.getCache("products"));
//        final ProductDefinitionsResource productDefinitionsResource = new ProductDefinitionsResource();
//        environment.jersey().register(entitiesResource);
//        environment.jersey().register(productsResource);
//        environment.jersey().register(productDefinitionsResource);
//    }

}
