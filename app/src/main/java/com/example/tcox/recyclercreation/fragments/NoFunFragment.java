package com.example.tcox.recyclercreation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.interfaces.IFragmentCallBack;

/**
 * Created by tcox on 12/15/17.
 */

public class NoFunFragment extends Fragment{

    private static IFragmentCallBack mIFragmentCallBack;
    public NoFunFragment() {
        //Possibly required constructor
    }

    public static NoFunFragment getInstance(IFragmentCallBack iFragmentCallBack){
        NoFunFragment noFunFragment = new NoFunFragment();
        noFunFragment.mIFragmentCallBack = iFragmentCallBack;
        return  noFunFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_no_fun, container, false);
        Button button = (Button) rootView.findViewById(R.id.button_start_fun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIFragmentCallBack.onFunChanged();
            }
        });

        return rootView;
    }
}
