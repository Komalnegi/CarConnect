package com.aritron.carconnect.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Komal on 03-04-2017.
 */

public class NewCars {
    private int imageView;
    private String name,cc,speed,cost,rate;

    public NewCars(int imageView, String name, String cc, String speed, String cost, String rate) {
        this.imageView = imageView;
        this.name = name;
        this.cc = cc;
        this.speed = speed;
        this.cost = cost;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
