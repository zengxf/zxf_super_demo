package cn.zxf.jpa_transaction.test.user_log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class UserLog {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long   id;
    private Long   userId;
    private String msg;

}
