package com.github.vedeshkin.Log4JAndMaven;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vedeshkin on 30.12.2016.
 */
public class Report extends TimerTask {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Report.class);
    private List<UserInfo> userInfos;
    private StatusManager sm;
    private final String format = "%s(%d) was %s from %s to %s ";
    private final SimpleDateFormat simpleDateFormat;

    public Report(StatusManager sm) {
        this.sm = sm;
        this.userInfos = sm.getUserList();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    }

    @Override
    public void run() {


        for (UserInfo u : userInfos) {
            String userName = u.getFullName();
            int uid = u.getUid();
            List<Status> statuses = sm.getStatusList(uid);

            try (
                    PrintWriter pw = new PrintWriter("C:\\ReportFor_"+uid+".txt")) {

                for (int i = statuses.size() - 1; i >= 0; i--) {
                    Date beginDate = statuses.get(i).getEntered();
                    Date endDate = (i - 1 >= 0) ? statuses.get(i - 1).getEntered() : new Date();
                    String status = statuses.get(i).getStatus();
                    pw.println(String.format(format, userName,uid, status, simpleDateFormat.format(beginDate), simpleDateFormat.format(endDate)));
                }
                pw.flush();
            } catch (FileNotFoundException exception) {
                log.error(exception.getMessage(), exception);
            }

        }
    }

}
