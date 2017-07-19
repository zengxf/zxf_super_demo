package cn.zxf.redis.demo.biz.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String  id;
    private String  name;
    private Integer age;
    private Integer status;

}
