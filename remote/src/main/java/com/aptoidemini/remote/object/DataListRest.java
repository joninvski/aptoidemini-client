package com.aptoidemini.remote.object;

import com.aptoidemini.domain.DataList;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataListRest {

  @SerializedName("list")
  public List<AppRest> appRestList;

  public List<AppRest> getAppList() {
    return appRestList;
  }

  public void setApp(List<AppRest> appList) {
    this.appRestList = appRestList;
  }

  public DataList toDomain() {
    return new DataList(AppRest.toDomain(getAppList()));
  }
}

