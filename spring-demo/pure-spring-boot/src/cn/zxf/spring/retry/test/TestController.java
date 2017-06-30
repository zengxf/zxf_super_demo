package cn.zxf.spring.retry.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/my/retry" )
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping( "/test1" )
    public String test1() throws TestException {
	return service.test1();
    }

    @GetMapping( "/test2" )
    public String test2() throws TestException {
	return service.test2( "" );
    }

}
