package com.darren.test.https.v45;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");
        HttpClient httpClient = null;

        httpClient = new HTTPSTrustClient().init();
        //httpClient = new HTTPSCertifiedClient().init();

        String url = "https://mediaview.nielsen.com:443/campaignratings/api/v5/CampaignPlacementExposure";
      //String url = "https://mediaview.nielsen.com:443/campaignratings/api/v4/CampaignExposure";
        //String url = "https://mediaview.nielsen.com:8011/campaignratings/api/v4/CampaignExposure";

        Map<String, String> paramHeader = new HashMap<>();
        //paramHeader.put("Content-Type", "application/json");
        paramHeader.put("Accept", "application/json");
        paramHeader.put("token", "eseJcF0SqvXZ+V1hZrhB+ilUYDcbBFGD0rzkxCHjHCTRq4bb701fD+n1iZbMvX5a+o9Ce/A8w4xF/m3KOphqUMxRgAlLVHZw0n4E6A1iZTrm8Yb3Y6DXzmCz9FCQ2OGOpl46Jf/d4uio6Fn+X3nAda8R2NcYiiSOxk8Xg5Wx3oP+HkpHoh8nOPRfy6SfCNc4NOzdxB2bGu7ao8MPRgqu3yIoCFty2BwsFL7y9mgLO9EkruoKuCyJLSwKF62tbTd79uavAfPxjQrKYbXK7crFP2ulPz3RUK8qT3bbSqe8QU+xuSG7jXSCmk8mgaCjuBhSQh8vjuT/KJDs3dpIGoNuMA==");
        Map<String, String> paramBody = new HashMap<>();
        paramBody.put("countryCode", "CN");
        paramBody.put("campaignId", "2075");
        paramBody.put("date", "06/07/2017");
        //paramBody.put("targetAudienceInd", "Y");
        //paramBody.put("platformId", "11");
        long start  = System.currentTimeMillis();
        String result = HTTPSClientUtil.doPost(httpClient, url, paramHeader, paramBody);
        
        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);
        long end  = System.currentTimeMillis();
        System.out.println("Request time" + (end-start)/1000.0 + " s");
        System.out.println(result);
        long end1  = System.currentTimeMillis();
        System.out.println("Print time" + (end1-end)/1000.0 + " s");
    }

}
