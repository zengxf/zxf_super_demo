## agent 项目说明
- [参考](https://mp.weixin.qq.com/s?__biz=MzI0NzEyODIyOA==&mid=2247483860&idx=1&sn=5bf9cf25651f537d095bf6866e46f1ac) 
- my-agent-01 简单打印
- my-agent-02 替换类

## 格式说明 
```
-javaagent:jarpath=[options] 
其中的 jarpath 为 agent.jar 的路径，
options 是一个可选参数，其值会被 premain 方法的第一个参数接收 public static void premain(String options, Instrumentation ins).
```

## 打 agent 包
```
gradle build
```

## 使用代理 JVM 参数
### 测试1
```
-javaagent:M:\project\zxf_super_demo\small-frame\jdk-demo\instrument-demo\my-agent-01\build\libs\my-agent-01.jar=hello
```
### 测试2 - 多个
```
-javaagent:M:\project\zxf_super_demo\small-frame\jdk-demo\instrument-demo\my-agent-01\build\libs\my-agent-01.jar=hello
-javaagent:M:\project\zxf_super_demo\small-frame\jdk-demo\instrument-demo\my-agent-01\build\libs\my-agent-01.jar=hello2
```
### 测试3 - 替换类
```
-javaagent:M:\project\zxf_super_demo\small-frame\jdk-demo\instrument-demo\my-agent-02\build\libs\my-agent-02.jar=hello
```

## JAVA6 的 agentmain
- java6 提供了 public static void agentmain (String agentArgs, Instrumentation inst);
- - 这个新的方法，可以在 main 函数之后装配（premain 是在 main 之前），这使得操控现有程序的自由度变得更高

## 失败经验
### 读取 jar 包中的文件，用流不要用 URI
```
// Files.readAllBytes( Paths.get( GreetingTransformer.class.getResource( "/classes/Dog.class.file" ).toURI() ) ); // 读取出错，且不会打印异常
InputStream is = GreetingTransformer.class.getResource( "/classes/Dog.class.file" ).openStream();
byte[] bytearr = new byte[is.available()];
is.read( bytearr );
return bytearr;
```
