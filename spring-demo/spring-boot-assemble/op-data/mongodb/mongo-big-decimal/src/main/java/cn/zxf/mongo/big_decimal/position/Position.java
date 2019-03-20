package cn.zxf.mongo.big_decimal.position;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document( collection = "position" )
public class Position {

    @Id
    private String     id;
    @CreatedDate
    private Date       createDate;

    private String     name;
    private BigDecimal fee;
    private String     desc;

}
