# 源码-初始化-研究

- **[原文参考 IOC](https://yikun.github.io/2015/05/29/Spring-IOC核心源码学习/)**
- **[原文参考 AOP](https://www.cnblogs.com/xrq730/p/6753160.html)**

## 源码关键类
- `ConfigurationClassPostProcessor` 后处理器
  - 在 `AnnotationConfigUtils.registerAnnotationConfigProcessors()` 调用注入
  - 在 `Context` 被反射初始化时调用