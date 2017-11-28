package com.example.tcox.recyclercreation.viewholders;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.interfaces.IListener;
import com.example.tcox.recyclercreation.models.Advertisement;

/**
 * Created by tcox on 11/14/17.
 */

public class AdViewHolder extends RecyclerView.ViewHolder{

    private TextView mAdViewLayout;
    private Context mContext;


    public AdViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mAdViewLayout = (TextView) itemView.findViewById(R.id.ad_color);


    }

    public void bind(final Advertisement advertisement, final IListener adListener){
        mAdViewLayout.setBackgroundColor(Color.parseColor(advertisement.getColor()));
        mAdViewLayout.setVisibility(View.VISIBLE);
        mAdViewLayout.setText(advertisement.getCompany());
        mAdViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adListener.onAdListener(advertisement);
            }
        });


    }


}
