package com.example.ReactBackend.Entity;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name="productID")
    private int productID;

    @Column(name="productName")
    private String productName;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="UserProduct_FK", nullable = false,referencedColumnName ="userID")
    private User user;

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

    public User getUser() {
        if(this.user != null)
            this.user.setProducts(new HashSet<>());
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
