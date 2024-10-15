package com.jhonatapers.balance.event;

public interface Event<P> {

    String name();

    P payload();

}
