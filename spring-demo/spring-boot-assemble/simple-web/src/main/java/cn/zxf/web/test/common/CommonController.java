package cn.zxf.web.test.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/" )
public class CommonController {

    @GetMapping( "/" )
    public String getUser() {
        System.out.println( "-- CommonController: " + this );
        return "OK-common";
    }

}