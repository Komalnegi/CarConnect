package com.aritron.carconnect.model;

/**
 * Created by Komal on 11-04-2017.
 */

public class ModelSelectionModel {
    private String mModelName,mModelCost;

    public String getmModelName() {
        return mModelName;
    }

    public void setmModelName(String mModelName) {
        this.mModelName = mModelName;
    }

    public String getmModelCost() {
        return mModelCost;
    }

    public void setmModelCost(String mModelCost) {
        this.mModelCost = mModelCost;
    }

    public ModelSelectionModel(String mModelName, String mModelCost) {
        this.mModelName = mModelName;
        this.mModelCost = mModelCost;
    }
}
