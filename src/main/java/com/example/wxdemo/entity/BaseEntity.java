package com.example.wxdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 基本entity
 * @author: linguande
 * @create: 2019-08-09 16:49
 **/
@Setter
@Getter
public class BaseEntity implements Serializable {

    //错误码
    private int errcode;

    //错误信息
    private String errmsg;
}
