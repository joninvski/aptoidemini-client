package com.aptoidemini.remote.object;

import com.aptoidemini.domain.Datasets;
import com.google.gson.annotations.SerializedName;

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
