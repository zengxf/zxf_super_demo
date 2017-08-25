package cn.zxf.state_machine.demo.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.state_machine.demo.event.Events;
import cn.zxf.state_machine.demo.event.States;

@SpringBootTest
@RunWith( SpringRunner.class )
public class EventTest {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Test
    public void test() {
        stateMachine.start();

        stateMachine.sendEvent( Events.PAY );

        stateMachine.sendEvent( Events.RECEIVE );
    }

}
