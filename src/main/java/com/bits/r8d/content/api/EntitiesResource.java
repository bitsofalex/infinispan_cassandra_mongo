package com.bits.r8d.content.api;

import com.bits.r8d.content.domain.Entity;
import org.infinispan.Cache;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexl on 20/06/2014.
 */
@Component
@Path("/entities")
public class EntitiesResource {

    private Cache<String, Entity> entitiesCache;

    public EntitiesResource() {
    }

    @GET
    @Produces("application/json")
    public List<Entity> getEntities() {
        final List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity("1234"));
        // todo get entities (cached)
        // todo filter entities
        return entities;
    }

    @Path("{entityId}")
    public EntityResource getEntity(@PathParam("entityId") final String entityId) {
        return new EntityResource(entityId);
    }

}
