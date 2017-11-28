package com.example.tcox.recyclercreation.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tcox.recyclercreation.interfaces.IMobileDataTaskCompletedListener;
import com.example.tcox.recyclercreation.models.MobileEngineer;
import com.example.tcox.recyclercreation.parsers.MobileEngineerParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.net.URL;


import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by tcox on 11/28/17.
 */

public class GetMobileDataTask extends AsyncTask<Void, Void, ArrayList<MobileEngineer>> {

    private IMobileDataTaskCompletedListener iMobileDataTaskCompletedListener;

    private final String TAG = GetMobileDataTask.class.getSimpleName();

    public GetMobileDataTask(IMobileDataTaskCompletedListener mListener) {
        iMobileDataTaskCompletedListener = mListener;
    }

    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
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
    protected ArrayList<MobileEngineer> doInBackground(Void... params) {
        String url = "http://img.staging.medscape.com/pi/iphone/AndroidLearning.json";
        String responseData;
        responseData = null;
        try {
//            URL url = new URL("http://img.staging.medscape.com/pi/iphone/AndroidLearning.json");
          responseData = makeServiceCall(url);


        } catch (Exception e) {
            e.printStackTrace();
        }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        HttpRequestObject requestObject = new HttpRequestObject();
//        requestObject.setUrl(url);
//        requestObject.setRequestMethod("GET");
//        HttpResponseObject responseObject = HttpUtils.sendHttpRequest(requestObject);
//        String responseData = responseObject.getResponseData();
        MobileEngineerParser parser = new MobileEngineerParser();

        try {
            return parser.parse(responseData);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<MobileEngineer> aList) {
        super.onPostExecute(aList);
        iMobileDataTaskCompletedListener.onMobileDataTaskComplete(aList);
    }

}
