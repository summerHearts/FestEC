package com.example.kenvin.festec;

import android.app.Application;

import com.example.latte.app.Latte;

/**
 * Created by Kenvin on 2017/9/27.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this).withApiHost("http:127.0.0.1/").configure();
    }


}
