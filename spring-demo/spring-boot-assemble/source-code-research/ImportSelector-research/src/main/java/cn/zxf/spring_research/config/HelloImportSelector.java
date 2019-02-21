package cn.zxf.spring_research.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import cn.zxf.spring_research.biz.HelloServiceA;
import cn.zxf.spring_research.biz.HelloServiceB;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloImportSelector implements ImportSelector {

    @Override
    public String[] selectImports( AnnotationMetadata importingClassMetadata ) {
        log.info( "==> {}", importingClassMetadata.getAnnotationTypes() );
        log.info( "==> {}", importingClassMetadata.getAnnotationAttributes( Import.class.getName() ) );
        return new String[] { HelloServiceA.class.getName(), HelloServiceB.class.getName() };
    }

}