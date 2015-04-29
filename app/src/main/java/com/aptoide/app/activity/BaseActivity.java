package com.aptoide.app.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.AptoideRestClient;
import com.aptoide.app.AptoideApp;

import hugo.weaving.DebugLog;

public abstract class BaseActivity extends FragmentActivity {

  @DebugLog
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public AptoideApp getApp() {
    return (AptoideApp) getApplication();
  }

  public EventBus getBus() {
    return AptoideApp.getBus();
  }

  public AptoideRestClient getRestClient() {
    return getApp().getRestClient();
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
  }
}
