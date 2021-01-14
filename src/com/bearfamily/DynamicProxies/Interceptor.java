package com.bearfamily.DynamicProxies;

public interface Interceptor {
    Boolean before(Object target);
    Boolean around(Object target);
    Boolean after(Object target);
}
