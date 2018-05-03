package cn.zxf.custom_configuration.test.config.prefile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Configuration
public class PrefileDevConfig {

    public interface IConfig {
        String getName();
    }

    @Component
    @Profile( "default" )
    @Data
    public static class DefConfig implements IConfig {
        private String name = "def";
    }

    @Component
    @Profile( { "dev", "test" } )
    @Data
    public static class DevConfig implements IConfig {
        private String name = "dev|test";
    }

}
