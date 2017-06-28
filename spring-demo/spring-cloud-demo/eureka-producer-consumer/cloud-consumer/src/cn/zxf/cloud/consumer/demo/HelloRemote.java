package cn.zxf.cloud.consumer.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zxf.cloud.entity.UserDto;
import cn.zxf.cloud.simple.SimpleDto;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient( name = "zxf-cloud-producer" )
public interface HelloRemote {

    @RequestMapping( value = "/hello" )
    public String hello( @RequestParam( value = "name" ) String name );

    @GetMapping( "/user-prod" )
    public UserDto user();

    @GetMapping( "/user-prod" )
    public String userStr();

    @GetMapping( "/simple1" )
    public SimpleDto simple1();

}
