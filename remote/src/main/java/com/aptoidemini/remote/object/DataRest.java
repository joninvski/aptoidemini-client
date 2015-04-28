package com.aptoidemini.remote.object;

import com.aptoidemini.domain.Data;
import com.google.gson.annotations.SerializedName;

public class DataRest {

  @SerializedName("list")
  public DataListRest dataList;

  public DataListRest getDataList() {
    return dataList;
  }

  public void setDataList(DataListRest dataList) {
    this.dataList = dataList;
  }

  public Data toDomain() {
    return new Data(getDataList().toDomain());
  }
}

