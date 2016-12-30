package com.github.vedeshkin.Log4JAndMaven;

import org.apache.log4j.Logger;

import java.util.Timer;

/**
 * Created by vedeshkin on 30.12.2016.
 */
public class ReportManager {

    private Timer timer;
    private static final Logger log = Logger.getLogger(ReportManager.class);
    public ReportManager()
    {
        timer = new Timer();
        log.info("Report Manager initialized");
    }
    public void addReport(Report report)
    {

    }

}
