package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.ProductInstance;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by alexl on 20/06/2014.
 */
@Component
public class ProductResource {

    @Autowired
    private PricesResource pricesResource;

    @Autowired
    private MongoOperations mongoOperations;

    private Cache<String, ProductInstance> productsCache;

    @Autowired
    public ProductResource(DefaultCacheManager cacheManager) {
        this.productsCache = cacheManager.getCache("products");
    }

    @GET
    @Produces("application/json")
    public ProductInstance getProductInstance(@PathParam("productId") final String productId) {
        return Optional.ofNullable(productsCache.get(productId))
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postProduct(@PathParam("productId") final String productId,
                                       final ProductInstance productInstance) {
        mongoOperations.save(productInstance);
        if (productInstance.isLive()) {
            productsCache.putIfAbsent(productId, productInstance);
        }
        return Response.ok(productInstance)
                .build();
    }

    @Path("prices")
    public PricesResource getPrices() {
        return pricesResource;
    }

    public void setPricesResource(PricesResource pricesResource) {
        this.pricesResource = pricesResource;
    }

    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
}
