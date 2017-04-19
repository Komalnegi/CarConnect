
/**
 *
 */
package com.aritron.carconnect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.aritron.carconnect.Constant;
import com.aritron.carconnect.R;
import com.aritron.carconnect.model.NavDrawerItem;

import java.util.Collections;
import java.util.List;


/**
 * @author Renovate
 */
public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.NavViewHolder> {

    private Context context;
    private List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;


    public NavDrawerAdapter(Context context, List<NavDrawerItem> data) {
        super();
        this.context = context;
        this.data = data;
        // this.headerTitle = headerTitle;
        inflater = LayoutInflater.from(context);
    }

    class NavViewHolder extends RecyclerView.ViewHolder {

        int holderId;
        TextView titleHeader, titleNavItem, textview_mobile_no;
        ImageView imageViewIcon;
        LinearLayout top;

        public NavViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == Constant.TYPE_HEADER) {
                /**
                 * for Header
                 */

                titleHeader = (TextView) itemView.findViewById(R.id.textView_nav_header);

                holderId = 0;
            } else {
                /*
				 * for Nav Item
				 */
                top = (LinearLayout) itemView.findViewById(R.id.top);
                titleNavItem = (TextView) itemView.findViewById(R.id.textView_nav_row);
                imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView_icon);
                holderId = 1;
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //top.setBackgroundColor(Color.parseColor("#E7AD28"));
                }
            });
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return Constant.TYPE_HEADER;

        return Constant.TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        // set position index when header will be shown
        // if (position == 0 || position == 9)
        // return true;
        return false;
    }

    @Override
    public int getItemCount() {
        return data.size()/* +headerTitle.length */;
    }

    @Override
    public void onBindViewHolder(NavViewHolder holder, int position) {
        NavDrawerItem item = data.get(position);

        if (holder.holderId == Constant.TYPE_HEADER) {
            // for Nav Header
            holder.titleHeader.setText(item.getNavItem());
        } else {
            // for Nav row Item
            holder.titleNavItem.setText(item.getNavItem());
            holder.imageViewIcon.setImageResource(item.getIconId());// (R.);;//ImageResource(item.getIconId())


        }
    }

    @Override
    public NavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Constant.TYPE_HEADER) {
            // for Nav Header
            View viewHeader = inflater.inflate(R.layout.nav_row_header, parent, false);
            NavViewHolder headerholder = new NavViewHolder(viewHeader, viewType);
            return headerholder;

        } else if (viewType == Constant.TYPE_ITEM) {
            // for Nav row Item
            View viewItem = inflater.inflate(R.layout.nav_row_item, parent, false);
            NavViewHolder itemHolder = new NavViewHolder(viewItem, viewType);
            return itemHolder;

        }
        return null;
    }
}
