package cn.zxf.mybatis_starter.test.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors( fluent = true )
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String  name;
    private Integer age;
    private Integer status;
    private String  loginMobile;

}
