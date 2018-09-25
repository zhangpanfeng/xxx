package com.darren.test.https.url;

import java.util.HashMap;
import java.util.Map;

import com.darren.test.util.JSONUtil;

public class HttpURLConnectionTest {

    public static void main(String[] args) {
        HttpURLConnectionClient httpsClient = HttpURLConnectionClient.getInstance();

        //String url = "https://mediaview.nielsen.com:443/campaignratings/api/getToken";
        //String url = "https://mediaview.nielsen.com:443/campaignratings/api/v1/DeviceReference";
        //String url = "https://10.227.6.220:8011/campaignratings/api/getHealth";
        String url = "http://localhost:8080/personal/restful/receiveMapAsBody.html";

        Map<String, String> paramHeader = new HashMap<>();
        //paramHeader.put("Content-Type", "application/json");
//        paramHeader.put("Accept", "application/json");
//        Map<String, String> paramBody = new HashMap<>();
//        paramBody.put("client_id", "ankur.tandon.ap@nielsen.com");
//        paramBody.put("client_secret", "P@ssword_1");
        
        paramHeader.put("Accept", "application/json");
        paramHeader.put("token", "NidrTXrX16ZrD4KCPMDXyYbiQ1/Eq5HyCaQeNUwVthuhSedNHfqDGRC81xX1ke6rAa+NjmqFpIsdXV10ic9ZDyyWFMM3l5ttzwcWMqwb70dFM4DHrhH4sDzQ0bfuFT5HtwzQe9ylFJn4PeTdPASgF2G0pMy8paybxQjp0XV80r+to2WBRTYrfofMDCmBt95E/o9t33fwM0cSrtOOvFr1Pf1eYOU1+Jyk32SIaEaK/YTlHpFAmBLj0RU4MsrrDHjbRmG16Jri8Ip0JW/Kwhth1MD/+KXkyPkddqDJ2fT1Ri5BSU3KyuRvTNzIDtxgqKS3uFwBVHD50B53gCqj+8l4wg==");
        Map<String, String> paramBody = new HashMap<>();
        paramBody.put("countryCode", "CN");
        paramBody.put("campaignId", "2075");
        paramBody.put("date", "06/07/2017");
        paramBody.put("body", "06/07/2017");
        
        String data = JSONUtil.toJsonString(paramBody);
        //String data = "body=i am body";
       // String result = httpsClient.httpsPost(url, paramHeader, null);
        String result = httpsClient.post(url, paramHeader, data);
        
        
        System.out.println(result);
    }

}
