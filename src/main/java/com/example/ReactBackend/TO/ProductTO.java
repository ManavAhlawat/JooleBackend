package com.example.ReactBackend.TO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTO {

    private int productID;
    private String productName;
    private UserTO user;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public UserTO getUser() {
        return user;
    }

    public void setUser(UserTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProductTO{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", user=" + user +
                '}';
    }
}
