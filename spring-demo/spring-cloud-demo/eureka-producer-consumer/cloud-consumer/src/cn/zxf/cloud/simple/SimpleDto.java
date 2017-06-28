package cn.zxf.cloud.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleDto {

    private String  name;
    private Integer age;
    private Integer status;

}
