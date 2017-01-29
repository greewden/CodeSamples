package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by degreen on 2017-01-27.
 */
public class FraudNotificationTest {
    @Test
    public void countNotifications() throws Exception {
        int[] expenditures = {1, 2, 3, 4, 4};
        int window = 4;

        FraudNotification fn = new FraudNotification(window, expenditures);
        assertEquals(0, fn.countNotifications());
    }

}