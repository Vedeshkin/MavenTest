package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.Gson;

import org.apache.log4j.Logger;


import java.io.InputStreamReader;

import java.net.URL;

/**
 * Created by vedeshkin on 27.12.2016.
 */
public class Main{
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception{
        log.info("Something here");
        URL url = new URL("https://api.vk.com/method/users.get?user_ids=olyousya&fields=online,last_seen");
        Gson gson = new Gson();
        VKResponse vkResponse = gson.fromJson(new InputStreamReader(url.openStream()),VKResponse.class);
        for (UserInfo u : vkResponse.getUserInfo())
        {
            System.out.println(u);
        }



    }
}
