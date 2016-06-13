package com.crrain.testcia;

import android.app.Application;

import cn.ciaapp.sdk.CIAService;

/**
 * Created by Administrator on 2016/6/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CIAService.init(getApplicationContext(), "036afd13749a43459d49a6a1a97cff7c", "f63497c471cc4c00b970de447d8df583");
    }
}
