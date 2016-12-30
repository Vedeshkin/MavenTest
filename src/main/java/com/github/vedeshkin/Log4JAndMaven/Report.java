package com.github.vedeshkin.Log4JAndMaven;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

/**
 * Created by vedeshkin on 30.12.2016.
 */
 public class Report extends TimerTask {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Report.class);
     private List<UserInfo> userInfos;
     private StatusManager sm;
     private final String format = "[%d]:%s was %s from %s to %s ";
     SimpleFormatter sf;
     public Report(List<UserInfo> userInfos,StatusManager sm){
      this.userInfos = userInfos;
      sf = new SimpleFormatter()
     }

    @Override
    public void run() {
        for (UserInfo u: userInfos)
        {
            String userName = u.getFullName();
            int uid = u.getUid();
            List<Status> statuses = sm.getStatusList(uid);
            Iterator<Status> iter = statuses.iterator();
            if(statuses.size() == 1)
            {

            }

        }

    }
}
