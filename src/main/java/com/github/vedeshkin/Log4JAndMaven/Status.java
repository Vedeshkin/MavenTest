package com.github.vedeshkin.Log4JAndMaven;

import java.util.Date;

/**
 * Created by vedeshkin on 30.12.2016.
 */
public class Status {
    private Date entered;
    private int isOnline;

    public Status(int status)
    {
        entered = new Date();
        isOnline = status;
    }

    public int getOnline() {
        return isOnline;
    }

    public String getStatus()
    {
        return isOnline == 1 ? "online" : "offline";

    }
    public Date getEntered(){
        return entered;
    }
}
