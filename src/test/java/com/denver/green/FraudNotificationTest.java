package com.denver.green;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by degreen on 2017-01-27.
 */
public class FraudNotificationTest {

    private Scanner in;

    @Before
    public void setUp() throws Exception {
        // Locate input file describing graph and create an input stream that
        // will read from it.
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);
        FileInputStream fis = new FileInputStream(
                "src" + File.separator +"test" + File.separator + "resources" + File.separator + "median.txt");
        in = new Scanner(new BufferedInputStream(fis));
    }

    @Test
    public void countNotifications() throws Exception {
        int timePeriod = in.nextInt();
        int windowSize = in.nextInt();
        int[] expenditures = new int[timePeriod];
        for (int i = 0; i < timePeriod; i++) {
            expenditures[i] = in.nextInt();
        }
        FraudNotification fn = new FraudNotification(windowSize, expenditures);
        assertEquals(926, fn.countNotifications());
    }

}