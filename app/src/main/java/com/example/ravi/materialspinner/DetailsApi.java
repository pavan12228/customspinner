package com.example.ravi.materialspinner;

import com.google.gson.JsonArray;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ravi on 24-01-2017.
 */

public interface DetailsApi
{

@GET("/movies.json")
     void Mymeth(Callback<JsonArray> callback);
}
