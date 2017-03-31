package cn.zxf.spring.small.function.task_executor.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async // 1
    public void executeAsyncTask( Integer i ) {
	System.out.println( "执行异步任务: " + i );
    }

    @Async
    public void executeAsyncTaskPlus( Integer i ) {
	System.out.println( "执行异步任务+1: " + ( i + 1 ) );
    }

}