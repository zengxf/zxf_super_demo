# JPA-事务测试

## 基础
- 默认会自动配置 JDBC-`DataSourceTransactionManager` 
- - 或 JPA-`JpaTransactionManager` 
- - 或 Hibernate-`HibernateTransactionManager`

## URL

### 无事务
- http://localhost:9080/user/createNonTransaction/zxf-01
- http://localhost:9080/user-log/createNonTransaction

### 事务-Required
- 支持当前事务，如果当前没有事务，就新建一个事务。def
- http://localhost:9080/user/createTransactionalRequired/zxf-11/ok
- http://localhost:9080/user/createTransactionalRequired/zxf-12/err
- http://localhost:9080/user-log/createTransactionalRequired/ok
- http://localhost:9080/user-log/createTransactionalRequired/err

### 事务-Supports
- 支持当前事务，如果当前没有事务，就以非事务方式执行
- http://localhost:9080/user/createTransactionalSupports/zxf-21/ok
- http://localhost:9080/user/createTransactionalSupports/zxf-22/err
- http://localhost:9080/user-log/createTransactionalSupports/ok
- http://localhost:9080/user-log/createTransactionalSupports/err

### 事务-Mandatory
- 支持当前事务，如果当前没有事务，就抛出异常
- http://localhost:9080/user/createTransactionalMandatory/zxf-31/ok
- http://localhost:9080/user/createTransactionalMandatory/zxf-32/err
- http://localhost:9080/user-log/createTransactionalMandatory/ok
- http://localhost:9080/user-log/createTransactionalMandatory/err

### 事务-RequiresNew
- 新建事务，如果当前存在事务，把当前事务挂起
- http://localhost:9080/user/createTransactionalRequiresNew/zxf-41/ok
- http://localhost:9080/user/createTransactionalRequiresNew/zxf-42/err
- http://localhost:9080/user-log/createTransactionalRequiresNew/ok
- http://localhost:9080/user-log/createTransactionalRequiresNew/err

### 事务-NotSupported
- 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
- http://localhost:9080/user/createTransactionalNotSupported/zxf-51/ok
- http://localhost:9080/user/createTransactionalNotSupported/zxf-52/err
- http://localhost:9080/user-log/createTransactionalNotSupported/ok
- http://localhost:9080/user-log/createTransactionalNotSupported/err

### 事务-Never
- 以非事务方式执行，如果当前存在事务，则抛出异常
- http://localhost:9080/user/createTransactionalNever/zxf-61/ok
- http://localhost:9080/user/createTransactionalNever/zxf-62/err
- http://localhost:9080/user-log/createTransactionalNever/ok
- http://localhost:9080/user-log/createTransactionalNever/err

### 事务-Nested
- 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，就新建一个事务
- 拥有多个可以回滚的保存点
- 内部事务的回滚不会对外部事务造成影响。它只对 `DataSourceTransactionManager` 事务管理器起效
- http://localhost:9080/user/createTransactionalNested/zxf-71/ok
- http://localhost:9080/user/createTransactionalNested/zxf-72/err
- http://localhost:9080/user-log/createTransactionalNested/ok
- http://localhost:9080/user-log/createTransactionalNested/err
