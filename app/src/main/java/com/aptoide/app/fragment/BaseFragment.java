package com.aptoide.app.fragment;

import android.support.v4.app.Fragment;

import com.aptoidemini.domain.EventBus;
import com.aptoidemini.remote.AptoideRestClient;
import com.aptoide.app.activity.BaseActivity;
import com.aptoide.app.AptoideApp;

import hugo.weaving.DebugLog;

public abstract class BaseFragment extends Fragment {

  @DebugLog
  @Override
  public void onResume() {
    super.onResume();
  }

  @DebugLog
  @Override
  public void onPause() {
    super.onPause();
  }

  public AptoideApp getApp() {
    return (AptoideApp) (getActivity().getApplication());
  }

  public BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }

  public EventBus getBus() {
    return getApp().getBus();
  }

  public AptoideRestClient getRestClient() {
    return getApp().getRestClient();
  }
}
