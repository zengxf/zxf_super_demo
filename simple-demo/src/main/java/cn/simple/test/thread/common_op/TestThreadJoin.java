package cn.simple.test.thread.common_op;

/**
 * 线程执行完会调用：notifyAll()
 * 
 * @author zengxf
 */
public class TestThreadJoin {
    public static void main( String[] args ) throws InterruptedException {

        System.out.println( "main start" );

        Thread a = new Thread( () -> {
            System.out.println( "a start" );
            try {
                Thread.sleep( 1000L );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            System.out.println( "a end" );
        } );

        Thread b = new Thread( () -> {
            synchronized ( a ) {
                try {
                    System.out.println( "b start" );
                    a.wait();
                    System.out.println( "b end" );
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }
        } );

        a.start();
        b.start();

        a.join();

        System.out.println( "main end" );
    }
}
