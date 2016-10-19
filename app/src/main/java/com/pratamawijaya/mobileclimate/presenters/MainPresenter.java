package com.pratamawijaya.mobileclimate.presenters;

import com.pratamawijaya.mobileclimate.BuildConfig;
import com.pratamawijaya.mobileclimate.data.network.RetrofitAPI;
import com.pratamawijaya.mobileclimate.models.City;
import com.pratamawijaya.mobileclimate.models.WeatherList;
import com.pratamawijaya.mobileclimate.models.response.ResponseWeather;
import com.pratamawijaya.mobileclimate.models.response.ResultWeather;
import com.pratamawijaya.mobileclimate.utils.DateUtils;
import com.pratamawijaya.mobileclimate.views.MainInterfaces;
import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class MainPresenter {
  private static final String TYPE_REQUEST = "json";
  private static final String UNITS = "metric";
  private static final int COUNT_DAY = 7;
  private MainInterfaces view;
  private RetrofitAPI service;
  private List<ResultWeather> resultWeather;
  private float sumTempDay = 0;
  private float sumVariance = 0;

  private List<City> listCity;

  public MainPresenter(MainInterfaces view) {
    this.view = view;
    service = new RetrofitAPI();
    listCity = new ArrayList<>();
  }

  /**
   * load data city
   */
  public void loadDataSpinner() {
    listCity.add(new City(1, "Jakarta"));
    listCity.add(new City(2, "Tokyo"));
    listCity.add(new City(3, "London"));

    view.setDataSpinner(listCity);
  }

  /**
   * load weather data from sources
   *
   * @param city City
   */
  public void loadWeather(String city) {
    sumVariance = 0;
    sumTempDay = 0;
    resultWeather = new ArrayList<>();
    Timber.i("load weather for " + city);
    view.showLoading();
    service.getOpenWeatherAPI()
        .getWeatherByCity(city, TYPE_REQUEST, UNITS, COUNT_DAY, BuildConfig.APIKEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ResponseWeather>() {
          @Override public void onCompleted() {
            view.hideLoading();
          }

          @Override public void onError(Throwable e) {
            view.hideLoading();
            Timber.e("error : " + e.getMessage());
          }

          @Override public void onNext(ResponseWeather responseWeather) {
            Timber.i("response : " + responseWeather.toString());

            for (WeatherList weather : responseWeather.getWeatherLists()) {
              float day = weather.getTemp().getDay();
              Timber.d("temp : " + day);
              sumTempDay += day;
              float variance = weather.getTemp().getMax() - weather.getTemp().getMin();
              sumVariance += variance;
              // convert timestamp
              String timestamp =
                  DateUtils.convertTimestampToDate(Long.parseLong(weather.getTimestamp()), "");

              resultWeather.add(new ResultWeather(timestamp, day, variance));
            }

            view.showData(resultWeather);
            view.showAverageDay(sumTempDay / COUNT_DAY);
            view.showAverageVariance(sumVariance / COUNT_DAY);
          }
        });
  }
}
