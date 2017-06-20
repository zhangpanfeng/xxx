package com.darren.test.https.v42;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.SSLSocketFactory;

public class HTTPSTrustClient extends HTTPSClient {

    public HTTPSTrustClient() {

    }

    @Override
    public void prepareCertificate() throws Exception {
        // 跳过证书验证
        SSLContext ctx = SSLContext.getInstance("TLS");
        X509TrustManager tm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        // 设置成已信任的证书
        ctx.init(null, new TrustManager[] { tm }, null);
        // 穿件SSL socket 工厂，并且设置不检查host名称
        this.socketFactory = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    }
}
