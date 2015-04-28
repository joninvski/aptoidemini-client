package com.aptoidemini.remote.object;

import com.google.gson.annotations.SerializedName;
import com.aptoidemini.domain.AppList;
import com.aptoidemini.domain.Datasets;

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
