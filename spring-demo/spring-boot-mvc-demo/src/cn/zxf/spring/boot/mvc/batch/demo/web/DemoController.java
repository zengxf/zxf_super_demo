package cn.zxf.spring.boot.mvc.batch.demo.web;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    JobLauncher		 jobLauncher;

    @Autowired
    Job			 importJob;

    public JobParameters jobParameters;

    @Value( "${root.path}" )
    private String	 rootPath;

    @RequestMapping( "/read" )
    public String imp( String fileName ) throws Exception {

	String path = rootPath + fileName + ".csv";
	jobParameters = new JobParametersBuilder() //
	        .addLong( "time", System.currentTimeMillis() ) // 用于区别 ID
	        .addString( "input.file.name", path ) //
	        .toJobParameters();
	jobLauncher.run( importJob, jobParameters );
	return "ok";
    }

}
