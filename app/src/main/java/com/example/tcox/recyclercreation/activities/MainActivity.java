package com.example.tcox.recyclercreation.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tcox.recyclercreation.R;
import com.example.tcox.recyclercreation.ViewPagerAdapter;
import com.example.tcox.recyclercreation.fragments.ButtonFragment;
import com.example.tcox.recyclercreation.fragments.EmployeeListFragment;
import com.example.tcox.recyclercreation.interfaces.ICallBackEvent;
import com.example.tcox.recyclercreation.interfaces.IMobileDataTaskCompletedListener;
import com.example.tcox.recyclercreation.models.Advertisement;
import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.example.tcox.recyclercreation.tasks.GetMobileDataTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Homework 14
//Make the ads created dynamically
//
//Homework 15
//Create an ad layout that is a relative layout
//It needs to have the name of the company
//2 text views, an image view, and a button
//Image centered in the middle
//text view in the upper left
//button in the lower left
//text view centered right
//
//Homework 16
//How to make an HTTP request in Android
//Figure out HTTP verbs, specifically GET and POST
//But also PUT and DELETE
//Familiarize with the Android class ASyncTask(this is for background operations)
//Create an ASyncTask
//Make a button that executes the ASyncTask
//
//Homework 17
//Make the cool looking layout with one relative layout
//Add the 3-4 line bio to all employees in JSON file
//Extra Credit: Use 3rd party library called Picaso to load the images
//
//Homework 18
//Teach Rich Git
//Comment out Recyclerview in Main, set up new RecyclerView in Fragment

//Homework 19
//Make the fragments take the lists so that it will show them.
//Create a new fragment with a simple view

//Homework 20
//Make sure everything is checked in to github
//Create a new branch off master in Github called OKHTTP Demo
//Replace existing network calls with OK HTTP
//Teach Pat how to use OK HTTP


public class MainActivity extends AppCompatActivity {
    private final int PAGE_QA = 0;
    private final int PAGE_DEV = 1;
    private final int PAGE_PRODUCT = 2;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager mViewPager;
    private EmployeeListFragment mFragmentEmployeeDev;
    private EmployeeListFragment mFragmentEmployeeQA;
    private EmployeeListFragment mFragmentEmployeeProduct;
    private ButtonFragment mButtonFragment;
    private List<MobileEngineer> mList = new ArrayList<MobileEngineer>();
    private List<MobileEngineer> mDevList = new ArrayList<>();
    private List<MobileEngineer> mQAList = new ArrayList<>();
    private List<MobileEngineer> mProductList = new ArrayList<>();
    private List<MobileEngineer> mOtherList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mFragmentEmployeeDev = new EmployeeListFragment();
        mFragmentEmployeeProduct = new EmployeeListFragment();
        mFragmentEmployeeQA = new EmployeeListFragment();
        mButtonFragment = new ButtonFragment();
        mViewPagerAdapter.addFragment(mFragmentEmployeeQA);
        mViewPagerAdapter.addFragment(mFragmentEmployeeDev);
        mViewPagerAdapter.addFragment(mFragmentEmployeeProduct);
        mViewPagerAdapter.addFragment(mButtonFragment);
        mViewPager.setOffscreenPageLimit(2);
        fetchArrayList();
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case PAGE_QA:
                        mFragmentEmployeeQA.setContent(mQAList);
                        break;
                    case PAGE_DEV:
                        mFragmentEmployeeDev.setContent(mDevList);
                        break;
                    case PAGE_PRODUCT:
                        mFragmentEmployeeProduct.setContent(mProductList);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
    }

    public void fetchArrayList() {
        GetMobileDataTask task = new GetMobileDataTask(new IMobileDataTaskCompletedListener() {
            @Override
            public void onMobileDataTaskComplete(ArrayList<MobileEngineer> aMobileEngineer) {
            }
        }, new ICallBackEvent() {
            @Override
            public void onComplete(ArrayList<MobileEngineer> aMobileEngineer) {
                mList.clear();
                mList.addAll(aMobileEngineer);
                splitResults();
                mFragmentEmployeeQA.setContent(mQAList);
                mFragmentEmployeeDev.setContent(mDevList);
                mFragmentEmployeeProduct.setContent(mProductList);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getApplicationContext(), "There was an error", Toast.LENGTH_LONG).show();
            }
        });
        task.execute();

    }

    public void splitResults() {

        for (MobileEngineer engineer : mList) {
            if (engineer.getPosition().indexOf("Develop") != -1) {
                mDevList.add(engineer);
            } else if (engineer.getPosition().indexOf("QA") != -1) {
                mQAList.add(engineer);
            } else if (engineer.getPosition().indexOf("Product") != -1) {
                mProductList.add(engineer);
            } else {
                mOtherList.add(engineer);
            }
        }

    }

    public Advertisement createAd() {
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
