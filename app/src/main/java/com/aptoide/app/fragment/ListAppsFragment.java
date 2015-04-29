package com.aptoide.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aptoide.app.R;

import hugo.weaving.DebugLog;

public class ListAppsFragment extends BaseFragment {

  @Override
  public View onCreateView(final LayoutInflater inflater,
                           final ViewGroup container,
                           final Bundle savedInstanceState) {
    final ViewGroup view = (ViewGroup) inflater.inflate(
                             R.layout.frag_list_apps_layout, container, false);

    return view;
  }

  @DebugLog
  @Override
  public void onResume() {
    super.onResume();
    getBus().register(this);
  }

  @Override
  public void onPause() {
    getBus().unregister(this);
    super.onPause();
  }
}
