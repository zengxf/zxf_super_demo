package cn.zxf.spring.boot.mvc.actuate.demo;

import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private String status;

    public String getStatus() {
	return status;
    }

    public void setStatus( String status ) {
	this.status = status;
    }

}
