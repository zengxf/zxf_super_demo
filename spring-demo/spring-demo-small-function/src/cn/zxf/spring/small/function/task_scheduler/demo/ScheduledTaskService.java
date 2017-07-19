package cn.zxf.spring.small.function.task_scheduler.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( "HH:mm:ss" );

    /**
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
	 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
	 * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
	*/
    @Scheduled( fixedRate = 5000 ) // 1
    public void reportCurrentTime() {
	System.out.println( "每隔五秒执行一次 " + dateFormat.format( new Date() ) );
    }

    @Scheduled( cron = "0 28 11 ? * *" ) // 2
    public void fixTimeExecution() {
	System.out.println( "在指定时间 " + dateFormat.format( new Date() ) + "执行" );
    }

}
