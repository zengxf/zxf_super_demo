package cn.zxf.state_machine.demo.event;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WithStateMachine
public class EventConfig {

    @OnTransition( target = "UNPAID" )
    public void create() {
        log.info( "订单创建，待支付" );
    }

    @OnTransition( source = "UNPAID", target = "WAITING_FOR_RECEIVE" )
    public void pay() {
        log.info( "用户完成支付，待收货" );
    }

    // @OnTransition 前面执行
    @OnTransitionStart( source = "UNPAID", target = "WAITING_FOR_RECEIVE" )
    public void payStart() {
        log.info( "用户完成支付，待收货: start" );
    }

    // @OnTransition 后面执行
    @OnTransitionEnd( source = "UNPAID", target = "WAITING_FOR_RECEIVE" )
    public void payEnd() {
        log.info( "用户完成支付，待收货: end" );
    }

    @OnTransition( source = "WAITING_FOR_RECEIVE", target = "DONE" )
    public void receive() {
        log.info( "用户已收货，订单完成" );
    }

    // --------

    @OnTransition( source = "UNPAID", target = "DONE" )
    public void payToDone() {
        log.info( "用户完成支付，无需收货即可完成" );
    }

}