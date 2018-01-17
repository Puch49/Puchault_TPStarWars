package com.starwars.puchault_tp_final.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.starwars.puchault_tp_final.APIConstants;
import com.starwars.puchault_tp_final.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.RestAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import okhttp3.OkHttpClient;


/**
 * Created by puch on 17/01/2018.
 */

public class StarWarsApiService {


    private StarWarsInterface mSwApi;
    private static StarWarsApiService sInstance;

    private StarWarsApiService() {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setClient(new StarWarsOkClient())
                .setEndpoint(APIConstants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        mSwApi = restAdapter.create(StarWarsInterface.class);
    }

    public static void init() {
        sInstance = new StarWarsApiService();
    }

    public static StarWarsInterface getApi() {
        return sInstance.mSwApi;
    }

    public void setApi(StarWarsInterface starWarsApi) {
        sInstance.mSwApi = starWarsApi;
    }

/*
    private static final StarWarsInterface instance = build();

    public static StarWarsInterface getInstance() {
        return instance;
    }



    private static StarWarsInterface build() {
        final Gson gson = new GsonBuilder().create(); // JSON deserializer/serializer

        // Create the OkHttp Instance
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(final Chain chain) throws IOException {
                        final Request request = chain.request().newBuilder().addHeader("Accept", "application/json").build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl(StarWarsInterface.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(StarWarsInterface.class);
    }*/


}
