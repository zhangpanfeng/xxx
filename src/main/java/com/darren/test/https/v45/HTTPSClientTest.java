package com.darren.test.https.v45;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = null;

        //httpClient = new HTTPSTrustClient().init();
        httpClient = new HTTPSCertifiedClient().init();

        String url = "https://mediaview.nielsen.com:8011/campaignratings/api/getToken";
        //String url = "https://10.227.6.220:8011/campaignratings/api/getHealth";

        Map<String, String> paramHeader = new HashMap<>();
        //paramHeader.put("Content-Type", "application/json");
        paramHeader.put("Accept", "application/xml");
        Map<String, String> paramBody = new HashMap<>();
        paramBody.put("client_id", "ankur.tandon.ap@nielsen.com");
        paramBody.put("client_secret", "P@ssword_1");
        String result = HTTPSClientUtil.doPost(httpClient, url, paramHeader, paramBody);
        
        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);
        
        System.out.println(result);
    }

}
