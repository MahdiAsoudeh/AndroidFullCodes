package com.mahdi20.fullcodes.retrofitExample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mahdi20.codes.App;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public final static String BASE_URL = "http://176.9.180.142:8080/";
    private static Retrofit retrofit = null;

    public static ApiRepository getApiService() {

        long cacheSize = (5 * 1024 * 1024);
        Cache myCache = new Cache(App.context.getCacheDir(), cacheSize);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(myCache)
                .addInterceptor(chain -> {
                    Request request = chain.request();

                    if (hasNetwork(App.context)) {
                        request = request.newBuilder().addHeader("Cache-Control", "public, max-age=" + 5).build();
                    } else {
                        request = request.newBuilder().addHeader(
                                "Cache-Control",
                                "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                        ).build();
                    }
                    return chain.proceed(request);
                }).build();


        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit.create(ApiRepository.class);
    }


    public static boolean hasNetwork(Context context) {

        boolean isConnected = false;
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        assert connectivityManager != null;
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null &&
                activeNetwork.isConnected())
            isConnected = true;
        return isConnected;

    }
}