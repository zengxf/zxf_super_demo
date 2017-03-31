package cn.simple.test.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳�
 * 
 * @author zengxf
 */
public class ThreadPool {

    // ���ڶ�ʱ�õ�
    private static ScheduledExecutorService taskPool	= Executors.newScheduledThreadPool( 1 );
    // ���������õģ����������ӳٵĲ���
    private static ExecutorService	    commandPool	= Executors.newFixedThreadPool( 20 );

    /**
     * ���ӳ����Է���Ϊ��λ
     */
    public static void scheduledMinute( Runnable task, long minutes ) {
	scheduled0Delay( task, minutes, TimeUnit.MINUTES );
    }

    /**
     * ���ӳ�
     */
    public static void scheduled0Delay( Runnable task, long period, TimeUnit unit ) {
	scheduled( task, 0L, period, unit );
    }

    public static void scheduled( Runnable task, long initialDelay, long period, TimeUnit unit ) {
	Runnable tryTask = () -> {
	    try {
		task.run();
	    } catch ( Exception e ) {
		System.out.println( "������δ������쳣��" + e );
	    }
	};
	taskPool.scheduleAtFixedRate( tryTask, initialDelay, period, unit );
    }

    public static void execute( Runnable command ) {
	Runnable tryCommand = () -> {
	    try {
		command.run();
	    } catch ( Exception e ) {
		System.out.println( "������δ������쳣��" + e );
	    }
	};
	commandPool.execute( tryCommand );
    }

}
