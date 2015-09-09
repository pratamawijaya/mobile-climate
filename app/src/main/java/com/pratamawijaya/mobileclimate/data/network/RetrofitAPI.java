package com.pratamawijaya.mobileclimate.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pratamawijaya.mobileclimate.BuildConfig;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class RetrofitAPI {
  private static final String API = "http://api.openweathermap.org/data/2.5/forecast/";

  public OpenWeatherService getOpenWeatherAPI() {
    OkHttpClient httpClient = new OkHttpClient();
    Gson gson = new GsonBuilder().create();

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API)
        .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
        .setClient(new OkClient(httpClient))
        .setConverter(new GsonConverter(gson))
        .build();
    return restAdapter.create(OpenWeatherService.class);
  }
}
