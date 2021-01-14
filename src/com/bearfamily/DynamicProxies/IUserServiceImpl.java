package com.bearfamily.DynamicProxies;

public class IUserServiceImpl implements IUserService {
    @Override
    public void greeting(String name) {
        System.out.println("Hello" + " " +name);
    }
}
