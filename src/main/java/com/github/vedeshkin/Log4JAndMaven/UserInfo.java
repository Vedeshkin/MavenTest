package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vedeshkin on 28.12.2016.
 */
public class UserInfo {
    @SerializedName("uid")
    private int uid;
    @SerializedName("first_name")
    private  String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("online")
    private int online;

    public int getOnline() {
        return online;
    }

    public int getUid() {
        return uid;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", online=" + online +
                '}';
    }
}
