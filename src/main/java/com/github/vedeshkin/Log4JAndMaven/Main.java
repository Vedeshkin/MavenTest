package com.github.vedeshkin.Log4JAndMaven;

import com.google.gson.Gson;

import org.apache.log4j.Logger;


import java.io.IOException;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vedeshkin on 27.12.2016.
 */
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    static private Gson gson;
    private int requestCount;
    private URL url ;

    public static void main(String[] args) throws Exception {
        Main app = new Main();
        app.start();

    }

    private VKResponse getResponse(URL url) {
        VKResponse vkResponse = null;
        try {
            vkResponse = gson.fromJson(new InputStreamReader(url.openStream()), VKResponse.class);
        }catch (IOException exception){
            log.error(exception.getMessage(),exception);
        }

        return vkResponse;
    }

    public void start() {
        try {
            url = new URL("https://api.vk.com/method/users.get?user_ids=interzest&fields=online");//Should be in properties
        }
        catch (MalformedURLException exception){
            log.error(exception.getMessage(),exception);
        }
        log.info(url);
        StatusManager sm = new StatusManager();
        sm.init(getResponse(url).getUsers());
        ReportManager rm = new ReportManager();
        rm.addReport(new Report(sm));
        while (true) {


            log.info("Attempt to process request no. " + requestCount);
            for (UserInfo u : getResponse(url).getUsers()){

            sm.compareStatus(u);
            log.info(u + " Has been successfully parsed.");
        }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exception) {
                log.trace(exception.getMessage(), exception);
            }

            log.info("Request no. " + requestCount + " has been processed");
            requestCount++;
        }

    }

    public Main() throws MalformedURLException {
        log.info("Constructing main App");
        gson = new Gson();
        requestCount = 0;

    }
}
