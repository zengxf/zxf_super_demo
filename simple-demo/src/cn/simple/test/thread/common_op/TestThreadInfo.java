package cn.simple.test.thread.common_op;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import cn.simple.util.SleepUtils;

/**
 * 查看所有线程相差信息
 * 
 * <p>
 * Created by zengxf on 2018-02-23
 */
public class TestThreadInfo {

    static Object lock = new Object();

    public static void main( String[] args ) {
        Runnable r = () -> {
            synchronized ( lock ) {
                SleepUtils.second( 1 );
                try {
                    System.out.println( "--------------- wait ------------" );
                    lock.wait();
                } catch ( InterruptedException e ) {
                }
            }
        };
        Thread t = new Thread( r, "test-01" );
        t.start();

        printInfo();
        SleepUtils.second( 2 );
        System.out.println( "========================" );
        printInfo();
        SleepUtils.second( 2 );
        System.out.println( "========================" );
        printInfo();
    }

    static void printInfo() {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads( false, false );
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for ( ThreadInfo threadInfo : threadInfos ) {
            System.out.println( "[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName() + "\t" + threadInfo.getThreadState() );
        }
    }

}
