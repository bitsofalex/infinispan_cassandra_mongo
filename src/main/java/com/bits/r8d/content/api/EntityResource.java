package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by alexl on 20/06/2014.
 */
public class EntityResource {

    private final String entityId;

    @Autowired
    private ProductsResource productsResource;

    public EntityResource(final String entityId) {
        this.entityId = entityId;
    }

    @GET
    @Produces("application/json")
    public Entity getEntity() {
        // todo find entity by id
        return new Entity(entityId);
    }

    @Path("/products")
    public ProductsResource getProducts() {
        return productsResource;
    }
}
