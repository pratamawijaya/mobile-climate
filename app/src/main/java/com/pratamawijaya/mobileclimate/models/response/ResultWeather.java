package com.pratamawijaya.mobileclimate.models.response;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class ResultWeather {
  private String date;
  private float day;
  private float variance;

  public ResultWeather(String date, float day, float variance) {
    this.day = day;
    this.date = date;
    this.variance = variance;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public float getDay() {
    return day;
  }

  public void setDay(float day) {
    this.day = day;
  }

  public float getVariance() {
    return variance;
  }

  public void setVariance(float variance) {
    this.variance = variance;
  }
}
