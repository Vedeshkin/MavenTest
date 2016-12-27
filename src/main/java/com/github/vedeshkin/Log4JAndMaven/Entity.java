package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vedeshkin on 27.12.2016.
 */
public class Entity {
    @SerializedName("first_name")
    String FirstName;
    @SerializedName("last_name")
    String LastName;
    @SerializedName("online")
    boolean online;
    public  Entity(){}
}
