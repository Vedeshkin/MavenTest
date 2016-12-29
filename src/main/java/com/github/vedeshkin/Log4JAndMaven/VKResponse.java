package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vedeshkin on 27.12.2016.
 */
public class VKResponse implements Serializable {
@SerializedName("response")
    private ArrayList<UserInfo> userInfo;

    public ArrayList<UserInfo> getUsers() {
        return userInfo;
    }
}
