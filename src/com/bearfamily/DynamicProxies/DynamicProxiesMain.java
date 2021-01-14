package com.bearfamily.DynamicProxies;

public class DynamicProxiesMain {
    public static void main(String[] args) {

        IUserServiceImpl userService = new IUserServiceImpl();

        ProxyFactory factory = new ProxyFactory(userService,IUserService.class);
        IUserService proxy = (IUserService) factory.createProxyInstance();
        proxy.greeting("Tim");

    }
}
