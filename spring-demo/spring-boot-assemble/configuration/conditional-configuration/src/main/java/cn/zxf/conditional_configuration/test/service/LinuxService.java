package cn.zxf.conditional_configuration.test.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import cn.zxf.conditional_configuration.test.conditional.LinuxCondition;
import lombok.Data;

@Data
@Component
@Conditional( LinuxCondition.class )
public class LinuxService implements IService {

    private String name = "CentOS 7";

}
