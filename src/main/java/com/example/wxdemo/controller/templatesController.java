package com.example.wxdemo.controller;

import com.example.wxdemo.entity.JsApiTicket;
import com.example.wxdemo.manage.AccessTokneManage;
import com.example.wxdemo.util.TokenUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 14:49
 **/
@Controller
public class templatesController {

    @Value("${corpid}")
    private static String corpid;

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request, Model model) throws IOException {

        JsApiTicket jsApiTicket = TokenUtils.getJsApiTicket(AccessTokneManage.getAccessToken().getAccess_token());
        String jsapi_ticket = jsApiTicket.getTicket();
        //获取签名signature
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        //获取请求url
        String path = request.getContextPath();

        String url = request.getScheme() + "://" + request.getServerName() + path + "/";
        String str = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + noncestr +
                "&timestamp=" + timestamp +
                "&url=" + url;
        String signature = DigestUtils.sha1Hex(str);
        model.addAttribute("signature", signature);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("noncestr", noncestr);
        model.addAttribute("appId", corpid);
        return "index";
    }
}
