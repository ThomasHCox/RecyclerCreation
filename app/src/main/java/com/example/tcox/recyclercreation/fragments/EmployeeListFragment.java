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
import android.widget.Toast;

import com.example.tcox.recyclercreation.EmployeeRecyclerAdapter;
import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.interfaces.ICallBackEvent;
import com.example.tcox.recyclercreation.interfaces.IMobileDataTaskCompletedListener;
import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.example.tcox.recyclercreation.tasks.GetMobileDataTask;

import java.util.ArrayList;
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

    public void setContent(List<MobileEngineer> aMobileEngineers){
        if (aMobileEngineers.size() != 0) {
            mAdapter.updateAdapter(aMobileEngineers);
        }
    }


}
