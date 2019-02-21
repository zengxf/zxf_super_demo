package cn.zxf.spring_research.biz;

public class HelloServiceA implements HelloService {

    @Override
    public void doSomething() {
        System.out.println( "Hello A" );
    }

}
