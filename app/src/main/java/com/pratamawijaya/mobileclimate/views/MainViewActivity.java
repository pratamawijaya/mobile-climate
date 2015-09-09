package com.pratamawijaya.mobileclimate.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.mobileclimate.R;
import com.pratamawijaya.mobileclimate.models.City;
import com.pratamawijaya.mobileclimate.models.response.ResultWeather;
import com.pratamawijaya.mobileclimate.presenters.MainPresenter;
import com.pratamawijaya.mobileclimate.utils.DateUtils;
import com.pratamawijaya.mobileclimate.utils.PreferenceUtils;
import java.util.List;

public class MainViewActivity extends AppCompatActivity
    implements MainInterfaces, AdapterView.OnItemSelectedListener {

  @Bind(R.id.spCity) Spinner spCity;
  @Bind(R.id.recyclerView) RecyclerView recyclerView;
  @Bind(R.id.loader) ProgressBar loader;
  @Bind(R.id.dayAverage) TextView dayAverage;
  @Bind(R.id.varianceAverage) TextView varianceAverage;

  private ArrayAdapter<City> spinnerAdapter;
  private MainAdapter adapter;
  private MainPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setupRecyclerView();

    presenter = new MainPresenter(this);

    presenter.loadDataSpinner();

    spCity.setOnItemSelectedListener(this);

    if (PreferenceUtils.getDataIntFromSP(this, PreferenceUtils.SPINNER_POS, 0) != 0) {
      spCity.setSelection(PreferenceUtils.getDataIntFromSP(this, PreferenceUtils.SPINNER_POS, 0));
    }
  }

  /**
   * setup recyclerview
   */
  private void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new MainAdapter(this);
    recyclerView.setAdapter(adapter);
  }

  @Override public void showLoading() {
    loader.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    loader.setVisibility(View.GONE);
  }

  @Override public void showData(List<ResultWeather> weather) {
    adapter.setWeatherLists(weather);
    adapter.notifyDataSetChanged();
  }

  @Override public void showAverageDay(float data) {
    dayAverage.setText("7-day average: " + DateUtils.DecimalFormatter(data, "#") + " C");
  }

  @Override public void showAverageVariance(float data) {
    varianceAverage.setText(
        "7-day average variance: " + DateUtils.DecimalFormatter(data, "#.##") + " C");
  }

  @Override public void setDataSpinner(List<City> listCity) {
    spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCity);
    spCity.setAdapter(spinnerAdapter);
  }

  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
    PreferenceUtils.setDataIntTOSP(this, PreferenceUtils.SPINNER_POS, position);
    City city = (City) spCity.getSelectedItem();
    presenter.loadWeather(city.getName());
  }

  @Override public void onNothingSelected(AdapterView<?> adapterView) {

  }
}
