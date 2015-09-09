package com.pratamawijaya.mobileclimate.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class Temp implements Parcelable {
  private float day;
  private float min;
  private float max;
  private float night;
  private float eve;
  private float morn;
  private float variance;

  public float getVariance() {
    return variance;
  }

  public void setVariance(float variance) {
    this.variance = variance;
  }

  public float getDay() {
    return day;
  }

  public void setDay(float day) {
    this.day = day;
  }

  public float getMin() {
    return min;
  }

  public void setMin(float min) {
    this.min = min;
  }

  public float getMax() {
    return max;
  }

  public void setMax(float max) {
    this.max = max;
  }

  public float getNight() {
    return night;
  }

  public void setNight(float night) {
    this.night = night;
  }

  public float getEve() {
    return eve;
  }

  public void setEve(float eve) {
    this.eve = eve;
  }

  public float getMorn() {
    return morn;
  }

  public void setMorn(float morn) {
    this.morn = morn;
  }

  public Temp() {
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeFloat(this.day);
    dest.writeFloat(this.min);
    dest.writeFloat(this.max);
    dest.writeFloat(this.night);
    dest.writeFloat(this.eve);
    dest.writeFloat(this.morn);
    dest.writeFloat(this.variance);
  }

  protected Temp(Parcel in) {
    this.day = in.readFloat();
    this.min = in.readFloat();
    this.max = in.readFloat();
    this.night = in.readFloat();
    this.eve = in.readFloat();
    this.morn = in.readFloat();
    this.variance = in.readFloat();
  }

  public static final Creator<Temp> CREATOR = new Creator<Temp>() {
    public Temp createFromParcel(Parcel source) {
      return new Temp(source);
    }

    public Temp[] newArray(int size) {
      return new Temp[size];
    }
  };
}
