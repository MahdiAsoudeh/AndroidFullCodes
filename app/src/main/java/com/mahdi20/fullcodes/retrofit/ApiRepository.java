package com.mahdi20.fullcodes.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRepository {

    @GET("read")
    Call<List<Person>> getAll();

    @POST("insert")
    Call<Void> insert(@Body Person person);

}