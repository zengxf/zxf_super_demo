# 测试生命周期

- **[原文参考](https://www.jianshu.com/p/3944792a5fff)**

## Context
```
开始初始化容器

Person()类构造方法
setName()方法被调用
BeanNameAware.setBeanName()被调用
BeanFactoryAware.setBeanFactory()被调用
ApplicationContextAware.setApplicationContext()被调用
MyBeanPostProcessor.postProcessBeforeInitialization()被调用
InitializingBean.afterPropertiesSet()被调用
myInit()被调用
MyBeanPostProcessor.postProcessAfterInitialization()被调用

xml加载完毕
getBean: Person(name=jack)

关闭容器

destory 被调用
myDestroy 被调用
```
## Bean Factory
```
开始初始化容器

xml加载完毕

Person()类构造方法
setName()方法被调用
BeanNameAware.setBeanName()被调用
BeanFactoryAware.setBeanFactory()被调用
MyBeanPostProcessor.postProcessBeforeInitialization()被调用
InitializingBean.afterPropertiesSet()被调用
myInit()被调用
MyBeanPostProcessor.postProcessAfterInitialization()被调用

getBean: Person(name=jack)

关闭容器

DisposableBean.destory()被调用
myDestroy()被调用
```

## 生命周期
```
-> InstantiationAwareBeanPostProcessor:
		postProcessBeforeInstantiation() ->
		
-> Bean 实例化：
		通知带参或缺省的构造函数创建 Bean 实例  -> 
		
-> InstantiationAwareBeanPostProcessor:
		postProcessAfterInstantiation() -> 
		postProcessPropertyValues() -> 
	
-> 	BeanNameAware:
  		setBeanName() -> 
  		
->	BeanFactoryAware:
		setBeanFactory() -> 
		
->	BeanPostProcessor:
		postProcessBeforeInitialization() -> 
		
-> Bean 初始化：
		调用用户自定义的初始化方法 -> 
		
->	BeanPostProcessor:
		postProcessAfterInitialization() -> 
```
### 延伸
#### Sp 处理注入
```
InstantiationAwareBeanPostProcessor.postProcessPropertyValues()：
	实现 @Autowired 注解。
	把 Bean 依赖的其他对象注入进来。
```
#### Sp 代理
```
BeanPostProcessor.postProcessAfterInitialization()：
	创建对象代理，封装返回。
```