package com.aritron.carconnect.model;

import java.util.ArrayList;

/**
 * Created by Komal on 17-04-2017.
 */

public class CompareList {
    private ArrayList<CompareCarsModel> compareCarsModelArrayList;

    public ArrayList<CompareCarsModel> getCompareCarsModelArrayList() {
        return compareCarsModelArrayList;
    }

    public void setCompareCarsModelArrayList(ArrayList<CompareCarsModel> compareCarsModelArrayList) {
        this.compareCarsModelArrayList = compareCarsModelArrayList;
    }

    public int getsize() {
        return this.compareCarsModelArrayList.size();
    }

    public CompareCarsModel getdata(int i) {
        return this.compareCarsModelArrayList.get(i);
    }

    public boolean adddata(CompareCarsModel s) {
        return this.compareCarsModelArrayList.add(s);
    }
}
