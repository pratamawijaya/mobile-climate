package com.pratamawijaya.mobileclimate.utils;

import android.text.TextUtils;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class DateUtils {

  /**
   * convert timestamp to dateFormat
   *
   * @param format example : EEEE, d MMM yyyy
   */
  public static String convertTimestampToDate(long timeStamp, String format) {
    Timestamp stamp = new Timestamp(timeStamp * 1000);
    SimpleDateFormat sf =
        new SimpleDateFormat(TextUtils.isEmpty(format) ? "EEEE, d MMM yyyy" : format);
    return sf.format(stamp);
  }

  /**
   * formatting Currency idr
   */
  public static String DecimalFormatter(float data, String format) {
    DecimalFormat formattter = new DecimalFormat(TextUtils.isEmpty(format) ? "#.##" : format);
    return formattter.format(data);
  }
}
