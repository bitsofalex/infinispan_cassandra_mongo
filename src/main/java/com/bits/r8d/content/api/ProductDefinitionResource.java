package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.ProductDefinition;

import javax.ws.rs.*;

/**
 * Created by alexl on 20/06/2014.
 */
public class ProductDefinitionResource {

    private final String productId;

    public ProductDefinitionResource(final String entityId) {
        this.productId = entityId;
    }

    @GET
    @Produces("application/json")
    public ProductDefinition getEntity() {
        // todo find entity by id
        return new ProductDefinition(productId, "test product");
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ProductDefinition postProductDefinition(@PathParam("productId") final String productId,
                                                   ProductDefinition productDefinition) {
        return productDefinition;
    }
}
