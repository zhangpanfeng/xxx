package com.darren.test.https.v42;

import java.util.HashMap;
import java.util.Map;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HTTPSClient httpsClient = null;

        httpsClient = new HTTPSTrustClient().init();
        //httpsClient = new HTTPSCertifiedClient().init();

        //String url = "https://mediaview.nielsen.com:443/campaignratings/api/getToken";
        String url = "https://mediaview.nielsen.com:443/campaignratings/api/v5/CampaignPlacementExposure";
        //String url = "https://10.227.6.220:8011/campaignratings/api/getHealth";

        Map<String, String> paramHeader = new HashMap<>();
        //paramHeader.put("Content-Type", "application/json");
//        paramHeader.put("Accept", "application/json");
//        Map<String, String> paramBody = new HashMap<>();
//        paramBody.put("client_id", "ankur.tandon.ap@nielsen.com");
//        paramBody.put("client_secret", "P@ssword_1");
        
        paramHeader.put("Accept", "application/json");
        paramHeader.put("token", "eseJcF0SqvXZ+V1hZrhB+ilUYDcbBFGD0rzkxCHjHCTRq4bb701fD+n1iZbMvX5a+o9Ce/A8w4xF/m3KOphqUMxRgAlLVHZw0n4E6A1iZTrm8Yb3Y6DXzmCz9FCQ2OGOpl46Jf/d4uio6Fn+X3nAda8R2NcYiiSOxk8Xg5Wx3oP+HkpHoh8nOPRfy6SfCNc4NOzdxB2bGu7ao8MPRgqu3yIoCFty2BwsFL7y9mgLO9EkruoKuCyJLSwKF62tbTd79uavAfPxjQrKYbXK7crFP2ulPz3RUK8qT3bbSqe8QU+xuSG7jXSCmk8mgaCjuBhSQh8vjuT/KJDs3dpIGoNuMA==");
        Map<String, String> paramBody = new HashMap<>();
        paramBody.put("countryCode", "CN");
        paramBody.put("campaignId", "2075");
        paramBody.put("date", "06/07/2017");
        String result = HTTPSClientUtil.doPost(httpsClient, url, paramHeader, paramBody);
        
        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);
        
        System.out.println(result);
    }

}
