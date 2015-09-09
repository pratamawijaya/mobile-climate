package com.pratamawijaya.mobileclimate.utils;

import android.content.Context;
import android.content.SharedPreferences;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class PreferenceUtils {

  private static SharedPreferences sp;
  public static final String PREF_NAME = "climate";

  public static final String SPINNER_POS = "user_session";

  /**
   * clear all sp
   */
  public static void clearSP(Context context) {
    Timber.d("clear sp");
    context.getSharedPreferences(PREF_NAME, 0).edit().clear().commit();
  }

  public static void setDataIntTOSP(Context context, String to, int data) {
    Timber.d("set data int to SP " + to + " data :" + data);
    sp = context.getSharedPreferences(PREF_NAME, 0);
    SharedPreferences.Editor editor = sp.edit();
    editor.putInt(to, data);
    //editor.commit();
    editor.apply();
  }

  public static int getDataIntFromSP(Context context, String from, int defaultValue) {
    sp = context.getSharedPreferences(PREF_NAME, 0);
    Timber.d("result : " + sp.getInt(from, defaultValue));
    return sp.getInt(from, defaultValue);
  }

  public static void setDataBooleanToSP(Context context, String to, boolean data) {
    Timber.d("setDataBooleanToSP " + data + " to :" + to);
    sp = context.getSharedPreferences(PREF_NAME, 0);
    SharedPreferences.Editor editor = sp.edit();
    editor.putBoolean(to, data);
    //editor.commit();
    editor.apply();
  }

  public static boolean getDataBooleanFromSP(Context context, String from, boolean defaultValue) {
    sp = context.getSharedPreferences(PREF_NAME, 0);
    Timber.d("result " + from + ": " + sp.getBoolean(from, defaultValue));
    return sp.getBoolean(from, defaultValue);
  }

  public static void setDataDoubleToSP(Context context, String to, long data) {
    Timber.d("setDataDoubleToSp " + data);
    sp = context.getSharedPreferences(PREF_NAME, 0);
    SharedPreferences.Editor editor = sp.edit();
    editor.putLong(to, data);
    //editor.commit();
    editor.apply();
  }

  public static double getDataDoubleFromSP(Context context, String from, long defaultVal) {
    sp = context.getSharedPreferences(PREF_NAME, 0);
    Timber.d("data ->" + sp.getLong(from, defaultVal));
    return sp.getLong(from, defaultVal);
  }

  public static void setDataStringToSP(Context context, String to, String data) {
    Timber.d("setDataStringToSP " + to + " data :" + data);
    sp = context.getSharedPreferences(PREF_NAME, 0);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString(to, data);
    //editor.commit();
    editor.apply();
  }

  public static String getDataStringFromSP(Context context, String from, String defaultValue) {
    sp = context.getSharedPreferences(PREF_NAME, 0);
    Timber.d("data ->" + sp.getString(from, defaultValue));
    return sp.getString(from, defaultValue);
  }
}
