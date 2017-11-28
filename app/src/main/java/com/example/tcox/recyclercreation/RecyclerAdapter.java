package com.example.tcox.recyclercreation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcox.recyclercreation.interfaces.IListener;
import com.example.tcox.recyclercreation.models.Advertisement;
import com.example.tcox.recyclercreation.viewholders.AdViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tcox on 11/14/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Advertisement> mList = new ArrayList<>();
    private Context mContext;
    private IListener mAdListener;

    public RecyclerAdapter(Context context, IListener adListener) {
        this.mContext = context;
        mAdListener = adListener;
    }

    public void updateAdapter(List<Advertisement> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v;
        v=inflater.inflate(R.layout.viewholder_ad, parent, false);
        AdViewHolder holder = new AdViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AdViewHolder) holder).bind(mList.get(position), mAdListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
