package com.marble.homework08_sharding.controller;


import com.marble.homework08_sharding.entity.Order;
import com.marble.homework08_sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 接口测试
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Description: 保存用户
     */
    @PostMapping("save-order")
    public Object saveOrder() {
        Order order1 = new Order();
        order1.setId(1);
        order1.setAddress("test");
        order1.setPrice(18);
        order1.setUid(1);
        Order order2 = new Order();
        order2.setId(2);
        order2.setAddress("test");
        order2.setPrice(18);
        order2.setUid(2);
        orderService.saveOne(order1);
        return orderService.saveOne(order2);
    }

    /**
     * @Description: 获取订单列表
     */
    @GetMapping("list-order")
    public Object listOrder() {
        return orderService.list();
    }

}
