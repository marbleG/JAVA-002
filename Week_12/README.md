#### 1.（必做）配置 redis 的主从复制，sentinel 高可用，Cluster 集群。

1. 主从复制
    1. 启动主redis `redis-serve redis6379.conf`
    1. 启动从redis `redis-serve redis6380.conf`
    1. 登录主redis `redis-cli` 设置值 `set port 6379`
    1. 登录从redis `redis-cli -p 6380` 设置值 `set port 6380`
    1. 将6380设置为从库，登录后cli输入命令 `slaveof 127.0.0.1 6379`
    1. 获取相同key的值，查看是否已经成功 `get port`,如果都为6379则配置生效
2. sentinel 高可用
    1. 首先配置主从库
    1. 启动sentinel1 `redis-sentinel sentinel0.conf`
    1. 启动sentinel2 `redis-sentinel sentinel1.conf`
    1. 停止主redis，观察从数据库升级为主 `kill -9 {redis-master}`
#### 6.（必做）搭建 ActiveMQ 服务，基于 JMS，写代码分别实现对于 queue 和 topic 的消息生产和消费

   
