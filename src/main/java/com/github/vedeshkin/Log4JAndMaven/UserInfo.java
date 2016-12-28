package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vedeshkin on 28.12.2016.
 */
public class UserInfo {
    @SerializedName("uid")
    private int uid;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("online")
    private int online;

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
