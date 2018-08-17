package com.didekin.open.message;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import timber.log.Timber;

import static com.didekin.open.message.GcmServConstant.SCOPE_TOKEN;
import static com.didekin.open.message.GcmServConstant.SENDER_ID;

/**
 * User: pedro@didekin
 * Date: 10/01/17
 * Time: 17:37
 */
public class MiFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = null;
        try {
            refreshedToken = FirebaseInstanceId.getInstance().getToken(SENDER_ID, SCOPE_TOKEN);
            Timber.d("Refreshed token: %s", refreshedToken);
        } catch (IOException e) {
            Timber.e(e);
        }

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken)
    {
        Timber.d("In sendRegistrationToServer, token = %s", refreshedToken);
    }
}
