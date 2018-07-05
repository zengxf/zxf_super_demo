# 测试 cache

## starter
- spring-boot-starter-cache

## 常用注解
- @CachePut
- @Cacheable
- @CacheEvict
- @Caching
- 根据结果排除用：`unless="#result.xx"`

## @CachePut
- 需要返回实体，才会缓存

## @Caching
- 组合多个注解策略

## 设置过时
- 配置 `RedisCacheManager`

## 注
### 忽略字段
```
// 只有 getXX() 方法，而无真实字段时，也要忽略。
@JsonIgnore // com.fasterxml.jackson.annotation.JsonIgnore
```