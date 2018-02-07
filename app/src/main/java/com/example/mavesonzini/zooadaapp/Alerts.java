package com.example.mavesonzini.zooadaapp;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by mavesonzini on 2/7/18.
 */

public final class Alerts extends Application{
  final Context context = this;

  public void showPenFullAlert() {
    AlertDialog alertDialog = new AlertDialog.Builder(context).create();
    alertDialog.setTitle("OVERCROWDING!");
    alertDialog.setMessage("This pen reached it's max capacity. Create a new one");
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        });
    alertDialog.show();
  }
}
