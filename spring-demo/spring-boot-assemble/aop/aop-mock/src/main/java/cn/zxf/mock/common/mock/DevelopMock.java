package cn.zxf.mock.common.mock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开发时模拟生成对象的 aop 注解
 * 
 * <p>
 * Created by zengxf on 2018-01-24
 */
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface DevelopMock {

    int collectionSize() default 2;

}
