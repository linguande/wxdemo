package com.example.wxdemo.manage;

import com.example.wxdemo.entity.AccessToken;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 16:54
 **/
public class AccessTokneManage {
    private volatile static ConcurrentHashMap<String,AccessToken> map = new ConcurrentHashMap<String,AccessToken>();

    @Value("corpsecret")
    private static String secret;

    private AccessTokneManage(){

    }

    public static AccessToken getAccessToken(){
        return getAccessToken(secret);
    }


    //根据应用secret来获取对应的access_token
    public static AccessToken getAccessToken(String secret){
        AccessToken accessToken = map.get(secret);
        if(accessToken == null){
            synchronized (AccessTokneManage.class){
                if (accessToken == null){

                }
            }
        }
        return accessToken;
    }
}
