package com.aptoidemini.domain;

import java.util.List;

public class DataList {

  public List<App> appList;

  public DataList(List<App> appList) {
    this.appList = appList;
  }

  public List<App> getAppList() {
    return appList;
  }

  public void setAppList(List<App> appList) {
    this.appList = appList;
  }
}
