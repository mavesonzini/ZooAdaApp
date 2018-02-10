package com.example.mavesonzini.zooadaapp;

import android.app.Application;

import java.io.Serializable;

/**
 * Created by mavesonzini on 2/6/18.
 */

public class ZooMain extends Application implements Serializable {

  private final FileManager fileManager = new FileManager(this);

  @Override
  public void onCreate() {
    super.onCreate();
    fileManager.writeZooToFile();
    fileManager.getZooFromFile();
  }

  public static Zoo getZoo() {
    return Zoo.getInstance();
  }
}
