package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.ProductInstance;
import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.Collection;

/**
 * Created by alexl on 20/06/2014.
 */
@Component
@Path("/products")
public class ProductsResource {

    private DefaultCacheManager cacheManager;

    private Cache<String, ProductInstance> productsCache;

    @Autowired
    private ProductResource productResource;

    @Autowired
    public ProductsResource(DefaultCacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.productsCache = cacheManager.getCache("products");
    }

    @GET
    @Produces("application/json")
    public Collection<ProductInstance> getProducts() {
        cacheManager.getCache();
        return productsCache.values();
    }

    @Path("/{productId}")
    public ProductResource getEntity(@PathParam("productId") final String productId) {
        return productResource;
    }

    public void setProductResource(ProductResource productResource) {
        this.productResource = productResource;
    }
}
