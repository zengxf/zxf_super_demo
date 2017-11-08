package test.api.say;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.api.ISay;
import cn.test.api.test.ClientStart;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = ClientStart.class )
public class TestSayMultiThread {

    @Resource
    private ISay dubboDemoRpc;

    @Test
    public void testSay() {
        int count = 10;
        for ( int j = 0; j < count; j++ ) {
            new Thread( () -> {
                for ( int i = 0; i < count; i++ ) {
                    log.info( "cccc -- test ss -- " + i );
                    dubboDemoRpc.say( "cccc -- test ss -- " + i );
                }
            } ).start();
        }
    }

}
