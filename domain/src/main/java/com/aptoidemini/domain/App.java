package com.aptoidemini.domain;

public class App {

  private final int id;
  private final String name;
  private final int downloads;

  public App(int id, String name, int downloads) {
    this.id = id;
    this.name = name;
    this.downloads = downloads;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getDownloads() {
    return downloads;
  }
}
