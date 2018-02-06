package com.example.mavesonzini.zooadaapp;

import android.app.Application;

/**
 * Created by mavesonzini on 2/6/18.
 */

public class ZooMain extends Application {

  private final FileManager fileManager = new FileManager(this);

  @Override
  public void onCreate() {
    super.onCreate();
    fileManager.getZooFromFile();
  }
}
