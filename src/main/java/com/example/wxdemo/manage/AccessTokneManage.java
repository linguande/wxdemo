package com.example.wxdemo.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.wxdemo.entity.AccessToken;
import com.example.wxdemo.util.TokenUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 16:54
 **/
public class AccessTokneManage {
    private volatile static ConcurrentHashMap<String, AccessToken> map = new ConcurrentHashMap<String, AccessToken>();

    private AccessTokneManage() {

    }


    /**
     * 根据应用secret来获取对应的access_token
     **/
    public static AccessToken getAccessToken(String secret,String corpid) throws IOException {
        AccessToken accessToken = map.get(secret);
        if (accessToken == null) {
            synchronized (AccessTokneManage.class) {
                if (accessToken == null) {
                    accessToken = TokenUtils.getAccessTokenStr(secret,corpid);
                    map.put(secret, accessToken);
                }
            }
        }
        return accessToken;
    }
}
