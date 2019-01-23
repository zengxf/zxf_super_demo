package cn.simple.test.jvm;

import sun.jvm.hotspot.oops.InstanceKlass;
import sun.jvm.hotspot.tools.jcore.ClassFilter;

/**
 * dump class。需要 sa-jdi.jar
 * 
 * <pre>
 * java -cp "%JAVA_HOME%/lib/sa-jdi.jar" 
 * -Dsun.jvm.hotspot.tools.jcore.filter=MyClassFilter 
 * sun.jvm.hotspot.tools.jcore.ClassDump 8080
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2017-08-28
 */
public class MyClassFilter implements ClassFilter {

    @Override
    public boolean canInclude( InstanceKlass clazz ) {
        String name = clazz.getName().asString();
        return name.endsWith( "TelnetTest" );
    }

}
