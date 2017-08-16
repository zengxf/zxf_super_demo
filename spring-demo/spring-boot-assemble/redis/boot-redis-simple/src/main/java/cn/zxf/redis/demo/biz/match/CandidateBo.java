package cn.zxf.redis.demo.biz.match;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateBo {

    private String id;
    private String name;
    private Integer random;
    
}
