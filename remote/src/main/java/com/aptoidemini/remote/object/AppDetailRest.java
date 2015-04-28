package com.aptoidemini.remote.object;

import com.aptoidemini.domain.AppDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppDetailRest {

  @SerializedName("permissions")
  public List<String> permissions;

  public AppDetailRest(final List<String> permissions) {
    this.permissions = permissions;
  }

  public List<String> getPermissions() {
    return permissions;
  }

  public AppDetail toDomain() {
    return new AppDetail(getPermissions());
  }
}

