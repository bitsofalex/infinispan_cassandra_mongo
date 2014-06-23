package com.bits.r8d.content;

import org.infinispan.manager.DefaultCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexl on 23/06/2014.
 */
@Configuration
public class InfinispanCacheConfig {

    @Bean
    public DefaultCacheManager getCacheManager() {
        return new DefaultCacheManager();
    }
}
