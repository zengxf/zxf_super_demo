package cn.zxf.spring.small.function.task_executor.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async // 1
    public void executeAsyncTask( Integer i ) {
        System.out.println( "执行异步任务: " + i );
        sleep( 500 );
    }

    @Async
    public void executeAsyncTaskPlus( Integer i ) {
        System.out.println( "执行异步任务+1: " + ( i + 1 ) );
        sleep( 500 );
    }

    @Async
    public CompletableFuture<UserVo> getUser( int i ) {
        UserVo u = new UserVo( "test u - " + i );
        sleep( 2000 );
        return CompletableFuture.completedFuture( u );
    }

    @Async
    public Future<UserVo> getUserNull( int i ) {
        sleep( 2000 );
        return CompletableFuture.completedFuture( null );
    }

    static void sleep( long millis ) {
        try {
            Thread.sleep( millis );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}
