package cn.zxf.web.test.common.service_exception;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors( chain = true )
@Data
public class Result {
    private int    code;
    private String message;
    private Object data;
}
