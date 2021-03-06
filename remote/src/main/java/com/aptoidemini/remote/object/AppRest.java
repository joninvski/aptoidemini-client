package com.aptoidemini.remote.object;

import com.aptoidemini.domain.App;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AppRest {

  @SerializedName("id")
  public int id;

  @SerializedName("name")
  public String name;

  @SerializedName("downloads")
  public int downloads;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDownloads() {
    return downloads;
  }

  public void setDownloads(int downloads) {
    this.downloads = downloads;
  }

  public App toDomain() {
    return new App(getId(), getName(), getDownloads());
  }

  public static List<App> toDomain(List<AppRest> appRestList) {
    final List<App> appList = new ArrayList<App>();

    if (appRestList == null) {
      return appList;
    }

    for (final AppRest appRest : appRestList) {
      final App app = appRest.toDomain();
      appList.add(app);
    }
    return appList;
  }
}
