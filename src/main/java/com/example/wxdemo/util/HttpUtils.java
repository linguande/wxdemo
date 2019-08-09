package com.example.wxdemo.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 17:28
 **/
public class HttpUtils {

    @Value("${corpid}")
    private static String corpid;

    @Value("${corpsecret}")
    private static String corpsecret;

    public static String sendPost(String url, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public static String sendGet(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public static String getAccessTokenStr(String secret){
        if(StringUtils.isBlank(secret)){
            secret = corpsecret;
        }
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+secret;
        String result = "";
        try {
            result = sendGet(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
