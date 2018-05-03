package cn.zxf.custom_configuration.test.config.prefile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class PrefileConfig {

    @Value( "${zxf.def}" )
    private String defValue;
    @Value( "${zxf.custom}" )
    private String customValue;

}
