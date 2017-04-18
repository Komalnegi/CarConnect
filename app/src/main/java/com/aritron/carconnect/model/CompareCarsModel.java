package com.aritron.carconnect.model;

/**
 * Created by Komal on 17-04-2017.
 */

public class CompareCarsModel {
    private int mCarImage;
    private String mCarName,mVariantName,mCarCost,mCarFuel;

    public CompareCarsModel(int mCarImage, String mCarName, String mVariantName, String mCarCost, String mCarFuel) {
        this.mCarImage = mCarImage;
        this.mCarName = mCarName;
        this.mVariantName = mVariantName;
        this.mCarCost = mCarCost;
        this.mCarFuel = mCarFuel;
    }

    public int getmCarImage() {
        return mCarImage;
    }

    public void setmCarImage(int mCarImage) {
        this.mCarImage = mCarImage;
    }

    public String getmCarName() {
        return mCarName;
    }

    public void setmCarName(String mCarName) {
        this.mCarName = mCarName;
    }

    public String getmVariantName() {
        return mVariantName;
    }

    public void setmVariantName(String mVariantName) {
        this.mVariantName = mVariantName;
    }

    public String getmCarCost() {
        return mCarCost;
    }

    public void setmCarCost(String mCarCost) {
        this.mCarCost = mCarCost;
    }

    public String getmCarFuel() {
        return mCarFuel;
    }

    public void setmCarFuel(String mCarFuel) {
        this.mCarFuel = mCarFuel;
    }
}
