# 测试 nginx 的负载均衡

## nginx 负载均衡配置

### LB 权重配置
```
# http://localhost:8565/work/hello
upstream work {
	server localhost:9081 weight=100;
	server localhost:9082 weight=10;
}
```
### LB 备份配置
```
# http://localhost:8565/work/hello
upstream work {
	server localhost:9081;
	server localhost:9082 backup; # 其它所有非backup机器down或者忙的时候，请求backup机器，压力最轻
}
```
### 代理配置
```
server {
	listen	8565;
	location /work {
		proxy_pass http://work;
       proxy_connect_timeout 1s;
	}
}
```