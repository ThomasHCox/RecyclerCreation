package com.example.tcox.recyclercreation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.example.tcox.recyclercreation.viewholders.EmployeeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tcox on 12/1/17.
 */

public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<MobileEngineer> mList = new ArrayList<>();


    public EmployeeRecyclerAdapter(Context context) {
        mContext = context;

    }

    public void updateAdapter(List<MobileEngineer> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v;
        v = inflater.inflate(R.layout.employees, parent, false);
        EmployeeViewHolder holder = new EmployeeViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((EmployeeViewHolder) holder).bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
