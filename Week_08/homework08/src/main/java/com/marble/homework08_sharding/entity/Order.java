package com.marble.homework08_sharding.entity;

import lombok.Data;

import java.util.Date;

/**
 * Order表
 */
@Data
public class Order {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 地址
     */
    private String address;
    /**
     * 价格
     */
    private Integer price;


    private Integer status;

}