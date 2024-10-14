package com.jhonatapers.accounts.event;

public interface Event<P> {

    String name();

    P payload();

}
