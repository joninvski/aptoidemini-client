package com.aptoidemini.remote.object;

import com.google.gson.annotations.SerializedName;
import com.aptoidemini.domain.Apk;

import java.util.List;
import com.aptoidemini.domain.Datasets;

public class DatasetsRest {

  @SerializedName("all")
  public AllDatasetRest allDataset;

  public DatasetsRest(final AllDatasetRest allDataset) {
    this.allDataset = allDataset;
  }

  public AllDatasetRest getAllDataset() {
    return allDataset;
  }

  public void setAllDataset(AllDatasetRest allDataset) {
    this.allDataset = allDataset;
  }

  public Datasets toDomain() {
    return new Datasets(getAllDataset().toDomain());
  }
}
