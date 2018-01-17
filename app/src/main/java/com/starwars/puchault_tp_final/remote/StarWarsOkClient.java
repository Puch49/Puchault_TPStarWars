package com.starwars.puchault_tp_final.remote;

import android.os.Build;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit.client.OkClient;
import retrofit.client.Request;

/**
 * Created by puch on 17/01/2018.
 */

public class StarWarsOkClient extends OkClient {

    public StarWarsOkClient() {
        super();
    }

    @Override
    protected HttpURLConnection openConnection(Request request) throws IOException {
        HttpURLConnection connection = super.openConnection(request);
        connection.setRequestProperty("User-Agent", "swapi-android-" + Build.VERSION.RELEASE);
        return connection;
    }
}

