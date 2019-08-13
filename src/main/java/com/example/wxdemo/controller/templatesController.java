package com.example.wxdemo.controller;

import com.example.wxdemo.entity.JsApiTicket;
import com.example.wxdemo.manage.AccessTokneManage;
import com.example.wxdemo.util.TokenUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
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
    private String corpid;

    @Value("${corpsecret}")
    private String corpsecret;


    @RequestMapping("/getLocation")
    public String toIndex(HttpServletRequest request, Model model) throws IOException {

        JsApiTicket jsApiTicket = TokenUtils.getJsApiTicket(AccessTokneManage.getAccessToken(corpsecret,corpid)
                .getAccess_token());
        String jsapi_ticket = jsApiTicket.getTicket();
        //获取签名signature
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);


        String url = request.getScheme() //当前链接使用的协议
                +"://" + request.getServerName()//服务器地址
                + ":" + request.getServerPort() //端口号
                + request.getContextPath() //应用名称，如果应用名称为
                + request.getServletPath();//请求的相对url
        String str = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + noncestr +
                "&timestamp=" + timestamp +
                "&url=" + url;
        System.out.println("jsapi_ticket:"+jsapi_ticket);
        System.out.println("noncestr:"+noncestr);
        System.out.println("timestamp:"+timestamp);
        System.out.println("url:"+url);
        System.out.println("str:"+str);
        String signature = DigestUtils.sha1Hex(str);
        System.out.println("signature:"+signature);
        model.addAttribute("signature", signature);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("noncestr", noncestr);
        model.addAttribute("appId", corpid);
        return "location";
    }
}
