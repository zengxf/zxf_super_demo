# BTrace 测试
## [下载](https://github.com/btraceio/btrace)

脚本注意事项: 
1. 只能调用：BTraceUtils.* 的方法

(进入到 *.java 当前目录下)执行：
```
jps
btrace pid XXScript.java
```

btracer 用着不爽 

@OnMethod clazz 属性支持
```
+xx.Class		// 继承或实现
@xx.Annotation	// 有某注解
```