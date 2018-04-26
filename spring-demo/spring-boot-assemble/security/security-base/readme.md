# Spring Security 基础

## URL
- http://localhost:9080/api/user/one


## 用户
### 获取当前用户
- `SecurityContextHolder.getContext().getAuthentication().getPrincipal()`

### 配置用户
- 默认用户：name = user, password = UUID
- 配置属性：1.5 `security.user.name|password`，2.0 `spring.security.user.name|password`


## 类
### Authentication
- `getAuthorities()` 权限信息列表
- `getCredentials()` 密码信息
- `getDetails()` 细节信息
- `getPrincipal()` 身份信息
- 通常情况下是 `UsernamePasswordAuthenticationToken` 实现类

### AuthenticationManager
- 身份管理器负责验证 Authentication

### AuthenticationProvider
- 只需要通过一个其认证，即可被认为是登录成功

#### AbstractUserDetailsAuthenticationProvider
- `UserCache` 用户缓存

#### DaoAuthenticationProvider
- 数据层
- `PasswordEncoder` 密码编码器
- `UserDetailsService` 查找用户服务类

### ProviderManager
- 依照次序去认证，认证成功则立即返回，
- 若认证失败则返回null，下一个AuthenticationProvider会继续尝试认证，
- 如果所有认证器都无法认证成功，则 ProviderManager 会抛出异常。

### SecurityContextHolder
- 存储安全上下文
- 默认使用 ThreadLocal 策略存储
