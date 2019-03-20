package cn.zxf.mongo.big_decimal.position.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PositionListItemDto {

    private String     id;
    private Date       createDate;
    private String     name;
    private BigDecimal fee;
    private String     desc;

}
