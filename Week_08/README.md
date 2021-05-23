#### 2.（必做）设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。
相关应用：homework08  
sql教本：homework08/src/main/resources/homework08.sql

启动后和通过rest接口进行测试  
相同数据库服务不同数据库实例相同表名  
分库:  
    1. mysql://localhost:3307/demo_ds_0  
    2. mysql://localhost:3307/demo_ds_1  
分表:  
    1. demo_ds_0.order0  
    2. demo_ds_0.order1  
    2. demo_ds_1.order0  
    2. demo_ds_1.order1  
1. 获取用户  
   `GET http://localhost:8088/list-order`
2. 保存用户  
   `POST http://localhost:8088/save-order`
