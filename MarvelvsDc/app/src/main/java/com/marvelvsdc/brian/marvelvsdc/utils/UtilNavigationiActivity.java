package com.marvelvsdc.brian.marvelvsdc.utils;

import android.app.Activity;
import android.content.Intent;

public class UtilNavigationiActivity {

    public static void goToActivity(Activity activity, Class classs){
        Intent intent = new Intent(activity, classs);
        activity.startActivity(intent);
    }

    public static void goToActivityFins(Activity activity, Class classGoto){
        Intent intent = new Intent(activity, classGoto);
        activity.startActivity(intent);
        activity.finish();
    }
}
