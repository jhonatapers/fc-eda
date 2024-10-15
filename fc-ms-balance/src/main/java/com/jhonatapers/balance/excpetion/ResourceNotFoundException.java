package com.jhonatapers.balance.excpetion;

public class ResourceNotFoundException extends RuntimeException {

    protected <T> ResourceNotFoundException(T clazz, String id) {
        super("resource not found: " + clazz.getClass().getSimpleName() + " with id: " + id);
    }

}
