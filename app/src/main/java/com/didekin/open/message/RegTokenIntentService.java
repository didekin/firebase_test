package com.didekin.open.message;

import android.app.IntentService;
import android.content.Intent;

import com.google.firebase.iid.FirebaseInstanceId;

import timber.log.Timber;

/**
 * User: pedro@didekin
 * Date: 10/01/17
 * Time: 18:56
 * This is only to put a service to get and register a token pro-actively.
 */
public class RegTokenIntentService extends IntentService {

    public RegTokenIntentService()
    {
        super(RegTokenIntentService.class.getCanonicalName());
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Timber.d("onHandleIntent()");
        // Check Google Play services avilability.
        String token = FirebaseInstanceId.getInstance().getToken();
        // Register call should be here.
        Timber.d("Token to be registered = %s", token);
    }
}
