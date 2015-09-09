package com.pratamawijaya.mobileclimate.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class Weather implements Parcelable {
  private int id;
  private String main;
  private String description;
  private String icon;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.main);
    dest.writeString(this.description);
    dest.writeString(this.icon);
  }

  public Weather() {
  }

  protected Weather(Parcel in) {
    this.id = in.readInt();
    this.main = in.readString();
    this.description = in.readString();
    this.icon = in.readString();
  }

  public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
    public Weather createFromParcel(Parcel source) {
      return new Weather(source);
    }

    public Weather[] newArray(int size) {
      return new Weather[size];
    }
  };
}
