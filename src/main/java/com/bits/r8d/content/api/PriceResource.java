package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.ProductInstance;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alexl on 20/06/2014.
 */
public class PriceResource {

    private DefaultCacheManager cacheManager;

    private Cache<String, ProductInstance> productInstanceCache;

    @Autowired
    public PriceResource(DefaultCacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.productInstanceCache = productInstanceCache;
    }
}
