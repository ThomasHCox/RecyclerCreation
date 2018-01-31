package com.example.tcox.recyclercreation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.models.MobileEngineer;

/**
 * Created by nbhatia on 1/30/18.
 */

public class ContactActivity extends AppCompatActivity {

    private MobileEngineer mEngineer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            mEngineer = b.getParcelable("Engineer");
            updateUIForScreen();
        }
    }

    private void updateUIForScreen ()
    {
        //TODO display the contact details
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_menu, menu);
        return true;
    }
}
