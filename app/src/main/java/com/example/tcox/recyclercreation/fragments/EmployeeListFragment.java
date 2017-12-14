package com.example.tcox.recyclercreation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcox.recyclercreation.EmployeeRecyclerAdapter;
import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.models.MobileEngineer;

import java.util.List;

/**
 * Created by tcox on 12/6/17.
 */

public class EmployeeListFragment extends Fragment {
    private View mRootView;
    private RecyclerView mRecyclerView;
    private EmployeeRecyclerAdapter mAdapter;
    private Context mContext;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_employee_list, container, false);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new EmployeeRecyclerAdapter(mContext);

        mRecyclerView.setAdapter(mAdapter);

        return mRootView;

    }

    public void setContent(List<MobileEngineer> mobileEngineers){
        if (mobileEngineers != null && mobileEngineers.size() > 0) {
            mAdapter.updateAdapter(mobileEngineers);
        }
    }


}
