package com.bits.r8d.content.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexl on 20/06/2014.
 */
public class ProductInstance {

    @NotNull
    private final String productId;

    @NotNull
    private final String posName;

    private final Map<Price.Type, Price> prices;

    public ProductInstance(final ProductDefinition productDefinition, final Price price) {
        this(productDefinition.getProductId(), productDefinition.getPosName(), price);
    }

    @JsonCreator
    public ProductInstance(@JsonProperty("productId") final String productId,
                           @JsonProperty("posName") final String posName,
                           @JsonProperty("retailerNormalPrice") final Price retailerNormalPrice) {
        this.productId = productId;
        this.posName = posName;
        this.prices = new HashMap<Price.Type, Price>();
        this.prices.put(retailerNormalPrice.getType(), retailerNormalPrice);
    }

    public String getProductId() {
        return productId;
    }

    public Price getRetailerNormalPrice() {
        return this.prices.get(Price.Type.RETAILER_NORMAL_PRICE);
    }

    public Map<Price.Type, Price> getPrices() {
        return prices;
    }
}
