# Spring Security 根据 IP 进行登录

## 参数
- https://lexburner.github.io/spring-security-5

## URL
- http://localhost:9080

## 对应关系
- IpAuthenticationProcessingFilter --> UsernamePasswordAuthenticationFilter
- IpAuthenticationToken --> UsernamePasswordAuthenticationToken
- ProviderManager --> ProviderManager
- IpAuthenticationProvider --> DaoAuthenticationProvider
- ConcurrentHashMap --> UserDetailsService
