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

    @Column(name="modelYear")
    private String modelYear;

    @Column(name="brand")
    private String brand;

    @Column(name="Airflow")
    private int Airflow;

    @Column(name="maxPower")
    private int maxPower;

    @Column(name="sound")
    private int sound;

    @Column(name="diameter")
    private int diameter;

    @Column(name="height")
    private int height;

    @Column (name="manufacturer")
    private String manufacturer;

    @Column (name="series")
    private String series;

    @Column (name="model")
    private String model;

    @Column (name="useType")
    private String useType;

    @Column (name="application")
    private String application;

    @Column (name="mountLocation")
    private String mountLocation;


    @Column(name="price")
    private int price;

    @Column(name="type")
    private String type;

    @Column(name="image")
    private String image;



//    @ManyToOne(targetEntity = User.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//    @JoinColumn(name="UserProduct_FK", nullable = false,referencedColumnName ="userID")
//    private User user;


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

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAirflow() {
        return Airflow;
    }

    public void setAirflow(int airflow) {
        Airflow = airflow;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMountLocation() {
        return mountLocation;
    }

    public void setMountLocation(String mountLocation) {
        this.mountLocation = mountLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    //    public User getUser() {
//        if(this.user != null)
//            this.user.setProducts(new HashSet<>());
//        return this.user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
