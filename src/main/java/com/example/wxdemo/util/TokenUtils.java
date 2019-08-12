package com.example.wxdemo.util;

import com.alibaba.fastjson.JSON;
import com.example.wxdemo.entity.AccessToken;
import com.example.wxdemo.entity.JsApiTicket;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 17:11
 **/
public class TokenUtils {

    @Value("${corpid}")
    private static String corpid;

    @Value("${corpsecret}")
    private static String corpsecret;

    public static AccessToken getAccessTokenStr(String secret) throws IOException {
        if (StringUtils.isBlank(secret)) {
            secret = corpsecret;
        }
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
        String result = HttpUtils.sendGet(url);
        AccessToken accessToken = (AccessToken) JSON.parse(result);
        return accessToken;
    }


    public static JsApiTicket getJsApiTicket(String accessToken) throws IOException {
        String url ="https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token="+accessToken;
        String result = HttpUtils.sendGet(url);
        JsApiTicket jsApiTicket =(JsApiTicket) JSON.parse(result);
        return jsApiTicket;
    }
}
