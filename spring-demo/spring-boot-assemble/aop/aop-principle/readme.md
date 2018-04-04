# AOP 原理

## 导出类经验

### 导出代理类经验
- CGLIB 导出 `System.setProperty( DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, savePath )`
- JDK 导出：
- - Java8：`System.setProperty( "sun.misc.ProxyGenerator.saveGeneratedFiles", "true" );`
- - Java9：`System.setProperty( "jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true" );`
- - 生成在项目根目录下的 `com\sun\proxy` 文件下

### 导出引用的 class
```
	Path savePath = saveFolder.resolve( clazz.getSimpleName() + ".class" );
	String classPath = "/" + clazz.getName().replace( ".", "/" ) + ".class";
	InputStream is = clazz.getResourceAsStream( classPath );
	Files.copy( is, savePath );
```

## 术语
- **通知（Advice）**
- - 也叫**增强**，加入额外的功能
- - `@Around` `@Before` `@After` `@AfterReturning` `@AfterThrowing`
- - 正常-顺序：`@Around-1` >> `@Before` >> `user-code` >> `@Around-2` >> `@After` >> `@AfterReturning` 
- - 异常-顺序：`@Around-1` >> `@Before` >> `user-code` >> `@After` >> `@AfterThrowing`
- **连接点（JoinPoint）**
- - 使用通知的地方
- - **通知**与**目标方法**之间的连接
- **切入点（Pointcut）**
- - 定出规则，查找连接点
- - `@Pointcut`
- **切面（Aspect）**
- - **通知**和**切入点**的组合
- - `@Aspect` 直接在 Bean 上
- **目标（Target）**
- - 被切入的类
- - `@CustomAnnotation` 自定义的注解
- **代理(Proxy)**
- - 生成的代理类，对目标类进行封装
- **织入（Weaving）**
- - 把切面加入到程序代码的过程
- - 生成代理类
- ~~**引入（Introduction）**~~
- - 在不改变一个现有类代码的情况下，为该类添加属性和方法

## Spring AOP
- [参考](https://www.ibm.com/developerworks/cn/java/j-lo-springaopcglib)
- Spring 允许使用 AspectJ Annotation 用于定义方面（Aspect）、切入点（Pointcut）和增强处理（Advice）
- Spring 只是使用了和 AspectJ 5 一样的注解，但并没有使用 AspectJ 的编译器或者织入器（Weaver）
- 底层依然使用的是 Spring AOP，依然是在运行时动态生成 AOP 代理