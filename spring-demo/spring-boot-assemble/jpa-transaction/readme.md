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
- 都回滚，是因为都抛出了异常
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
- 都回滚，是因为都抛出了异常
- 拥有多个可以回滚的保存点
- 内部事务的回滚不会对外部事务造成影响。它只对 `DataSourceTransactionManager` 事务管理器起效
- http://localhost:9080/user/createTransactionalNested/zxf-71/ok
- http://localhost:9080/user/createTransactionalNested/zxf-72/err
- http://localhost:9080/user-log/createTransactionalNested/ok
- http://localhost:9080/user-log/createTransactionalNested/err

## JDBC 事务操作
```
conn.setAutoCommit( false ); // 要设置为 false
conn.rollback();
conn.commit();
// 保存点
Savepoint spUserLog = conn.setSavepoint( "user-log-test" ); // 定义新的保存点
conn.releaseSavepoint( spUserLog ); // 删除保存点。MySql 并没有实现
conn.rollback( spUserLog ); // 回滚到指定的保存点。回滚之后所有的
```

## 调用栈
```
// 参考：https://www.ibm.com/developerworks/cn/java/j-master-spring-transactional-use/index.html
生成的Proxy类的具体方法调用（如：MyService$$EnhancerBySpringCGLIB$$<ID>.class）
	CglibAopProxy$DynamicAdvisedIntercepter.intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) 
		TransactionInterceptor.invoke(final MethodInvocation invocation) 
			invokeWithinTransaction(Method method, Class<?> targetClass, final InvocationCallback invocation)
				determineTransactionManager(TransactionAttribute txAttr) // #return TransactionManager
				createTransactionIfNecessary(PlatformTransactionManager tm, TransactionAttribute txAttr, final String joinpointIdentification) // #return 状态 
					PlatformTransactionManager.getTransaction(TransactionDefinition definition) // #return 事务状态
				commitTransactionAfterReturning(TransactionInfo txInfo) // commit
				completeTransactionAfterThrowing(TransactionInfo txInfo, Throwable ex) // rollback
```

## 事务挂起
- 只是资源解绑，当前事务提交或回滚后，再恢复之前挂起的事务