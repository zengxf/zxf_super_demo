# data-jpa-starter demo
- 数据库 MySQL

## spring.jpa.hibernate.ddl-auto
- `validate` 加载 Hibernate 时，验证数据库表结构
- `create` 每次加载  Hibernate，重新创建数据库表结构，这就是导致数据库表数据丢失的原因
- `create-drop` 加载 Hibernate 时创建，退出是删除表结构
- `update` 加载 Hibernate 自动更新数据库结构

## @MappedSuperclass
- 设置从父类继承字段

## 时区
- `GMT%2B8` 东八区
- `UTC` 全球标准时间