package com.pratamawijaya.mobileclimate.base;

import android.app.Application;
import com.pratamawijaya.mobileclimate.BuildConfig;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class BaseAppication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
  }
}
