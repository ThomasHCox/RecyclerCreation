package com.example.tcox.recyclercreation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tcox.recyclercreation.interfaces.ICallBackEvent;
import com.example.tcox.recyclercreation.interfaces.IListener;
import com.example.tcox.recyclercreation.interfaces.IMobileDataTaskCompletedListener;
import com.example.tcox.recyclercreation.models.Advertisement;
import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.example.tcox.recyclercreation.tasks.GetMobileDataTask;

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

//Homework 16
//How to make an HTTP request in Android
//Figure out HTTP verbs, specifically GET and POST
//But also PUT and DELETE
//Familiarize with the Android class ASyncTask(this is for background operations)
//Create an ASyncTask
//Make a button that executes the ASyncTask



public class MainActivity extends AppCompatActivity {
    private List<Advertisement> mList = new ArrayList<Advertisement>();
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Advertisement ads = new Advertisement("Magenta", "Walgreens");
        fetchArrayList();
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

    public void fetchArrayList(){
        GetMobileDataTask task = new GetMobileDataTask(new IMobileDataTaskCompletedListener() {
            @Override
            public void onMobileDataTaskComplete(ArrayList<MobileEngineer> aMobileEngineer) {
//                mListAdaptor.setItems(aMobileEngineer);
//                mListAdaptor.notifyDataSetChanged();
                int count = aMobileEngineer.size();
                MobileEngineer engineer = aMobileEngineer.get(0);

            }
        }, new ICallBackEvent() {
            @Override
            public void onComplete(ArrayList<MobileEngineer> aMobileEngineer) {
                
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getApplicationContext(), "There was an error", Toast.LENGTH_LONG).show();
            }
        });
        task.execute();

    }

}
