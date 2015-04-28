package com.aptoidemini.remote.object;

import com.aptoidemini.domain.Apk;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApkRest {

  @SerializedName("permissions")
  public List<String> permissions;

  public ApkRest (final List<String> permissions) {
    this.permissions = permissions;
  }

  public List<String> getPermissions() {
    return permissions;
  }

  public Apk toDomain() {
    return new Apk(permissions);
  }
}

