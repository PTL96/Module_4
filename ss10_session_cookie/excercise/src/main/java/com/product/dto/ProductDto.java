package com.product.dto;

public class ProductDto {
    private int id;
    private String names;
    private double price;
    private String description;
    private String img;
    private short discount;

    public ProductDto() {
    }

    public ProductDto(int id, String names, double price, String description, String img, short discount) {
        this.id = id;
        this.names = names;
        this.price = price;
        this.description = description;
        this.img = img;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }



}
