package com.pratamawijaya.mobileclimate.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.mobileclimate.R;
import com.pratamawijaya.mobileclimate.models.response.ResultWeather;
import com.pratamawijaya.mobileclimate.utils.DateUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/9/15
 * Project : MobileClimate
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
  private Context context;
  private List<ResultWeather> weatherLists;

  public MainAdapter(Context context) {
    this.context = context;
    weatherLists = new ArrayList<>();
  }

  public List<ResultWeather> getWeatherLists() {
    return weatherLists;
  }

  public void setWeatherLists(List<ResultWeather> weatherLists) {
    this.weatherLists = weatherLists;
  }

  @Override public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MainHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false));
  }

  @Override public void onBindViewHolder(MainHolder holder, int position) {
    holder.date.setText("" + weatherLists.get(position).getDate());

    holder.temp.setText("Temp Day : " +
        DateUtils.DecimalFormatter(weatherLists.get(position).getDay(), "#") + " C");

    holder.variance.setText("Temp Variance :" +
        DateUtils.DecimalFormatter(weatherLists.get(position).getVariance(), "#.##") + " C");
  }

  @Override public int getItemCount() {
    return weatherLists.size();
  }

  public class MainHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.date) TextView date;
    @Bind(R.id.dailyTemp) TextView temp;
    @Bind(R.id.dailyVariance) TextView variance;

    public MainHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
