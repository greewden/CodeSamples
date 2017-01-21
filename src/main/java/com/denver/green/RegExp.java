package com.denver.green;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denver on 1/6/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/19060-30-regex-patterns-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1483762944&Signature=OKmYgumjrRjW%2FjngueMagVO4wj8%3D&response-content-disposition=inline%3B%20filename%3D30-regex-patterns-English.pdf&response-content-type=application%2Fpdf
 */
public class RegExp<T, U> {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, String> people = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String email = in.next();
            people.put(email, name);
        }
        in.close();
        RegExp<String, String> regExp = new RegExp<>();
        String filter = "@gmail\\.com$";
        Collection<String> results = regExp.filterAndSort(people, filter);
        results.forEach(System.out::println);
    }

    /**
     * Returns a sorted collection containing a subset of the contents of data that match the
     * criteria specified by filter.
     *
     * @param data
     * @param filter
     * @return A sorted collection.
     */
    Collection<U> filterAndSort(Map<T, U> data, String filter) {
        Pattern p = Pattern.compile(filter);
        ArrayList<U> results = new ArrayList<>(data.size());
        // Loop through data and retrieve the desired entries.
        for (Map.Entry<T, U> entry : data.entrySet()) {
            Matcher m = p.matcher(entry.getKey().toString());
            if (m.find()) {
                results.add(entry.getValue());
            }
        }
        // Sort selected entries.
        results.sort(null);
        return results;
    }
}
