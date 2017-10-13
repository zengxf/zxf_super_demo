## 分版本打 jar 
命令
```
jar --create --verbose --file C:\Users\Administrator\Desktop\aaa\test.jar
 -C M:\tmp\idea-jdk-9\out\production\j9-jar-v1_8 . 
 --release 9 -C M:\tmp\idea-jdk-9\out\production\j9-jar-v9 .
```
验证
```
java -cp C:\Users\Administrator\Desktop\aaa\test.jar cn.zxf.j9.jar.Main
jar -d --file test.jar
```

## jmod 测试
先打 jar 包
```
jar --create --verbose --file C:\Users\Administrator\Desktop\aaa\jmod.jar
 -C M:\tmp\idea-jdk-9\out\production\j9-jmod-v9 . 
```
创建 jmod 文件
```
jmod create --class-path jmod.jar test.jmod
jmod create --class-path M:\tmp\idea-jdk-9\out\production\j9-jmod-v9 test.1.jmod 
```
验证
```
jmod list test.jmod
jmod describe test.jmod
```

## 创建可运行文件
命令
```
jlink --module-path .;%java9%/jmods --add-modules cn.zxf.j9.jmod --output build
jlink --module-path .;%java9%/jmods --add-modules cn.zxf.j9.jmod 
 --launcher test=cn.zxf.j9.jmod/cn.zxf.j9.jmod.test.Main 
 --output build
```
验证
```
cd build/bin
java --list-modules
test
java --module cn.zxf.j9.jmod/cn.zxf.j9.jmod.test.Main
```
### 镜像检查
命令
```
jimage info build/lib/modules
jimage verify build/lib/modules
jimage list build/lib/modules | findStr cn.zxf
```

## 反编译 module-info.class
命令
```
javap jar:file:jmod.jar!/module-info.class
javap module-info.class
```

## 导出 doc
在项目根目录下执行
```
javadoc -d C:\Users\Administrator\Desktop\aaa -encoding utf-8 -sourcepath src -subpackages cn
javadoc -d C:\Users\Administrator\Desktop\aaa -encoding utf-8 src\cn\simple\test\new_features\jdk9\jl\*.java
```