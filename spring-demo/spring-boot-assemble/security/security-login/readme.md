# Spring Security 基础

## URL
- http://localhost:9080

## 注
- `application.yml` 中配置用户无效

## 权限配置
```
http
	.authorizeRequests()
        .antMatchers( "/resources/**", "/signup", "/about" )
        .permitAll() // 1
        .antMatchers( "/admin/**" )
        .hasRole( "ADMIN" ) // 2
        .antMatchers( "/db/**" )
        .access( "hasRole('ADMIN') and hasRole('DBA')" ) // 3
        .anyRequest()
        .authenticated() // 4
        .and() // A
    .formLogin()
        .usernameParameter( "username" )
        .passwordParameter( "password" )
        .failureForwardUrl( "/login?error" )
        .loginPage( "/login" )
        .permitAll()
        .and() // B
    .logout()
        .logoutUrl( "/logout" )
        .logoutSuccessUrl( "/index" )
        .permitAll()
        .and() // C
    .httpBasic()
    .disable();
    
authorizeRequests() 配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
formLogin() 对应表单认证相关的配置
logout() 对应了注销相关的配置
httpBasic() 可以配置basic登录
```

## HttpServletRequest 新方法
- getRemoteUser()
- getUserPrincipal()
- isUserInRole(java.lang.String)
- login(java.lang.String, java.lang.String)
- logout()

## 主要过滤器
- `SecurityContextPersistenceFilter` 两个主要职责：请求来临时，创建 `SecurityContext` 安全上下文信息，请求结束时清空 `SecurityContextHolder`
- `HeaderWriterFilter` 用来给 HTTP 响应添加一些 Header
- `CsrfFilter` 用于防止 CSRF 攻击
- `LogoutFilter` 处理注销的过滤器
- `UsernamePasswordAuthenticationFilter` 表单认证
- `RequestCacheAwareFilter` 内部维护了一个 `RequestCache`，用于缓存 request 请求
- `SecurityContextHolderAwareRequestFilter` 对 `ServletRequest` 进行了一次包装，使得 request 具有更加丰富的API
- `AnonymousAuthenticationFilter` 匿名身份过滤器
- `SessionManagementFilter` 和 session 相关的过滤器，内部维护了一个 `SessionAuthenticationStrategy`，
- - 常用来防止 session-fixation protection attack，以及限制同一用户开启多个会话的数量
- `ExceptionTranslationFilter` 异常翻译过滤器
- - `AuthenticationEntryPoint` `AccessDeniedHandler`
- `FilterSecurityInterceptor` 权限认证，对用户拥有的权限和资源所需的权限进行判断处理
- - `SecurityMetadataSource` `AccessDecisionManager`
