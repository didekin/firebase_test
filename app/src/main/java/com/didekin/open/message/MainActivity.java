package com.didekin.open.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart()
    {
        Timber.plant(new Timber.DebugTree());
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Timber.d("!!!!! Entro en onCreate !!!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
