package cn.zxf.conditional_configuration.test.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition, ConfigConstant {

    @Override
    public boolean matches( ConditionContext context, AnnotatedTypeMetadata metadata ) {
        long cur = CUR_TIME;
        return cur % 2 == 0;
    }

}
