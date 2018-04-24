# Spring Session 共享

## 测试 URL
- http://localhost:9080/users/login
- http://localhost:9081/users/show
- XX
- http://localhost:9081/users/login
- http://localhost:9080/users/show

## 设置不同子域名下 cookie 共享
- 配置 `CookieSerializer`，设置 `DefaultCookieSerializer`

## 获取同一用户名的所有 session
- 使用 `FindByIndexNameSessionRepository`，参数是用户名