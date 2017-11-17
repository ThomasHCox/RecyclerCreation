package com.example.tcox.recyclercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tcox.recyclercreation.interfaces.IListener;
import com.example.tcox.recyclercreation.model.Advertisement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Homework 14
//Make the ads created dynamically

//Homework 15
//Create an ad layout that is a relative layout
//It needs to have the name of the company
//2 text views, an image view, and a button
//Image centered in the middle
//text view in the upper left
//button in the lower left
//text view centered right
public class MainActivity extends AppCompatActivity {
    private List<Advertisement> mList = new ArrayList<Advertisement>();
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Advertisement ads = new Advertisement("Magenta", "Walgreens");
        mList.add(createAd());
        mList.add(createAd());
        mList.add(createAd());
        mList.add(createAd());
        mList.add(createAd());
        mList.add(createAd());
        mList.add(createAd());
        mList.add(createAd());
//        ads = new Advertisement("Yellow", "CVS");
//        mList.add(ads);
////        ads = new Advertisement("Green", "Duane Reade");
//        mList.add(ads);
////        ads = new Advertisement("Blue", "Walmart");
//        mList.add(ads);
////        ads = new Advertisement("Red", "Target");
//        mList.add(ads);
        recyclerViewSetup();
        mAdapter.updateAdapter(mList);
    }

    private void recyclerViewSetup(){
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RecyclerAdapter(this, new IListener() {
            @Override
            public void onAdListener(Advertisement advertisement) {
//                Intent intent = new Intent(getApplicationContext(), ViewAdActivity.class);
//                intent.putExtra("AdvertisementParcel", advertisement);
//                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public Advertisement createAd(){
        List<String> adColors = new ArrayList<>();
        List<String> adCompany = new ArrayList<>();

        adColors.add("Magenta");
        adColors.add("Yellow");
        adColors.add("Green");
        adColors.add("Blue");
        adColors.add("Red");

        adCompany.add("Walgreens");
        adCompany.add("CVS");
        adCompany.add("Duane Reade");
        adCompany.add("Walmart");
        adCompany.add("Target");

        Random rnd = new Random();

        Advertisement ads = new Advertisement((adColors.get(rnd.nextInt(adColors.size()))), (adCompany.get(rnd.nextInt(adCompany.size()))));
        return ads;
    }
}
