package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;

/**
 * Created by vedeshkin on 27.12.2016.
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Something here");
        while(true)
        {
            try(
                    InputStreamReader reader = new InputStreamReader(new URL("https://api.vk.com/method/users.get?user_ids=olyousya&fields=online,last_seen").openStream())
            ){
                Entity ent = new Gson(
                ).fromJson(reader,Entity.class);
                System.out.println(ent.LastName);
                Thread.sleep(1000);
            }
            catch (Exception e ){}
        }
    }
}
