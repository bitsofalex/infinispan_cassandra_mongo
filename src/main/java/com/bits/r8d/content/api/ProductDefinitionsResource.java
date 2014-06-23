package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.ProductDefinition;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by alexl on 20/06/2014.
 */
@Path("/product_definitions")
public class ProductDefinitionsResource {

    public ProductDefinitionsResource() {
    }

    @GET
    @Produces("application/json")
    public List<ProductDefinition> getProductDefinitions() {
        return null;
    }

    @Path("{productId}")
    public ProductDefinitionResource getEntity(@PathParam("productId") final String productId) {
        return new ProductDefinitionResource(productId);
    }
}
