package com.example.lab1_2_rohanghevariya_c0847621_android;

public class ProductModel {
    private String productName;
    private String productDescription;
    private String productPrice;
    private String product_Location;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProduct_Location() {
        return product_Location;
    }

    public void setProduct_Location(String product_Location) {
        this.product_Location = product_Location;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    private int prodid;

    public ProductModel(String productName, String productDescription, String productPrice, String product_Location) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.product_Location = product_Location;
        this.prodid = prodid;
    }
}
