package cn.zxf.spring.boot.data.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cn.zxf.spring.boot.data.jpa.demo.dao.PersonRepository;
import cn.zxf.spring.boot.data.jpa.demo.support.CustomRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories( repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class )
@PropertySource( "classpath:/cn/zxf/spring/boot/data/jpa/demo/resources/application.properties" )
public class Ch82Application {

    @Autowired
    PersonRepository personRepository;

    public static void main( String[] args ) {
        SpringApplication.run( Ch82Application.class, args );

    }

}
