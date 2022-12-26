package com.example.teamsstats;

import android.os.AsyncTask;
import android.util.Log;

import com.example.teamsstats.interfaces.AsyncResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetData extends AsyncTask <URL, Void, String>{

    public GetData(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    private static final String TAG = "GetData";

    protected String getResponseFromHttpGetURL(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("X-Auth-Token", "ed3016c610724551a0baa9812c3b78cf");

        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            String result;
            if (hasInput) {
                result = scanner.next();
                return result;
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public AsyncResponse delegate;

    @Override
    protected void onPreExecute() {
        Log.d(TAG, "onPreExecute: called");
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(URL[] url) {
        Log.d(TAG, "doInBackground: called " + url[0].toString());
        String result = null;
        URL urlQuery = url[0];

        try {
            result = getResponseFromHttpGetURL(urlQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute: called");
        Log.d(TAG, "onPostExecute: " + result);
        if (result == null) {
            delegate.processFinish("noResult");
        } else {
            delegate.processFinish(result);
        }
    }
}
