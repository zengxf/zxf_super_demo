package cn.zxf.jpa_transaction.test.position;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Position {

    @Id
    @GeneratedValue
    private Long    id;
    private String  name;
    private Integer age;

}
