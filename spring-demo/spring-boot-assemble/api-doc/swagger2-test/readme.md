# 生成文档测试
- [入口url](http://localhost:9080/swagger-ui.html)
- [参考](http://blog.didispace.com/springbootswagger2)

## /swagger-ui.html 405
```
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        registry.addResourceHandler( "swagger-ui.html" )
                .addResourceLocations( "classpath:/META-INF/resources/" );
        registry.addResourceHandler( "/webjars/**" )
                .addResourceLocations( "classpath:/META-INF/resources/webjars/" );
    }
}
```

## 设置控制器显示名
- `@Api( tags = "职位控制器" )`