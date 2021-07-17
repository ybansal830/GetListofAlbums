package com.myfirst.getlistofalbums;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("/albums")
    Call<ArrayList<ResponseAlbums>> getPosts();

}
