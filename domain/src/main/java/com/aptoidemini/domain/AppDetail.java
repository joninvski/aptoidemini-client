package com.aptoidemini.domain;

import java.util.List;


public class AppDetail {

  final public List<String> permissions;

  public AppDetail(final List<String> permissions) {
    this.permissions = permissions;
  }

  public List<String> getPermissions() {
    return permissions;
  }
}
