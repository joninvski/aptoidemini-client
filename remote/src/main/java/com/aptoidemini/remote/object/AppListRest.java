package com.aptoidemini.remote.object;

import com.aptoidemini.domain.AppList;
import com.google.gson.annotations.SerializedName;

public class AppListRest {

  @SerializedName("datasets")
  private DatasetsRest datasetsRest;

  public AppListRest(DatasetsRest datasets) {
    this.datasetsRest = datasets;
  }

  public DatasetsRest getDataset() {
    return datasetsRest;
  }

  public AppList toDomain() {
    return new AppList(getDataset().toDomain());
  }
}
