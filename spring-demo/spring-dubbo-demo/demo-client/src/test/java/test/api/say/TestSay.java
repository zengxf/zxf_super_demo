package test.api.say;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.test.api.ISay;
import cn.test.api.test.ClientStart;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = ClientStart.class )
public class TestSay {

    @Resource
    private ISay dubboDemoRpc;

    @Test
    public void testSay() {
        int count = 1;
        for ( int i = 0; i < count; i++ ) {
            dubboDemoRpc.say( "cccc -- test ss -- " + i );
        }
    }

}
