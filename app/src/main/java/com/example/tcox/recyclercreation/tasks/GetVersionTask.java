package com.example.tcox.recyclercreation.tasks;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nbhatia on 1/30/18.
 */

public class GetVersionTask extends AsyncTask<Void, Integer, Integer> {

    private final String TAG = GetVersionTask.class.getSimpleName();


    @Override
    protected Integer doInBackground(Void... args) {

        String url = "https://alburt.us/sample_xml.xml";
        // Making a request to url and getting response
        String xmlStr = null;
        try {
            xmlStr = makeServiceCall(url);

        } catch (IOException e) {
            e.printStackTrace();
        }


        if (xmlStr != null)
        {

        }
        return -1;
    }

    @Override
    protected void onPostExecute(Integer i) {
        super.onPostExecute(i);
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
}