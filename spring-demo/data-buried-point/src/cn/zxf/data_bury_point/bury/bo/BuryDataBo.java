package cn.zxf.data_bury_point.bury.bo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuryDataBo {

    private String		userId;
    private String		requestMethod; // 请求用的方法类型
    private String		path;
    private Integer		result;	       // 1: 正常，0: error
    private Integer		status;	       // HTTP 响应码
    private String		contentJson;

    private Map<String, Object>	param;

}
