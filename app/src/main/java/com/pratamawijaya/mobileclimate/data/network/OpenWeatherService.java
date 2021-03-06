package com.pratamawijaya.mobileclimate.data.network;

import com.pratamawijaya.mobileclimate.models.response.ResponseWeather;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public interface OpenWeatherService {
  @GET("daily") Observable<ResponseWeather> getWeatherByCity(@Query("q") String city,
      @Query("mode") String mode, @Query("units") String units, @Query("cnt") int data,
      @Query("APPID") String apiKey);
}
