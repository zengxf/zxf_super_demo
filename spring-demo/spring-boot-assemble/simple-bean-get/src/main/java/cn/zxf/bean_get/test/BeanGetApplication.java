package cn.zxf.bean_get.test;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class BeanGetApplication implements ApplicationContextAware {

    public static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        CONTEXT = applicationContext;
    }

}
