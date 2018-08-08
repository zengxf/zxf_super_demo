# 简单 web 项目
- 研究 DispatcherServlet、Filter、Interceptor 等

## 测试 URL
- http://localhost:9080
- http://localhost:9080/users/get-one
- http://localhost:9080/positions/get-one
- http://localhost:9080/position-servlet

## 项目路径
- `zxf_super_demo\spring-demo\spring-boot-assemble\simple-web`

## 单例
- 默认都是单例

## Servlet
- @WebServlet 注解无效，要配合 @ServletComponentScan
- 要使用 ServletRegistrationBean 设置
- 一般继承 HttpServlet
- super.doGet( req, res ); // 直接调用父类，会返回 405 错误
- loadOnStartup >=0 设置容器启动时就加载 servlet，否则要第一次请求时才加载，即调用 init()

### DispatcherServlet
- 默认监听 "/" 路径
- init() 方法初始化 HandlerMappings

#### 初始化时的调用栈
```
Servlet.init(ServletConfig config)
	HttpServletBean.init()
		FrameworkServlet.initServletBean()
			initWebApplicationContext()
				DispatcherServlet.onRefresh(ApplicationContext context)
					initStrategies(ApplicationContext context)
						initHandlerMappings(ApplicationContext context) 
```

## Filter
- 使用 @WebFilter 注解无效，要配合 @ServletComponentScan
- 要使用 FilterRegistrationBean 设置
- 没设置 order 的情况，谁在上面谁先调用
- 设置 order 时，谁小谁先调用

## Interceptor
- 可以在配置类里面使用 @Autowired 获取实例
- 然后调用 InterceptorRegistry.addInterceptor(x) 添加到配置

## Filter 与 Interceptor 的比较
- (1) 是由容器提供，(2) 是 Spring MVC 的 DispatcherServlet 内部处理
- (1) 先于 Servlet 执行，所以也先于 (2)

## favicon.ico
- 禁用：`spring.mvc.favicon.enabled=false`
- 自定义：将 `favicon.ico` 放在 `src/main/resources/static` 下。会覆盖禁用