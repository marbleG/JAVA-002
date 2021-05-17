#### 9.（必做）读写分离 - 动态切换数据源版本 1.0  
相关应用：homework07  
执行测试代码，控制台打印数据源切换提示信息，增删改走主数据源master，查询走slave数据库

#### 10.（必做）读写分离 - 数据库框架版本 2.0
相关应用：homework07_sharding

启动后和通过rest接口进行测试  
相同数据库服务不同数据库实例相同表名  
主:mysql://localhost:3307/master  
从:mysql://localhost:3307/slave  
1. 获取用户  
    `GET http://localhost:8088/list-user`  
    读从库  
2. 保存用户  
    `POST http://localhost:8088/save-user`   
    写主库

