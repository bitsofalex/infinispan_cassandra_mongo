package com.bits.r8d.content.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alexl on 20/06/2014.
 */
public class Entity {

    private final String entityId;

    @JsonCreator
    public Entity(@JsonProperty("entityId") final String entityId) {
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }
}
