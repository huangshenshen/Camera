package com.cninter.camera;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.SystemClock;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public  void TestSDImag(){
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(),R.mipmap.ic_launcher);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        System.out.print("path"+path);
        MainActivity.SaveImagSD(bitmap,path,"myphome.png");
    }



}