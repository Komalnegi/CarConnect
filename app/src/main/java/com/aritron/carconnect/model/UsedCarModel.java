package com.aritron.carconnect.model;

/**
 * Created by Komal on 10-04-2017.
 */

public class UsedCarModel {
    public UsedCarModel(int image, String name, String cost, String year, String speed, String fuel) {
        this.image = image;
        this.name = name;
        this.cost = cost;
        this.year = year;
        this.speed = speed;
        this.fuel = fuel;
    }

    private int image;
    private String name,cost,year,speed,fuel;

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }


}
