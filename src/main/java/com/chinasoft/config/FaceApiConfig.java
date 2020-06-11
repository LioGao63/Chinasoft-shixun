package com.chinasoft.config;

import com.baidu.aip.face.AipFace;

public class FaceApiConfig {

    public static final String APP_ID = "20346965";
    public static final String API_KEY = "uzb3bWyIfIrEQyODp19BXkQD";
    public static final String SECRET_KEY = "gUdulfPEK4sqiMuCpUCZNVSyhn0kUsrM";

    private static AipFace client;

    public static AipFace getClient(){

        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }
}
