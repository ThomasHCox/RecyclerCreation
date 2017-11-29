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

/**
 * Created by tcox on 11/28/17.
 */

public class GetMobileDataTask extends AsyncTask<Void, Void, ArrayList<MobileEngineer>> {

    private IMobileDataTaskCompletedListener iMobileDataTaskCompletedListener;
    private ICallBackEvent mCallBackEvent;

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
            responseData = makeServiceCall(url);
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

    public String makeServiceCall(String reqUrl) throws IOException {
        String response = null;

        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        // read the response
        InputStream in = new BufferedInputStream(conn.getInputStream());
        response = convertStreamToString(in);

        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    @Override
    protected void onPostExecute(ArrayList<MobileEngineer> aList) {
        super.onPostExecute(aList);
        iMobileDataTaskCompletedListener.onMobileDataTaskComplete(aList);
        mCallBackEvent.onComplete(aList);
    }


}
