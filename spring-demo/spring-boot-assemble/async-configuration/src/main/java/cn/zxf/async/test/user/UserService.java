package cn.zxf.async.test.user;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService {

    @Async
    public void testAsync() {
        log.info( "test-async-thread: {}", Thread.currentThread()
                .getName() );
    }

    @Async
    public void testAsyncError() {
        log.info( "test-async-error-thread: {}", Thread.currentThread()
                .getName() );
        throw new RuntimeException( "test-error-0010" );
    }

    public void testSync() {
        log.info( "test-sync-thread: {}", Thread.currentThread()
                .getName() );
    }

}
