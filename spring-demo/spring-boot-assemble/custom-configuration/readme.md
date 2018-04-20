# Spring Boot 配置测试
```
@Configuration
@PropertySource( "classpath:user.properties" ) // properties
@ConfigurationProperties( prefix = "user" ) // properties
@NotEmpty // 验证。JSR-303 & 在 starter-web 下可用。只对 @Configuration 注解的 Bean 有效
@ImportResource( locations = "classpath:user.xml" ) // xml
```