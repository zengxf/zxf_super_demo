# 测试异常处理

## 测试
- [测试服务异常](http://localhost:9080/api/error-test/find-one)
- [测试认证异常](http://localhost:9080/api/error-test/test-auth-error?userId=x)
- [测试表单异常](curl -X POST -H "Content-Type: application/json"  -d '{"name": "zz"}' http://localhost:9080/api/error-test/test-create)

## 结论
- 返回 `code=400` 没用，只能前端判断
- `@RestControllerAdvice` 是 `@ControllerAdvice`、`@ResponseBody` 的组合
- 不好跟踪源码时，直接将日志级别设为 `debug`

## 参数校验
- `@Valid` # 可设置方法和类，只能是 `Controller` 类。
- `@NotEmpty` # 可指定到字段和参数上。
- 需要依赖 `hibernate-validator` 包。
- 处理异常：`MethodArgumentNotValidException`。

### 自定义消息
- 可不设置 `LocalValidatorFactoryBean`，
- 只要将文件命名为 `messages.properties` 即可。
