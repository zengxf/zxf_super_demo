package cn.zxf.web.test.common;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MyConfiguration {

    // @Bean
    public MessageSource mySource() {
        ReloadableResourceBundleMessageSource src = new ReloadableResourceBundleMessageSource();
        src.getBasenameSet()
                .add( "classpath:messages" ); // 消息确实是这样子设置
        src.setCacheSeconds( 10 );
        src.setDefaultEncoding( "UTF-8" );

        String message = src.getMessage( "verify-status-is-null", null, null );
        System.out.println( "verify-status-is-null: " + message );

        return src;
    }

    // 可不用重写这个，只要将文件命名为 `messages.properties` 即可
    // @Bean
    public LocalValidatorFactoryBean validator( MessageSource messageSource ) {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource( messageSource );
        return validator;
    }

}
