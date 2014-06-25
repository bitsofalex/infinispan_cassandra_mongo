package com.bits.r8d.content.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexl on 20/06/2014.
 */
public class ProductInstance extends Publishable implements Serializable {

    @NotNull
    private final String productId;

    @NotNull
    private final String posName;

    private final Map<Price.Type, Price> prices;

    @JsonCreator
    public ProductInstance(@JsonProperty("productId") final String productId,
                           @JsonProperty("posName") final String posName,
                           @JsonProperty("retailerNormalPrice") final Price retailerNormalPrice,
                           @JsonProperty("state") final State state) {
        this.productId = productId;
        this.posName = posName;
        this.prices = new HashMap<Price.Type, Price>();
        this.prices.put(retailerNormalPrice.getType(), retailerNormalPrice);
        setState(state);
    }

    public String getProductId() {
        return productId;
    }

    public Map<Price.Type, Price> getPrices() {
        return prices;
    }
}
