package com.pratamawijaya.mobileclimate.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class RetrofitAPI {
  private static final String API = "http://api.openweathermap.org/data/2.5/forecast/";

  public OpenWeatherService getOpenWeatherAPI() {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient httpClient =
        new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(API)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    return retrofit.create(OpenWeatherService.class);
  }
}
