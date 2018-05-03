package cn.zxf.async.test.user;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import lombok.Builder;
import lombok.Data;

@RestController
@RequestMapping( "/api/user" )
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping( "async" )
    public WebAsyncTask<UserDto> async() {
        System.out.println( "async 被调用 thread id is : " + Thread.currentThread()
                .getName() );
        Callable<UserDto> callable = new Callable<UserDto>() {
            public UserDto call() throws Exception {
                Thread.sleep( 1000 ); // 模拟长时间任务
                System.out.println( "执行成功 thread id is : " + Thread.currentThread()
                        .getName() );
                return UserDto.builder()
                        .name( "zxf-001" )
                        .build();
            }
        };
        return new WebAsyncTask<>( callable );
    }

    @Data
    @Builder
    static class UserDto {
        String name;
    }

    @GetMapping( "testAsync" )
    public UserDto testAsync() {
        service.testAsync();
        return UserDto.builder()
                .name( "OK-async-001" )
                .build();
    }

    @GetMapping( "testAsyncError" )
    public UserDto testAsyncError() {
        service.testAsyncError();
        return UserDto.builder()
                .name( "Error-001" )
                .build();
    }

    @GetMapping( "testSync" )
    public UserDto testSync() {
        service.testSync();
        return UserDto.builder()
                .name( "OK-sync-001" )
                .build();
    }

}
