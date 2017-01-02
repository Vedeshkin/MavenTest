package com.github.vedeshkin.Log4JAndMaven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vedeshkin on 30.12.2016.
 */
public class Report extends TimerTask {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Report.class);
    private List<UserInfo> userInfos;
    private StatusManager sm;
    private final String format = "[%d]:%s was %s from %s to %s ";
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
                    FileWriter fw = new FileWriter(new File("C:\\" + userName + ".txt"))) {

                for (int i = statuses.size() - 1; i > 0; i--) {
                    Date beginDate = statuses.get(i).getEntered();
                    Date endDate = (i - 1 >= 0) ? statuses.get(i - 1).getEntered() : new Date();
                    String status = statuses.get(i).getStatus();
                    fw.write(String.format(format, uid, userName, status, simpleDateFormat.format(beginDate), simpleDateFormat.format(endDate)));
                }
                fw.flush();
            } catch (IOException exception) {
                log.error(exception.getMessage(), exception);
            }

        }
    }

}
