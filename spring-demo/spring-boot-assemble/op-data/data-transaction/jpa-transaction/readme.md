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
- 拥有多个可以回滚的保存点，实际是创建保存点
- 内部事务的回滚不会对外部事务造成影响。它只对 `DataSourceTransactionManager` 事务管理器起效
- JTA 创建保存点时出错，所以直接不执行子方法
- http://localhost:9080/user/createTransactionalNested/zxf-71/ok
- http://localhost:9080/user/createTransactionalNested/zxf-72/err
- http://localhost:9080/user-log/createTransactionalNested/ok
- http://localhost:9080/user-log/createTransactionalNested/err

### 注
- 上面的测试要在**有异常处理块**才有意义
- data-jpa -> JpaTransactionManager
- jdbc -> DataSourceTransactionManager

### Nested 与 RequiresNew 的区别
- RequiresNew 是新事务，不会相互影响
- Nested 则是外部事务的子事务, 如果外部事务 commit, 潜套事务也会被 commit, 这个规则同样适用于 roll back
- - 只有外部事务结束后它才会被提交；本质是一个 savepoint
- - JTA 不支持，创建保存点时出错，所以不会执行子方法

## 直接 JDBC 事务操作
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
						$child.doBegin() // 初始化连接并设置到 ThreadLocal 中
				commitTransactionAfterReturning(TransactionInfo txInfo) // commit
				completeTransactionAfterThrowing(TransactionInfo txInfo, Throwable ex) // rollback
```

## 事务挂起
- 只是资源解绑，当前事务提交或回滚后，再恢复之前挂起的事务

## 事务超时测试
- [jdbc-transaction] -> TestUserService.test_createTransactionalRequiredTimeout()

## Spring 操作数据库处理事务源码
### 设置事务主要源码
```
AbstractPlatformTransactionManager.getTransaction(TransactionDefinition definition)
	$child.doGetTransaction()
```
### Spring JDBC 事务
```
// 内部会去调用当前线程绑定的连接
JdbcTemplate.execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action)
	DataSourceUtils.getConnection(DataSource dataSource)
		doGetConnection(DataSource dataSource) 
			TransactionSynchronizationManager.getResource(Object key) // 以 dataSource 为
				doGetResource(key)
					resources.get() -> 即：ThreadLocal.get()
```
### Spring JPA 事务
```
$Proxy[n] // JDK 动态代理
	SimpleJpaRepository.save(S entity)
		SharedEntityManagerInvocationHandler.invoke(Object proxy, Method method, Object[] args) // 由 SharedEntityManagerCreator 设置
			// 调用 Hibernate 库
			AbstractEntityManagerImpl.persist(Object entity) // jpa.spi 包
				EntityManagerImpl.internalGetSession()
				-> session
				SessionImpl.persist(Object object) // hibernate.session 操作
					firePersist(PersistEvent event) 
						DefaultPersistEventListener.onPersist(PersistEvent event)
							entityIsTransient(PersistEvent event, Map createCache)
								AbstractSaveEventListener.saveWithGeneratedId(xx)
									performSave(xx)
										performSaveOrReplicate(xx)
											addInsertAction(xx) // 这一步开始执行真正的操作
												ActionQueue.addAction(EntityIdentityInsertAction action)
													addInsertAction(AbstractEntityInsertAction insert)
														addResolvedEntityInsertAction(AbstractEntityInsertAction insert)
															execute(E executable) 
																EntityIdentityInsertAction.execute() 
																	SingleTableEntityPersister.insert(Object[] fields, Object object, SessionImplementor session)
																		insert(Object[] , boolean[] , String , Object , SessionImplementor )
																			AbstractReturningDelegate.performInsert(xx)
																				GetGeneratedKeysDelegate.prepare(String insertSQL, SessionImplementor session) 
																					StatementPreparerImpl.prepareStatement(String sql, final int autoGeneratedKeys)
																						connection() // 获取连接
																				-> insert
																				executeAndExtract(PreparedStatement insert, SessionImplementor session)
																					ResultSetReturnImpl.executeUpdate(PreparedStatement statement) // 真正的执行
```

## 异常
- 在事务中如果产生 checked exceptions，默认数据库操作还是要 commit 的；
- 产生的如果是 unchecked exceptions（RuntimeException 及其子类），数据库操作将 rollback