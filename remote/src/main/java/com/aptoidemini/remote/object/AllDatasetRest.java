package com.aptoidemini.remote.object;

import com.aptoidemini.domain.AllDataset;
import com.google.gson.annotations.SerializedName;

public class AllDatasetRest {

  @SerializedName("all")
  private DataRest dataRest;

  public DataRest getData() {
    return dataRest;
  }

  public void setData(final DataRest dataRest) {
    this.dataRest = dataRest;
  }

  public AllDataset toDomain() {
    return new AllDataset(getData().toDomain());
  }
}

