package com.aptoidemini.remote.object;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.aptoidemini.domain.DataList;

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

