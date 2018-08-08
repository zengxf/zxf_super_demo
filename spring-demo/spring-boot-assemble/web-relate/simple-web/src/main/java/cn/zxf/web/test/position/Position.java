package cn.zxf.web.test.position;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {

    private Long    id;
    private String  name;

}
