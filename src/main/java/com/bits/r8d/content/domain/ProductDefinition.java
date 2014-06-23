package com.bits.r8d.content.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alexl on 20/06/2014.
 */
public class ProductDefinition {

    private String productId;

    private String posName;

    public ProductDefinition() {}

    @JsonCreator
    public ProductDefinition(@JsonProperty("productId") final String productId,
                             @JsonProperty("posName") final String posName) {
        this.productId = productId;
        this.posName = posName;
    }

    public String getProductId() {
        return productId;
    }

    public String getPosName() {
        return posName;
    }
}
