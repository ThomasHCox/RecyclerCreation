package com.example.tcox.recyclercreation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.fragments.FunFragment;
import com.example.tcox.recyclercreation.fragments.NoFunFragment;
import com.example.tcox.recyclercreation.interfaces.IFragmentCallBack;

/**
 * Created by tcox on 12/13/17.
 */

public class FunWithFragmentsActivity extends AppCompatActivity {
    private static final String TAG = FunWithFragmentsActivity.class.getSimpleName();
    private FunFragment mFunFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        mFunFragment = FunFragment.getInstance(new IFragmentCallBack() {
            @Override
            public void onFunChanged() {
                final NoFunFragment noFunFragment = NoFunFragment.getInstance(new IFragmentCallBack() {
                    @Override
                    public void onFunChanged() {
//                        getSupportFragmentManager().popBackStack();
                        if (mFunFragment != null) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_fwf, mFunFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                                    commit();
                        }else{
                            Log.d(TAG, "You hit the Null");
                        }
                    }
                });
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_fwf, noFunFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                        commit();
                Log.i(TAG, "The button was clicked");

            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_fwf, mFunFragment).commit();


    }
}
