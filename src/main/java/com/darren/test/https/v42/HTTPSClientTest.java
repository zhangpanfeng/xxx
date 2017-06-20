package com.darren.test.https.v42;

import java.util.HashMap;
import java.util.Map;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HTTPSClient httpsClient = null;

        httpsClient = new HTTPSTrustClient().init();
        //httpsClient = new HTTPSCertifiedClient().init();

        String url = "https://10.227.6.220:8011/campaignratings/api/getToken";
        //String url = "https://10.227.6.220:8011/campaignratings/api/getHealth";

        Map<String, String> paramHeader = new HashMap<>();
        //paramHeader.put("Content-Type", "application/json");
        paramHeader.put("Accept", "application/xml");
        Map<String, String> paramBody = new HashMap<>();
        paramBody.put("client_id", "ankur.tandon.ap@nielsen.com");
        paramBody.put("client_secret", "P@ssword_1");
        String result = HTTPSClientUtil.doPost(httpsClient, url, paramHeader, paramBody);
        
        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);
        
        System.out.println(result);
    }

}
