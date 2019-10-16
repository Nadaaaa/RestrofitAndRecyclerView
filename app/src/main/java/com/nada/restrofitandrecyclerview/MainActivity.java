package com.nada.restrofitandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nada.restrofitandrecyclerview.models.Ad;
import com.nada.restrofitandrecyclerview.models.ResponseOfAds;
import com.nada.restrofitandrecyclerview.networks.Retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdsAdapter.ListItemClickListener {

    /*
     * Okay Now i will explain how to use the data you get from Retrofit and add it into a recyclerView as Steps
     *
     * The First Step is Create Models:
     *
     * to know What's your API Consist of and i mean by that i clicked on the link you send me and found some JSON Code
     *
     * i found array of data and 2 Strings a code and a message, this is the "response" of the retrofit, so i create a response class Which called here "ResponseOfAds"
     *
     * to deal which the array of Retrofit you create a list of objects, the object here is "Ad" which consist of many Strings and variables so i created a class for that too, it called "Ad"
     *
     * Check Them
     * */

    private static final String BaseUrl = "http://proximityservice.tsi.ph/";

    List<Ad> adList;
    AdsAdapter adsAdapter;
    RecyclerView rv_ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * TODO: Step 7
         * declare a list of Ads and the adapter you created, also call (find view by id) to the recycler View
         * set the layout manager and here you can customize it horizontal, vertical or grid.
         * and assign the adapter to the recycler view
         * */

        rv_ads = findViewById(R.id.rv_ads);
        adList = new ArrayList<>();
        adsAdapter = new AdsAdapter(getApplicationContext(), adList, this);
        rv_ads.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_ads.setAdapter(adsAdapter);

        getAds();
    }


    /*
    * TODO: Step 8
    * After Calling the Retrofit you will get your List of Data From the Response Variable just AddALL to your Current List and update the adapter. and That's All
    * */
    void getAds() {
        Retrofit.getService(BaseUrl).getAds().enqueue(new Callback<ResponseOfAds>() {
            @Override
            public void onResponse(Call<ResponseOfAds> call, Response<ResponseOfAds> response) {
                if (response.body().getCode().equals("OK")) {
                    adList.addAll(response.body().getData());
                    adsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseOfAds> call, Throwable t) {

            }
        });
    }

    @Override
    public void onListItemClicked(int clickedItemIndex) {

    }
}
