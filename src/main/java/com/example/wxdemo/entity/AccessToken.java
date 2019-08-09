package com.example.wxdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: linguande
 * @create: 2019-08-09 16:52
 **/
@Getter
@Setter
public class AccessToken extends BaseEntity{

    private String access_token;

    private int expires_in;

}
