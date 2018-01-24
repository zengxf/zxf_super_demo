package cn.zxf.mongo.big_decimal.position.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PositionCreateDto {

    private String     name;
    private BigDecimal fee;
    private String     desc;

}
