package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.ProductInstance;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alexl on 20/06/2014.
 */
public class PriceResource {

    private Cache<String, ProductInstance> productInstanceCache;

    @Autowired
    public PriceResource(EmbeddedCacheManager cacheManager) {
        this.productInstanceCache = productInstanceCache;
    }
}
