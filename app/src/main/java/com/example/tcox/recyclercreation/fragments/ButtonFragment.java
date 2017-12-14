package com.example.tcox.recyclercreation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.activities.funWithFragmentsActivity;

/**
 * Created by tcox on 12/13/17.
 */

public class ButtonFragment extends Fragment {
    private View mRootView;
    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_button_layout, container, false);
        mButton = (Button) mRootView.findViewById(R.id.simple_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), funWithFragmentsActivity.class);
                startActivity(intent);
            }
        });


        return mRootView;

    }
}
