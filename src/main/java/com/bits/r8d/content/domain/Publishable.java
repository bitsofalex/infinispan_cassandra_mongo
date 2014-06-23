package com.bits.r8d.content.domain;

/**
 * Created by alexl on 20/06/2014.
 */
public interface Publishable {

    Boolean isStaged();

    Boolean isLive();

    Boolean isDeprecated();

    void publishToProduction();

    void deprecate();
}
