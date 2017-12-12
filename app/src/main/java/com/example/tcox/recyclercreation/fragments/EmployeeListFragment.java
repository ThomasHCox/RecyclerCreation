package com.example.tcox.recyclercreation.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcox.recyclercreation.EmployeeRecyclerAdapter;
import com.example.tcox.recyclercreation.R;

/**
 * Created by tcox on 12/6/17.
 */

public class EmployeeListFragment extends Fragment {
    private View mRootView;
    private RecyclerView mRecyclerView;
    private EmployeeRecyclerAdapter mAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_employee_list, container, false);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        mAdapter = new EmployeeRecyclerAdapter(this.getContext());
        mRecyclerView.setAdapter(mAdapter);
        return mRootView;

    }
//
//    private void recyclerViewSetup() {
//      //  RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//
//    }

}
