package com.github.vedeshkin.Log4JAndMaven;

import java.util.*;

/**
 * Created by vedeshkin on 30.12.2016.
 */
public class StatusManager {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StatusManager.class);
    private Map<Integer, List<Status>> dataStorage;

    public StatusManager() {
        dataStorage = new HashMap<>();
        log.info("Status Manager is ready");
        log.info("Storage size is " + dataStorage.size());

    }

    public void init(List<UserInfo> user) {
        if (user == null) {
            log.error("Unable to init StatusManager");
            System.exit(0);
        }
        for (UserInfo u : user) {
            List<Status> statuses = new LinkedList<>();
            statuses.add(new Status(u.getOnline()));
            dataStorage.put(u.getUid(), statuses);
        }
        log.info("Init complete.Storage size is " + dataStorage.size());
    }

    public void compareStatus(UserInfo u) {

        int uid = u.getUid();
        int online = u.getOnline();
        if (online != getLastStatus(uid)) {
            Status status = new Status(online);
            log.info("Status changed  for uid " + uid);
            List<Status> statuses = getStatusList(uid);
            statuses.add(0, status);
            dataStorage.put(uid, statuses);
        }
        log.info("Seems like status is the same");
    }



    private int getLastStatus(int uid) {
        return dataStorage.get(uid).get(0).getOnline();
    }

    private List getStatusList(int uid) {
        return dataStorage.get(uid);
    }

}
