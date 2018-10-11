package cn.zxf.unit_test.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String  name;
    private Integer age;
    private Integer status;
    private String  desc;

}
