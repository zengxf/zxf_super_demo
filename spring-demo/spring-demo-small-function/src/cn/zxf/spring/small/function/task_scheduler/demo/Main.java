package cn.zxf.spring.small.function.task_scheduler.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main( String[] args ) throws InterruptedException {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( TaskSchedulerConfig.class );
	Thread.sleep( 10_000L );
	context.close();
    }

}
