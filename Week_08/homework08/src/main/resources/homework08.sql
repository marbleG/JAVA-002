-- 创建ds0数据库
CREATE SCHEMA `demo_ds_0` DEFAULT CHARACTER SET utf8mb4;
-- 创建ds1数据库
CREATE SCHEMA `demo_ds_1` DEFAULT CHARACTER SET utf8mb4;

CREATE TABLE `order0`
(
    `id`      int          NOT NULL AUTO_INCREMENT,
    `uid`     int          DEFAULT NULL COMMENT '用户id',
    `status`  tinyint      NOT NULL DEFAULT '0' COMMENT '状态（0-未付款，1-已付款，2-已取消，3-已完成）',
    `price`   int          NOT NULL DEFAULT '0' COMMENT '订单总价',
    `address` varchar(100) NOT NULL DEFAULT '' COMMENT '订单地址',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order1`
(
    `id`      int          NOT NULL AUTO_INCREMENT,
    `uid`     int          DEFAULT NULL COMMENT '用户id',
    `status`  tinyint      NOT NULL DEFAULT '0' COMMENT '状态（0-未付款，1-已付款，2-已取消，3-已完成）',
    `price`   int          NOT NULL DEFAULT '0' COMMENT '订单总价',
    `address` varchar(100) NOT NULL DEFAULT '' COMMENT '订单地址',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
