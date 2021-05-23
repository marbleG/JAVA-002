package com.marble.homework08_sharding.mapper;


import com.marble.homework08_sharding.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 订单order
 */
@Mapper
public interface OrderMapper {

    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int insert(Order record);

    /**
     * 获取所有订单
     */
    List<Order> selectAll();

}