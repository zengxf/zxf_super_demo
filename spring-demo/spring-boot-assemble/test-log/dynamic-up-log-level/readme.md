# 动态修改日志级别

## URL
- [测试](http://localhost:9080/api/log/test)
- [查看 log 级别](http://localhost:9080/loggers)
- [设置 log 级别](http://localhost:9080/loggers/cn.zxf)
```
Post：-d { "configuredLevel": "DEBUG" }
curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"configuredLevel": "DEBUG"}' http://localhost:9080/loggers/cn.zxf
```
- [再查看 log 级别](http://localhost:9080/loggers/cn.zxf)