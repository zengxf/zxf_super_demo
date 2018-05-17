package cn.zxf.oauth2.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

    @GetMapping( "/product/{id}" )
    public String getProduct( @PathVariable String id ) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        log.info( "authentication: {}", authentication );
        return "product id : " + id;
    }

    @GetMapping( "/order/{id}" )
    public String getOrder( @PathVariable String id ) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        log.info( "authentication: {}", authentication );
        return "order id : " + id;
    }

}
