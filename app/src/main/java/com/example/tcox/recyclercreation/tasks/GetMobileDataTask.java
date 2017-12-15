package com.example.tcox.recyclercreation.tasks;

import android.os.AsyncTask;

import com.example.tcox.recyclercreation.interfaces.ICallBackEvent;
import com.example.tcox.recyclercreation.interfaces.IMobileDataTaskCompletedListener;
import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.example.tcox.recyclercreation.parsers.MobileEngineerParser;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tcox on 11/28/17.
 */

public class GetMobileDataTask extends AsyncTask<Void, Void, ArrayList<MobileEngineer>> {

    private IMobileDataTaskCompletedListener iMobileDataTaskCompletedListener;
    private ICallBackEvent mCallBackEvent;
    private OkHttpClient client = new OkHttpClient();

    private final String TAG = GetMobileDataTask.class.getSimpleName();

    public GetMobileDataTask(IMobileDataTaskCompletedListener mListener, ICallBackEvent callBackEvent) {
        iMobileDataTaskCompletedListener = mListener;
        mCallBackEvent = callBackEvent;
    }


    @Override
    protected ArrayList<MobileEngineer> doInBackground(Void... params) {
        String url = "http://img.staging.medscape.com/pi/iphone/AndroidLearning.json";
        String responseData;
        responseData = null;
        try {
            responseData = run(url);
        } catch (Exception e) {
            mCallBackEvent.onError(e);
            e.printStackTrace();
        }

        MobileEngineerParser parser = new MobileEngineerParser();

        try {
            return parser.parse(responseData);
        } catch (JSONException e) {
            mCallBackEvent.onError(e);
            e.printStackTrace();
            return null;
        }
    }


    protected String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected void onPostExecute(ArrayList<MobileEngineer> aList) {
        super.onPostExecute(aList);
//        iMobileDataTaskCompletedListener.onMobileDataTaskComplete(aList);
        mCallBackEvent.onComplete(aList);
    }


}
