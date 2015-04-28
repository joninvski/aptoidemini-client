package com.aptoidemini.domain;

import java.util.List;


public class Apk {

  final public List<String> permissions;

  public Apk (final List<String> permissions) {
    this.permissions = permissions;
  }

  public List<String> getPermissions() {
    return permissions;
  }
}
