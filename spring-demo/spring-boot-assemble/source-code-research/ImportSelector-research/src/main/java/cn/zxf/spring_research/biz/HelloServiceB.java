package cn.zxf.spring_research.biz;

public class HelloServiceB implements HelloService {

    @Override
    public void doSomething() {
        System.out.println( "Hello B" );
    }

}
