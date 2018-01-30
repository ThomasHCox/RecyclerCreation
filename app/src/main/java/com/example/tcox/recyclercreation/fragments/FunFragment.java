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

public class FunFragment extends Fragment {

    private static IFragmentCallBack mIFragmentCallBack;

    public FunFragment() {
//        Required empty constructor
    }

    public static FunFragment getInstance(IFragmentCallBack iFragmentCallBack){
        FunFragment funFragment = new FunFragment();
        funFragment.mIFragmentCallBack = iFragmentCallBack;
        return funFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fun, container, false);
        Button button = (Button) rootView.findViewById(R.id.button_stop_fun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIFragmentCallBack.onFunChanged();
            }
        });



        return rootView;

    }

}
