package cn.simple.test.new_features.jdk16.apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �����Զ�����log��Ա����.��������class��enum,�������ڽӿ�.
 */
@Retention( RetentionPolicy.SOURCE )
@Target( ElementType.TYPE )
public @interface MySlf4j {
    /**
     * ϵͳ����.���Ϊ����ȡ"-Dvlogging.system"ϵͳ����,���ϵͳ����ҲΪ��,��ȡ"Unknown".
     */
    String system() default "";

    /**
     * ģ������.���Ϊ����ȡ"-Dvlogging.module"ϵͳ����,���ϵͳ����ҲΪ��,��ȡ"Unknown".
     */
    String module() default "";
}