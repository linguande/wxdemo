package com.example.wxdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 14:39
 **/
@RestController
public class hello {
    @RequestMapping("/hello")
    public String index(){
        return "hello";
    }
}
