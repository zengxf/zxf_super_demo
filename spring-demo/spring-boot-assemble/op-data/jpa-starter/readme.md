# data-jpa-starter demo
- 数据库 MySQL

## spring.jpa.hibernate.ddl-auto
- `validate` 加载 Hibernate 时，验证数据库表结构
- `create` 每次加载  Hibernate，重新创建数据库表结构，这就是导致数据库表数据丢失的原因
- `create-drop` 加载 Hibernate 时创建，退出是删除表结构
- `update` 加载 Hibernate 自动更新数据库结构

## @MappedSuperclass
- 设置从父类继承字段

## MySQL 时区
- `GMT%2B8` 东八区
- `UTC` 全球标准时间

## 动态 SQL
- `@DynamicInsert`、`@DynamicUpdate` 
  - 要放在子类，注解没有被继承
- 使用时要先 `findById()` 获取新对象，再设置值，然后再保存

## 字段命名
- 自动遵循数据库规范 `xx_yy`，不用自己通过 `name` 设置

## 实体类
- 可直接使用 lombok 的 `@Accessors(fluent = true)`
- 字段不需要 get/set 方法

## 直接 JPA 查询限制返回列
- native 直接返回对应数组，用实体类映射时，要返回所有列
- JPA 查实体类要用对应的构造器

## JPA @Query 更改、删除
- 要指定  `@Modifying` 和 `@Transactional`
- 参数是对象，可以用 SpEL 表达式