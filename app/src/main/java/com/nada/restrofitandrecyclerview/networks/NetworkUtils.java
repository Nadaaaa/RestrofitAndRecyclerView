package com.nada.restrofitandrecyclerview.networks;

import com.nada.restrofitandrecyclerview.models.ResponseOfAds;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkUtils {

    @GET("index.php/api/getads")
    Call<ResponseOfAds> getAds();
}