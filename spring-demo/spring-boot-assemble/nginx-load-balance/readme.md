# 测试 nginx 的负载均衡

## nginx 配置
```
# http://localhost:8565/work/hello
upstream work {
	server localhost:9081 weight=100;
	server localhost:9082 weight=80;
}
server {
	listen	8565;
	location /work {
		proxy_pass http://work;
	}
}
```