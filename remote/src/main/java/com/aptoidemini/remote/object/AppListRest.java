package com.aptoidemini.remote.object;

import com.google.gson.annotations.SerializedName;
import com.aptoidemini.domain.AppList;

public class AppListRest {

  @SerializedName("apk")
  private ApkRest apkRest;

  public AppListRest(ApkRest apkRest) {
    this.apkRest = apkRest;
  }

  public ApkRest getApkRest() {
    return apkRest;
  }

  public AppList toDomain() {
    return new AppList(getApkRest().toDomain());
  }
}
