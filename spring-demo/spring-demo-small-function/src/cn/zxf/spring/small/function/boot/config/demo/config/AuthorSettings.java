package cn.zxf.spring.small.function.boot.config.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties( prefix = "author" ) // 1
public class AuthorSettings {
    private String name;
    private Long   age;

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public Long getAge() {
	return age;
    }

    public void setAge( Long age ) {
	this.age = age;
    }
}