package com.example.tcox.recyclercreation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.fragments.FunFragment;
import com.example.tcox.recyclercreation.interfaces.IFragmentCallBack;

/**
 * Created by tcox on 12/13/17.
 */

public class FunWithFragmentsActivity extends AppCompatActivity {
    private static final String TAG = FunWithFragmentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        FunFragment funFragment = FunFragment.getInstance(new IFragmentCallBack() {
            @Override
            public void onFunChanged() {
                Log.i(TAG, "The button was clicked");

            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_fwf, funFragment).commit();


    }
}
