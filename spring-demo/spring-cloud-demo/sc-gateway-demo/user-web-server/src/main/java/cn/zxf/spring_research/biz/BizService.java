package cn.zxf.spring_research.biz;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BizService {

    @PostConstruct
    public void init() {
        log.info( "== BizService init! ==" );
    }

    public void hello() {
        log.info( "== hello ==" );
    }

}
