package cn.zxf.cloud.consumer.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient( name = "zxf-cloud-producer", fallback = HelloRemoteHystrix.class )
public interface HelloRemote {

    @RequestMapping( value = "/hello" )
    public String hello( @RequestParam( value = "name" ) String name );

    /**
     * 用默认方法实现，不会调用远程的
     * 
     * @param name
     * @return
     */
    @Deprecated
    @RequestMapping( value = "/hello" )
    public default String hello_j8( @RequestParam( value = "name" ) String name ) {
	return "fuck - " + name;
    }

}
