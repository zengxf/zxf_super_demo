package cn.zxf.conditional_configuration.test.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import cn.zxf.conditional_configuration.test.conditional.WindowsCondition;
import lombok.Data;

@Data
@Component
@Conditional( WindowsCondition.class )
public class WindowsService implements IService {

    private String name = "Windows 10";

}
