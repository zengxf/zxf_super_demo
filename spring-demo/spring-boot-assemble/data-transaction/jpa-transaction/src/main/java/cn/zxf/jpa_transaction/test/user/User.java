package cn.zxf.jpa_transaction.test.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long    id;
    private String  name;
    private Integer age;

}
