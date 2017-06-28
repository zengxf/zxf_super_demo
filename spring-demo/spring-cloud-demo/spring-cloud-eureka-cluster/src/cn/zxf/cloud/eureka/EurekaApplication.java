package cn.zxf.cloud.eureka;

@Deprecated // 不能这样启动三个，会出错！！！
public class EurekaApplication {

    public static void main( String[] args ) {
	new Thread( () -> EurekaPeer1Application.main( args ) ).start();
	new Thread( () -> EurekaPeer2Application.main( args ) ).start();
	new Thread( () -> EurekaPeer3Application.main( args ) ).start();
    }

}
