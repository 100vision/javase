package com.bearfamily.LamdaExpression;

import com.bearfamily.Common.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * lambda表达式其实就是匿名方法的简洁表达。可以预测到参数的类型和内部方法名
 * 1、lambda形式:  匿名方法名((x,y) -> {lambda方法体}
 * 如何使用：
 * 1.1 当匿名方法的参数只有一个，可以在lambda表达式中省略。() -> {lambda方法体} 。 如果有两个以上，不可以省略；
 * 1.2 当内部方法体里只有一条语句，可以声调大括号{}
 */
public class LamdaExprMain {

    public static void main(String[] args) {
        Map<String,Product> mapProduct = new HashMap<String, Product>();
        mapProduct.put("Symantec",new Product("p1","airpods",10));
        mapProduct.put("IBM",new Product("p2","iPhone 6s 64GB",2));
        mapProduct.put("Huawei",new Product("p3","iPhone XR 192GB",5));
        mapProduct.put("HP",new Product("p4","iWatch OS9",4));

        //use lambda to loop through the product collection
        //set<Integer> setProduct= mapProduct.keySet();
        mapProduct.forEach((k, p) -> System.out.println(k+":"+p.getProductName()));

        //or use keyset's foreach method to loop through

        System.out.println("-------------------------");

        Set<String> productKeySet = mapProduct.keySet();
        productKeySet.stream().filter(x->x.equals("IBM")).forEach(x -> System.out.println(x + ":" +mapProduct.get(x).getProductName()));

        System.out.println("-------------------------");
        //
        Collection<Product> productValueSet = mapProduct.values();
        productValueSet.stream().filter(product -> product.getStock()<10).map(product ->product.getProductName()).forEach(System.out::println);



    }



}
