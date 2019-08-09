package com.example.wxdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 14:49
 **/
@Controller
public class templatesController {

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
}
