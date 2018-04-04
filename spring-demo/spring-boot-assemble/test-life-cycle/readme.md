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

destory被调用
myDestroy被调用
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