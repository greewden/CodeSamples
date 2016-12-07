package com.denver.green;

/**
 * Hello world!
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        // Configure logger
        logger.debug("Hello Log!");
    }
}
