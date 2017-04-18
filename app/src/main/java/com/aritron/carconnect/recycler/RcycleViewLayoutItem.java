package com.aritron.carconnect.recycler;

import android.view.View;

/**
 * Created by user on 27-01-2017.
 */

public class RcycleViewLayoutItem <T> {

    public int viewId;
    private String layoutItemName;
    private DisplayLayoutItem<T> displayFunction;
    private LayoutItemClickListner<T> clickFunction;


    public RcycleViewLayoutItem(String layoutItemName,
                                int viewId,
                                DisplayLayoutItem<T> displayFunction,
                                LayoutItemClickListner<T> clickFunction) {
        this.layoutItemName = layoutItemName;
        this.viewId = viewId;
        this.displayFunction = displayFunction;
        this.clickFunction = clickFunction;
    }

    public void generateLayoutItemDisplay (View view, Object listObject) {
        if (displayFunction != null) {
            displayFunction.displayLayoutItem(view, (T)listObject);
        }
    }

    public void handleLayoutItemClick (View view, final Object listObject) {
        if (clickFunction != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickFunction.layoutItemOnClick((T)listObject);
                }
            });
        }
    }

    public interface DisplayLayoutItem<T> {
        void displayLayoutItem(View view, T listObject);
    }

    public interface LayoutItemClickListner<T> {
        void layoutItemOnClick(T listObject);
    }
}
