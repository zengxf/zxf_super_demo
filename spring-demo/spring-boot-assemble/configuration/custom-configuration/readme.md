# Spring Boot 配置测试
```
@Configuration
@PropertySource( "classpath:user.properties" ) // properties
@ConfigurationProperties( prefix = "user" ) // properties
@NotEmpty // 验证。JSR-303 & 在 starter-web 下可用。只对 @Configuration 注解的 Bean 有效
@ImportResource( locations = "classpath:user.xml" ) // xml
```

## 随机值配置
```
${random.value} // string
${random.int} 
${random.long}
${random.int(10)} // < 10
${random.int[10,20]} // 10 <= v < 20
```

## Logback 配置
```
	<springProfile name="prod">
		<logger name="cn.zxf.configuration" level="INFO" />
	</springProfile>
```