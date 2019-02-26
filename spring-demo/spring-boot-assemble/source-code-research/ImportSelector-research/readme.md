# 研究 ImportSelector 作用
- [原文参考](https://elim.iteye.com/blog/2428994)

## ImportSelector 作用
- 配合 `@Import`，引入自定义实现类 
- 方法 `selectImports()` 指定需要注册为 bean 的类全名

### 类似的 ImportBeanDefinitionRegistrar
- 方法 `registerBeanDefinitions()` 直接注册