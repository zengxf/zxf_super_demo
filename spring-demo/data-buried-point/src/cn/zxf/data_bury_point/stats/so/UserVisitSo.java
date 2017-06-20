package cn.zxf.data_bury_point.stats.so;

import lombok.Data;

/**
 * 用户访问统计
 * 
 * <p>
 * Created by zxf on 2017-06-07
 */
@Data
public class UserVisitSo {

    public static final String FIELD_USER_ID = "userId",   //
            FIELD_COUNT = "count";

    private String	       userId;
    private Integer	       count;

}
