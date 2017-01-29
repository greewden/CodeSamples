package com.denver.green;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.sort;

/**
 * Created by degreen on 2017-01-27.
 *
 * https://www.hackerrank.com/rest/contests/master/challenges/fraudulent-activity-notifications/download_pdf?language=English
 */
public class FraudNotification {
    private int[] expenditures;
    private int windowSize;
    private List<Integer> window;
    private boolean odd;
    private int idxOfMedian;

    public FraudNotification(int w, int[] e) {
        expenditures = e;
        windowSize = w;

        // Populate the window with initial values and sort those values.
        int[] tmp = copyOfRange(expenditures, 0, windowSize);
        sort(tmp);
        window = IntStream.of(tmp).boxed().collect(Collectors.toList());
        if (windowSize % 2 == 1) {
            odd = true;
            idxOfMedian = windowSize / 2;
        } else {
            odd = false;
            idxOfMedian = windowSize / 2 - 1;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int timePeriod = in.nextInt();
        int windowSize = in.nextInt();
        int[] expenditures = new int[timePeriod];
        for (int i = 0; i < timePeriod; i++) {
            expenditures[i] = in.nextInt();
        }
        FraudNotification fn = new FraudNotification(windowSize, expenditures);
        System.out.print(fn.countNotifications());
    }

    public int countNotifications() {
        int count = 0;
        for (int i = 0; i < expenditures.length - windowSize; i++) {
            float median = median();
            if (expenditures[windowSize + i] >= (2 * median)) {
                count++;
            }
            moveWindow(expenditures[i], expenditures[i + windowSize]);
        }
        return count;
    }

    private void moveWindow(int valueToRemove, int valueToAdd) {
        // Remove value that moved out of the window.
        window.remove(findValue(window.toArray(new Integer[window.size()]), valueToRemove));
        // Add value that moved into the window.
        window.add(findValue(window.toArray(new Integer[window.size()]), valueToAdd), valueToAdd);
    }

    private int findValue(Integer[] a, int value) {
        int idx = Arrays.binarySearch(a, value);
        if (idx < 0) {
            return Math.abs(idx) - 1;
        } else {
            return idx;
        }
    }

    private float median() {
        if (odd) {
            return (window.get(idxOfMedian));
        } else {
            // array length is even, take the average of the two middle values.
            return (window.get(idxOfMedian) + window.get(idxOfMedian + 1)) / 2.0f;
        }
    }
}
