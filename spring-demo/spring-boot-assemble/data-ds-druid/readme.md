# 连接池 Druid 测试

## URL

### Druid 监控 UI
- http://localhost:9080/druid/login.html

### 插入
- http://localhost:9080/user/createNonTransaction/zxf-01
- http://localhost:9080/user/createBySql/zxf-11

### 查找
- http://localhost:9080/user/findAll

### 非法 SQL
- http://localhost:9080/user/executeIllegalSql


## 源码

### StatFilter
- 记录慢 SQL 等

### WallFilter
- SQL 防火墙