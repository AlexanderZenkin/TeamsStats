package com.example.teamsstats;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilder {

    private static final String TAG = "builderUrl";

    public URL builderUrlCLMatches(String dateFrom, String dateTo, String competitions) {

        String BASE_URL = "http://api.football-data.org/v4";
        Uri buildUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath("competitions")
                .appendPath(competitions)
                .appendPath("matches")
                .appendQueryParameter("dateFrom", dateFrom)
                .appendQueryParameter("dateTo", dateTo)
                .appendQueryParameter("status", "SCHEDULED")
                .build();

        URL url = null;
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "builderUrl: " + url);
        return url;
    }

    public URL builderUrlH2HMatches(String match) {

        String BASE_URL = "http://api.football-data.org/v4";
        Uri buildUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath("matches")
                .appendPath(match)
                .appendPath("head2head")
                .appendQueryParameter("limit", "6")
                .build();

        URL url = null;
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "builderUrl: " + url);
        return url;
    }
}
