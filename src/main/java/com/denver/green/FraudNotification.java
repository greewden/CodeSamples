package com.denver.green;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

import static java.util.Arrays.copyOfRange;

/**
 * Created by degreen on 2017-01-27.
 *
 * https://www.hackerrank.com/rest/contests/master/challenges/fraudulent-activity-notifications/download_pdf?language=English
 */
public class FraudNotification {
    private static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    private int[] expenditures; // Array containing all expenditures made.
    private int[] counts;       // Array containing a frequency count of the expenditures made in the d previous days.
    private int windowSize;     // Number of previous days data to use to calculate the median.
    private boolean odd;        // Set to true if windowSize is odd.
    private int idxOfMedian;    // Set to the idx of the element containing the median.


    public FraudNotification(int w, int[] e) {
        long tStartNS = threadMXBean.getCurrentThreadCpuTime();
        expenditures = e;
        windowSize = w;

        // Update the counts array to reflect the expenditures made in the initial d days.
        counts = new int[201];
        int[] tmp = copyOfRange(expenditures, 0, windowSize);
        for (int expenditure : tmp) {
            counts[expenditure] += 1;
        }

        if (windowSize % 2 == 1) {
            odd = true;
            idxOfMedian = windowSize / 2 + 1;
        } else {
            odd = false;
            idxOfMedian = windowSize / 2;
        }

        long tEndNS = threadMXBean.getCurrentThreadCpuTime();
        System.out.println(String.format("Total CPU time for creating fraud object: %.6f sec", (float)(tEndNS - tStartNS) / 1.0e9));
    }

    public static void main(String[] args) {
        long tStartNS = threadMXBean.getCurrentThreadCpuTime();
        Scanner in = new Scanner(System.in);
        int timePeriod = in.nextInt();
        int windowSize = in.nextInt();
        int[] expenditures = new int[timePeriod];
        for (int i = 0; i < timePeriod; i++) {
            expenditures[i] = in.nextInt();
        }
        long tEndNS = threadMXBean.getCurrentThreadCpuTime();
        System.out.println(String.format("Total CPU time for reading input: %.6f sec", (float)(tEndNS - tStartNS) / 1.0e9));

        System.out.println("Creating fraudNotification object.");
        FraudNotification fn = new FraudNotification(windowSize, expenditures);
        System.out.println("Finished creating fraudNotification object.");
        System.out.print(fn.countNotifications());
    }

    public int countNotifications() {
        long tStartNS = threadMXBean.getCurrentThreadCpuTime();
        int count = 0; // Count of the number of fraud notifications sent.
        for (int i = 0; i < expenditures.length - windowSize; i++) {
            float median = median();
            if (expenditures[windowSize + i] >= (2 * median)) {
                count++;  // Increment fraud count.
            }

            // update count array to reflect the addition and removal of values.
            moveWindow(expenditures[i], expenditures[i + windowSize]);
        }
        long tEndNS = threadMXBean.getCurrentThreadCpuTime();
        System.out.println(String.format("Total CPU time for performing count: %.6f sec", (float)(tEndNS - tStartNS) / 1.0e9));
        return count;
    }

    private void moveWindow(int valueToRemove, int valueToAdd) {
        // Remove value that moved out of the window.
        counts[valueToRemove] -= 1;
        // Add value that moved into the window.
        counts[valueToAdd] += 1;
    }


    private float median() {
        float median = 0;

        // Determine median value. This is done by walking through the counts array and summing the elements
        // until the sum is greater than or equal to the index of the median value in the sorted array
        // containing the previous d days expenditures. If the size of the array is odd then the median is
        // the index of the last element added to the sum. If array  size is even then the median is the
        // average of index of the last element added to the sum and the index of the next non-zero element in
        // the count array, if the sum produced by adding the last element is equal to the index of the median.
        // If the sum is greater than the median then the value the idx represents occurs more than once and the
        // average of two numbers that are the same is the original number.
        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            sum += counts[i];
            if (sum >= idxOfMedian) {
                median = i;
                if (sum > idxOfMedian || odd) {
                    break;
                }
                i++;
                while (counts[i] == 0) {
                    i++;
                }
                median = (median + i) / 2.0f;
                break;
            }
        }
        return median;
    }
}
