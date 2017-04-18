package com.aritron.carconnect.model;

/**
 * Created by Komal on 11-04-2017.
 */

public class VariantModel {
    String name,feature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public VariantModel(String name, String feature) {
        this.name = name;
        this.feature = feature;
    }
}
