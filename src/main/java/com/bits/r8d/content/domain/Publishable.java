package com.bits.r8d.content.domain;

/**
 * Created by alexl on 20/06/2014.
 */
public abstract class Publishable {

    private State state = State.PROD;

    protected void setState(final State state) {
        this.state = state;
    }

    public Boolean isStaged() {
        return State.STAGE.equals(state);
    }

    public Boolean isLive() {
        return State.PROD.equals(state);
    }

    static enum State {
        STAGE, PROD;
    }
}
