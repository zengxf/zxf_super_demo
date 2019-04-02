package cn.zxf.jpa_starter.test.initialize;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile( "init" )
@Component
public class InitializeService {

    @Value( "${spring.datasource.data}" )
    private String sqlPath;

    @PostConstruct
    public void init() {
        log.info( "==== init ==== sql-path: {}", sqlPath );
    }

}
