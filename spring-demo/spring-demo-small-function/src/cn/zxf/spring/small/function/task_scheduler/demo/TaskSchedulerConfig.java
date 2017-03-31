package cn.zxf.spring.small.function.task_scheduler.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan( "cn.zxf.spring.small.function.task_scheduler.demo" )
@EnableScheduling // 1
public class TaskSchedulerConfig {

}
