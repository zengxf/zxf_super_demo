# Spring Boot 异步配置
- 默认用：`SimpleAsyncTaskExecutor`
- 自定义：实现 `AsyncConfigurer` 接口
- 启用 `@EnableAsync`，使用 `@Async`

## Web 异步
- 返回 `WebAsyncTask`
- 客户端还是在等待
- 配置：`extends WebMvcConfigurationSupport` 
- - 重写 `configureAsyncSupport( )`

### RUL
- http://localhost:9080/api/user/async