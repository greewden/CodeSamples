package com.denver.green;

/**
 * Hello world!
 *
 */

import org.apache.logging.log4j.Logger;

public class App {

    static final Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        // Configure logger
        logger.debug("Hello Log!");
    }
}
