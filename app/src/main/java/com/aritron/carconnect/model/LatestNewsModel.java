package com.aritron.carconnect.model;

/**
 * Created by Komal on 04-04-2017.
 */

public class LatestNewsModel {
    private int car_image;
    private String car_name,news_date;

    public int getCar_image() {
        return car_image;
    }

    public void setCar_image(int car_image) {
        this.car_image = car_image;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public LatestNewsModel(int car_image, String car_name, String news_date) {
        this.car_image = car_image;
        this.car_name = car_name;
        this.news_date = news_date;
    }
}
