package cn.zxf.data_bury_point.bury;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * 埋点数据
 * 
 * <p>
 * Created by zxf on 2017-06-01
 */
@Document( collection = "bury_data" )
@Data
public class BuryData implements BuryDataConstant {

    @Id
    private String	 id;
    @CreatedDate
    private Date	 createDate;

    private String	 userId;
    private String	 requestMethod;	// 请求用的方法类型
    private String	 path;		// 未处理的路径
    private List<String> paths;
    private Integer	 result;	// 1: 正常，0: error
    private Integer	 status;	// HTTP 响应码
    private String	 contentJson;

    private Object	 param;
    private Object	 content;

}
