package cn.zxf.mybatis_starter.test.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long    id;
    private String  name;
    private Integer age;
    private Integer status;
    private String  loginMobile;

}
