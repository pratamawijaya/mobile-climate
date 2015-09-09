package com.pratamawijaya.mobileclimate.views;

import com.pratamawijaya.mobileclimate.models.City;
import com.pratamawijaya.mobileclimate.models.response.ResultWeather;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public interface MainInterfaces {
  void showLoading();

  void hideLoading();

  void showData(List<ResultWeather> weather);

  void showAverageDay(float data);

  void showAverageVariance(float data);

  void setDataSpinner(List<City> listCity);
}
