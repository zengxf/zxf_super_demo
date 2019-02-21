package cn.zxf.spring_research.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( HelloImportSelector.class )
public class HelloConfiguration {

}
