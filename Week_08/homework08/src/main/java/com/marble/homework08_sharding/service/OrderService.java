package com.marble.homework08_sharding.service;

import com.marble.homework08_sharding.entity.Order;

import java.util.List;

/**
 * @Description: 订单相关接口
 */
public interface OrderService {

    /**
     * 获取所有用户信息
     */
    List<Order> list();

    /**
     * 单个 保存订单信息
     *
     * @param user
     */
    String saveOne(Order user);

}