package com.didekin.open.message.broadcast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.NotificationCompat.Builder;

import com.didekin.open.message.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static android.graphics.BitmapFactory.decodeResource;
import static com.didekin.open.message.broadcast.GcmNotificationListenerServ.GCM_NOTIFICATION_action;
import static com.didekin.open.message.broadcast.GcmNotificationListenerServ.notification_extra;
import static com.didekin.open.message.broadcast.GcmNotificationListenerServ.notification_id_extra;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: pedro@didekin
 * Date: 01/12/15
 * Time: 13:50
 */
@RunWith(AndroidJUnit4.class)
public class GcmBroadCastNotificationActivityTest {

    private static final String MY_MESSAGE_TITLE = "My message title";
    private static final String MY_NEW_INCIDENCIA_BODY = "My new incidencia body";
    private static final String MY_GENERIC_SUBTEXT = "My generic subtext";

    private Context context = InstrumentationRegistry.getTargetContext();

    @Rule
    public ActivityTestRule<GcmBroadCastNotificationActivity> mActivityRule = new ActivityTestRule<>(GcmBroadCastNotificationActivity.class, true, false);

    @Test
    public void testNotification_1() throws TimeoutException, InterruptedException
    {
        GcmBroadCastNotificationActivity mActivity = mActivityRule.launchActivity(new Intent());
        sendNotification();
        Thread.sleep(3000);
        assertThat(mActivity.notificationId, is(1));
        assertThat(mActivity.title, is(MY_MESSAGE_TITLE));
        assertThat(mActivity.text, is(MY_NEW_INCIDENCIA_BODY));
        assertThat(mActivity.subText, is(MY_GENERIC_SUBTEXT));
    }


    //    ======================== HELPER METHODS ==========================

    /**
     * This method merges the sending of a notification by the NotificationManager,
     * its reception by the NotificationListener and the final broadcast by it to the corresponding
     * activity.
     * It should not be necessary once the new methods of NotificationManager in API 23 can be used.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void sendNotification()
    {
        Builder mBuilder = (Builder) new Builder(context)
                .setSmallIcon(R.drawable.ic_stat_ic_notification)
                .setLargeIcon(decodeResource(context.getResources(), R.drawable.ic_launcher))
                .setCategory(Notification.CATEGORY_SOCIAL)
                .setAutoCancel(true)
                .setContentTitle(MY_MESSAGE_TITLE)
                .setContentText(MY_NEW_INCIDENCIA_BODY)
                .setSubText(MY_GENERIC_SUBTEXT);

        Notification notification = mBuilder.build();

        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(/* notification ID*/1, notification);

        sendBroadcastMsg(notification, 1);
    }

    private void sendBroadcastMsg(Notification notification, int notificationId)
    {
        Intent intent = new Intent(GCM_NOTIFICATION_action);
        intent.putExtra(notification_id_extra, notificationId);
        intent.putExtra(notification_extra, notification);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
