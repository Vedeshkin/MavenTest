package com.github.vedeshkin.Log4JAndMaven;

import org.apache.log4j.Logger;

/**
 * Created by vedeshkin on 27.12.2016.
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Something here");
        log.error("ERROR");
        log.warn("Logger is working");
    }
}
