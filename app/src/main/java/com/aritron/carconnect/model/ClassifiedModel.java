package com.aritron.carconnect.model;

/**
 * Created by Komal on 04-04-2017.
 */

public class ClassifiedModel {
    private int image;
    private String name,desc,price;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ClassifiedModel(int image, String name, String desc, String price) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
}
