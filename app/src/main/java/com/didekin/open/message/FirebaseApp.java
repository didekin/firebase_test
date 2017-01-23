package com.didekin.open.message;

import android.app.Application;

import timber.log.Timber;

/**
 * User: pedro@didekin
 * Date: 11/01/17
 * Time: 11:55
 */

public class FirebaseApp extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        Timber.d("BUILD_TYPE: %s", BuildConfig.BUILD_TYPE);
    }
}
