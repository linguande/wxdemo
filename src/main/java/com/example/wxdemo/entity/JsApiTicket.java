package com.example.wxdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-12 14:42
 **/
@Getter
@Setter
public class JsApiTicket extends BaseEntity {

    private String ticket;

    private int expires_in;

    private int createTime;
}
