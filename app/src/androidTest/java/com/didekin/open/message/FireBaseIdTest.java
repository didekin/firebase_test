package com.didekin.open.message;

import android.support.test.runner.AndroidJUnit4;

import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.InstanceIdResult;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static com.didekin.open.message.GcmServConstant.SCOPE_TOKEN;
import static com.didekin.open.message.GcmServConstant.SENDER_ID;
import static com.google.firebase.iid.FirebaseInstanceId.getInstance;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.waitAtMost;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class FireBaseIdTest {

    @Test
    public void test_Id_1() throws IOException
    {
        Task<InstanceIdResult> idResultTask = getInstance().getInstanceId();
        waitAtMost(6, SECONDS).until(idResultTask::isComplete);
        InstanceIdResult idResult = idResultTask.getResult();
        assertThat(idResult, notNullValue());
        String idResultId = idResult.getId();
        assertThat(idResultId, notNullValue());
        String idResultTk = idResult.getToken();
        assertThat(idResultTk, notNullValue());

        String token = getInstance().getToken(SENDER_ID, SCOPE_TOKEN);
        assertThat(token.equals(idResultTk), is(true));
    }
}
