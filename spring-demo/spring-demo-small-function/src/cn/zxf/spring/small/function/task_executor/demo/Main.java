package cn.zxf.spring.small.function.task_executor.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    static AnnotationConfigApplicationContext context;
    static AsyncTaskService                   asyncTaskService;

    public static void main( String[] args ) {
        context = new AnnotationConfigApplicationContext( TaskExecutorConfig.class );
        asyncTaskService = context.getBean( AsyncTaskService.class );

        // testTask();
        testFuture();

        context.close();
    }

    static void testTask() {
        for ( int i = 0; i < 10; i++ ) {
            asyncTaskService.executeAsyncTask( i );
            asyncTaskService.executeAsyncTaskPlus( i );
        }
        System.out.println( "------- async task return -------" );
    }

    static void testFuture() {
        List<CompletableFuture<UserVo>> list = IntStream.rangeClosed( 1, 10 ) //
                .boxed() //
                .map( asyncTaskService::getUser ) //
                .collect( Collectors.toList() );

        System.out.println( "------- async task return -------" );

        list.forEach( f -> {
            try {
                System.out.println( f.get() );
            } catch ( InterruptedException | ExecutionException e ) {
                e.printStackTrace();
            }
        } );
    }
}
