package cn.zxf.web.test.error;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class FormDto {

    @NotEmpty( message = "名称不能为空" )
    private String  name;

    @NotNull( message = "年龄不能为空" )
    @Min( value = 18, message = "年龄不能小于 18" )
    private Integer age;

    @NotNull( message = "{verify-status-is-null}" )
    private Integer status;

}
