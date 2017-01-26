package com.didekin.open.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public class MockActivity extends AppCompatActivity {

    @SuppressWarnings("unused")
    volatile short counter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Timber.d("onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume()
    {
        Timber.d("onResume()");
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        Timber.d("onPause()");
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        Timber.d("onDestroy()");
        super.onDestroy();
    }
}
