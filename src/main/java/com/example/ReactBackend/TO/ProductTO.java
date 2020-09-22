package com.example.ReactBackend.TO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTO {

    private int productID;
    private String productName;
    private String modelYear;
    private String brand;
    private int Airflow;
    private int maxPower;
    private int sound;
    private int diameter;
    private int height;
    private String manufacturer;
    private String series;
    private String model;
    private String useType;
    private String application;
    private String mountLocation;
    private int price;
    private String type;
    private String image;

//    private UserTO user;

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
    //    public UserTO getUser() {
//        return user;
//    }
//
//    public void setUser(UserTO user) {
//        this.user = user;
//    }


    @Override
    public String toString() {
        return "ProductTO{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", brand='" + brand + '\'' +
                ", Airflow=" + Airflow +
                ", maxPower=" + maxPower +
                ", sound=" + sound +
                ", diameter=" + diameter +
                ", height=" + height +
                ", manufacturer='" + manufacturer + '\'' +
                ", series='" + series + '\'' +
                ", model='" + model + '\'' +
                ", useType='" + useType + '\'' +
                ", application='" + application + '\'' +
                ", mountLocation='" + mountLocation + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
