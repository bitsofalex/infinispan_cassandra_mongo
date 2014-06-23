package com.bits.r8d.content.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by alexl on 20/06/2014.
 */
public class Price implements Serializable {

    @NotNull
    private Type type;

    @NotNull
    private final BigDecimal amount;

    @JsonCreator
    public Price(@JsonProperty("type") final Type type,
                 @JsonProperty("price") final BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public enum Type{
        RETAILER_NORMAL_PRICE
    }
}
