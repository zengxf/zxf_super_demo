package cn.zxf.agent.test;

/**
 * <pre>
 * java
 * -javaagent:M:\project\zxf_super_demo\small-frame\jdk-demo\instrument-demo\my-agent-02\build\libs\my-agent-02.jar=hello
 * cn.zxf.agent.test.AgentTestMain
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2018-02-06
 */
public class AgentTestMain {

    public static void main( String[] args ) {
        System.out.println( new Dog().hello() );
    }

}
