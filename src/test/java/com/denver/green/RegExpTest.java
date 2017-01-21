package com.denver.green;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 1/6/2017.
 */
public class RegExpTest {
    @Test
    public void filterAndSort() throws Exception {
        Map<String, String> data = new HashMap<>(6);
        data.put("riya@gmail.com", "riya");
        data.put("julia@julia.me", "julia");
        data.put("sjulia@gmail.com", "julia");
        data.put("julia@gmail.com", "julia");
        data.put("samantha@gmail.com", "samantha");
        data.put("tanya@gmail.com", "tanya");
        String filter = "@gmail\\.com$";

        Collection expected = new ArrayList<String>(5);
        expected.add("julia");
        expected.add("julia");
        expected.add("riya");
        expected.add("samantha");
        expected.add("tanya");
        Collection results = new RegExp().filterAndSort(data, filter);
        assertEquals(expected, results);
    }

}