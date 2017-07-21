# OAuth2 示例

## OAuth2 测试
简单测试：
	 http://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=acme&redirect_uri=http://example.com 
命令行：
```
curl acme:acmesecret@localhost:9999/uaa/oauth/token  \
-d grant_type=authorization_code -d client_id=acme   \
-d redirect_uri=http://example.com -d code=<code>
```

## Resource 测试
curl -v 127.0.0.1:9000

## 最终测试
获取 code：
```
http://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=acme&redirect_uri=http://127.0.0.1:9000
```
获取 token（将上面的 code 替换）：
```
curl acme:acmesecret@localhost:9999/uaa/oauth/token  \
-d grant_type=authorization_code -d client_id=acme   \
-d redirect_uri=http://127.0.0.1:9000 -d code=Hek5p8
```
测试访问（将上面的 code 替换）：
```
TOKEN="ac0f26bc-3657-487f-8764-8df7b08ffc6a"
curl -H "Authorization: Bearer $TOKEN" 127.0.0.1:9000			# 并不成功
curl -H "Authorization: Bearer $TOKEN" localhost:9999/uaa/user
```