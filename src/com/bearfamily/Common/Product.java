package com.bearfamily.Common;

import java.util.Objects;

public class Product {
    private String productId;
    private String productName;
    private int stock;

    public Product(String productId, String productName, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        /*
        Product product = (Product) o;
        return stock == product.stock &&
                productId.equals(product.productId) &&
                productName.equals(product.productName);

         */
        return  false;
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, stock);
    }

     */



    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                '}';
    }
}
