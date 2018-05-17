# OAuth2.0 demo

## 密码模式
```
// POST: 获取 token
http://localhost:8080/oauth/token?grant_type=password&scope=select&client_id=client_2&client_secret=123456&username=user_1&password=123456
// GET:  检验 token
http://localhost:8080/oauth/check_token?token=$access_token
// POST: 刷新 token
http://localhost:8080/oauth/token?grant_type=refresh_token&client_id=client_2&client_secret=123456&refresh_token=$refresh_token
```

## 客户端模式
```
// POST: 获取 token
http://localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=123456
// GET:  检验 token
http://localhost:8080/oauth/check_token?token=$access_token
```

## 授权码模式
```
// 浏览器访问：
http://localhost:8080/oauth/authorize?response_type=code&client_id=client_3&redirect_uri=http://www.baidu.com
// 1) 登录
// 2) 选择 Approve
// 3) 跳转，获取地址栏上的 code。code 是一次性的
// POST: 获取 token
http://localhost:8080/oauth/token?grant_type=authorization_code&code=$code&client_id=client_3&client_secret=123456&redirect_uri=http://www.baidu.com
// GET:  检验 token
http://localhost:8080/oauth/check_token?token=$access_token
// POST: 刷新 token
http://localhost:8080/oauth/token?grant_type=refresh_token&client_id=client_3&client_secret=123456&refresh_token=$refresh_token
```

## 简单模式
```
// 直接浏览器访问：
http://localhost:8080/oauth/authorize?response_type=token&client_id=client_4&redirect_uri=http://baidu.com
// 1) 获取地址栏上的 access_token
// GET:  检验 token
http://localhost:8080/oauth/check_token?token=$access_token
```

## 测试
### 检验 token
```
// GET
http://localhost:8080/oauth/check_token?token=$access_token
```
### 测试服务资源访问
```
// GET
http://localhost:8080/product/X001	# 不拦截
http://localhost:8080/order/A001	# 没有 access_token，被拦截
http://localhost:8080/order/A001?access_token=$access_token	# access_token 合法，不拦截
```