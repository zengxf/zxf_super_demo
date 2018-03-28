package cn.zxf.spring_aop.spring_dump_test;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
    public void add() {
        System.out.println( "entry DemoMethodService.add() ..." );
    }
}
