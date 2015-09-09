package com.pratamawijaya.mobileclimate.models.response;

import com.google.gson.annotations.SerializedName;
import com.pratamawijaya.mobileclimate.models.City;
import com.pratamawijaya.mobileclimate.models.WeatherList;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class ResponseWeather {
  private City city;
  private String cod;
  private String message;
  private int cnt;

  @SerializedName("list") private List<WeatherList> weatherLists;

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public List<WeatherList> getWeatherLists() {
    return weatherLists;
  }

  public void setWeatherLists(List<WeatherList> weatherLists) {
    this.weatherLists = weatherLists;
  }
}
