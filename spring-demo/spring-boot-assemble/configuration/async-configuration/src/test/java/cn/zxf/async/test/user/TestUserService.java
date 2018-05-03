package cn.zxf.async.test.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith( SpringRunner.class )
public class TestUserService {

    @Autowired
    private UserService service;

    @Test
    public void testAsync() {
        service.testAsync();
    }

    @Test
    public void testAsyncError() {
        service.testAsyncError();
    }

    @Test
    public void testSync() {
        service.testSync();
    }

}
