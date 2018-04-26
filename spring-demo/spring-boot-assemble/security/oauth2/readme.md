# OAuth2.0 demo
- 获取 token
```
// POST，设置 secret 的，则不管什么模式都要 client_secret
- password模式：
http://localhost:8080/oauth/token?scope=select&client_id=client_2&client_secret=123456&grant_type=password&username=user_1&password=123456
- client模式：
http://localhost:8080/oauth/token?scope=select&client_id=client_1&client_secret=123456&grant_type=client_credentials
```
- 刷新 token
```
// POST
http://localhost:8080/oauth/token?grant_type=refresh_token&client_id=client_2&client_secret=123456&refresh_token=2d1bfe3e-5968-4a35-8d47-c7b6c8d83293
```
- 授权码模式：
```
浏览器：
http://localhost:8080/oauth/authorize?response_type=code&client_id=client_3&redirect_uri=http://baidu.com
1) 登录
2) 选择 Approve
3) 跳转，记住 code。code 是一次性的
4) 获取 token
// POST
http://localhost:8080/oauth/token?grant_type=authorization_code&code=D1VpWo&client_id=client_3&client_secret=123456&redirect_uri=http://baidu.com
```
- 简单模式：
```
// 直接浏览器就行了
http://localhost:8080/oauth/authorize?response_type=token&client_id=client_4&redirect_uri=http://baidu.com
```
- 检验 token
```
// 需要 client_id 和 client_secret
http://localhost:8080/oauth/check_token?token=3d4ea191-e724-4378-a73d-8f34d39e7404
```