package cn.zxf.jdbc_transaction.test.user_log;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLog {

    private Long   id;
    private Long   userId;
    private String msg;

}
