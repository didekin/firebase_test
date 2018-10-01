package com.didekin.open.message;

import com.didekin.open.message.broadcast.GcmBroadCastNotificationActivityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * User: pedro@didekin
 * Date: 26/01/17
 * Time: 16:43
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FireBaseIdTest.class,
        GcmBroadCastNotificationActivityTest.class,
        GcmRequestTest.class,
})
public class FullTestSuite {
}
