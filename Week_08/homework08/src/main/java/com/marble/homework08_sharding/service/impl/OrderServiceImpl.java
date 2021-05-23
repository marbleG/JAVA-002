package com.marble.homework08_sharding.service.impl;

import com.marble.homework08_sharding.entity.Order;
import com.marble.homework08_sharding.mapper.OrderMapper;
import com.marble.homework08_sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> list() {
        List<Order> orders = orderMapper.selectAll();
        return orders;
    }

    @Override
    public String saveOne(Order order) {
        order.setPrice(123);
        order.setStatus(1);
        orderMapper.insert(order);
        return "保存成功";
    }
}
