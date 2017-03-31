package cn.zxf.spring.small.function.aware.demo;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {// 1

    private String	   beanName;
    private ResourceLoader loader;

    @Override
    public void setResourceLoader( ResourceLoader resourceLoader ) {// 2
	this.loader = resourceLoader;
    }

    @Override
    public void setBeanName( String name ) {// 3
	this.beanName = name;
    }

    public void outputResult() {
	System.out.println( "Bean的名称为：" + beanName );

	Resource resource = loader.getResource( "classpath:cn/zxf/spring/small/function/aware/demo/test.txt" );
	try {
	    System.out.println( "loader: " + loader );
	    String content = IOUtils.toString( resource.getInputStream(), Charset.defaultCharset() );
	    System.out.println( "ResourceLoader加载的文件内容为: " + content );
	} catch ( IOException e ) {
	    e.printStackTrace();
	}

    }

}
