package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.Price;
import com.bits.r8d.content.domain.ProductInstance;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response.Status;
import java.util.Map;
import java.util.Optional;

/**
 * Created by alexl on 20/06/2014.
 */
@Component
public class PricesResource {

    private Cache<String, ProductInstance> productsCache;

    private String productId;

    @Autowired
    public PricesResource(EmbeddedCacheManager cacheManager) {
        this.productsCache = cacheManager.getCache("products");
    }

    @GET
    @Produces("application/json")
    public Map<Price.Type, Price> getPrices(@PathParam("productId") final String productId) {
        return Optional.ofNullable(productsCache.get(productId))
                .map(p -> p.getPrices())
                .orElseThrow(() -> new WebApplicationException(Status.NOT_FOUND));
    }

    @POST
    @Produces("application/json")
    public Price postPrice(@PathParam("productId") final String productId,
                                     final Price price) {
        return Optional.ofNullable(productsCache.get(productId))
                .map(pi -> pi.getPrices().put(price.getType(), price))
                .orElseThrow(() -> new WebApplicationException(Status.BAD_REQUEST));
    }
}
