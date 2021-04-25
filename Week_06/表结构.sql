
-- # 用户表:用户id、名称、密码、手机号
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '名称',
  `password` varchar(16) NOT NULL DEFAULT '' COMMENT '密码',
  `phoneNumber` varchar(15) NOT NULL DEFAULT '' COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';


-- # 商品表：id、名称、类别、价格、重量
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '商品名',
  `sort` varchar(16) NOT NULL DEFAULT '' COMMENT '类别',
  `price` int NOT NULL DEFAULT '0' COMMENT '单价',
  `weight` int NOT NULL DEFAULT '0' COMMENT '重量（g）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品表';


-- # 订单表:id、用户id、订单状态、状态、总价、地址
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL COMMENT '用户id',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态（0-未付款，1-已付款，2-已取消，3-已完成）',
  `price` int NOT NULL DEFAULT '0' COMMENT '订单总价',
  `address` varchar(100) CHARACTER SET latin1 NOT NULL DEFAULT '' COMMENT '订单地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
