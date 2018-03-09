package cn.test.api.test.proxy;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.test.api.ISay;

@Component
public class ISayProxy implements ISay {

    @Reference( version = "1.0.0", check = false, retries = 0, timeout = 3000 )
    private ISay say;

    @Override
    public void say( String msg ) {
        say.say( msg );
    }

}
