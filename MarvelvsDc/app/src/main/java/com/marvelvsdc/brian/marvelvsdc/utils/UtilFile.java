package com.marvelvsdc.brian.marvelvsdc.utils;

import android.app.Activity;
import android.content.Context;

import java.io.FileOutputStream;

public class UtilFile {

    public static void openFile(Activity activity){
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;
        try {
            outputStream = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
