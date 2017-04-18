package com.aritron.carconnect.model;

import android.widget.TextView;

/**
 * Created by Komal on 17-04-2017.
 */

public class BrandModel {
    private String mCarName;
    private int mCarImage;

    public String getmCarName() {
        return mCarName;
    }

    public void setmCarName(String mCarName) {
        this.mCarName = mCarName;
    }

    public int getmCarImage() {
        return mCarImage;
    }

    public void setmCarImage(int mCarImage) {
        this.mCarImage = mCarImage;
    }

    public BrandModel(String mCarName, int mCarImage) {
        this.mCarName = mCarName;
        this.mCarImage = mCarImage;
    }
}
