package com.pratamawijaya.mobileclimate.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class WeatherList {
  @SerializedName("dt") private String timestamp;

  @SerializedName("temp") private Temp temp;

  private String pressure;

  private String humidity;

  @SerializedName("weather") private List<Weather> weatherList;

  private float speed;

  private float deg;

  private float clouds;

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Temp getTemp() {
    return temp;
  }

  public void setTemp(Temp temp) {
    this.temp = temp;
  }

  public String getPressure() {
    return pressure;
  }

  public void setPressure(String pressure) {
    this.pressure = pressure;
  }

  public String getHumidity() {
    return humidity;
  }

  public void setHumidity(String humidity) {
    this.humidity = humidity;
  }

  public List<Weather> getWeatherList() {
    return weatherList;
  }

  public void setWeatherList(List<Weather> weatherList) {
    this.weatherList = weatherList;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public float getDeg() {
    return deg;
  }

  public void setDeg(float deg) {
    this.deg = deg;
  }

  public float getClouds() {
    return clouds;
  }

  public void setClouds(float clouds) {
    this.clouds = clouds;
  }
}
