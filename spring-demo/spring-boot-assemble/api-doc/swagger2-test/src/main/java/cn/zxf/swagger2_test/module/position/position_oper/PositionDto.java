package cn.zxf.swagger2_test.module.position.position_oper;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionDto {

    private String id;
    private String name;
    private Date   expireDate;

}
