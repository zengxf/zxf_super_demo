package cn.zxf.spring.retry.test;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    @Retryable( TestException.class )
    public String test1() throws TestException {
	long sys = System.currentTimeMillis();
	long sign = sys % 5;
	if ( sign == 0 ) {
	    System.out.println( "test - 1 => random error => " + sys );
	    throw new TestException( "test - 1 => random error => " + sys );
	}
	return "test - 1 - ok => " + sign;
    }

    /**
     * <pre>
     * &#64;Retryable：标注此注解的方法在发生异常时会进行重试
     *    参数说明：value：抛出指定异常才会重试
     *    include：和value一样，默认为空，当exclude也为空时，默认所以异常
     *    exclude：指定不处理的异常
     *    maxAttempts:最大重试次数，默认3次
     *    backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，multiplier（指定延迟倍数）
     *    默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为2，则第一次重试为1秒，第二次为
     *        2秒，第三次为4秒
     * </pre>
     * 
     * @param name
     * @return
     * @throws TestException
     */
    @Retryable( value = TestException.class, backoff = @Backoff( value = 1000, multiplier = 2 ) )
    public String test2( String name ) throws TestException {
	long sys = System.currentTimeMillis();
	long sign = sys % 3;
	if ( sign == 0 ) {
	    System.out.println( "test - 2 => random error => " + sys );
	    throw new TestException( "test - 2 => random error => " + sys );
	} else if ( sign == 1 ) {
	    throw new RuntimeException( "run error !!!" );
	}
	return "test - 2 - ok => " + sign;
    }

    /**
     * <pre>
     * &#64;Recover：用于@Retryable重试失败后处理方法，此方法里的异常一定要是@Retryable方法里抛出的异常，否则不会调用
     * </pre>
     * 
     * @param e
     * @return
     */
    @Recover
    public String recover( TestException e ) {
	return "恢复 = " + e.getMessage();
    }

}
