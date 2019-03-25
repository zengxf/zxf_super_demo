package cn.zxf.mybatis_starter.test.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    protected Integer id;

    @Column( name = "create_date", columnDefinition = "DATETIME default CURRENT_TIMESTAMP" )
    protected Date    createDate;

    @Column( name = "update_date", columnDefinition = "DATETIME default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" )
    protected Date    updateDate;

}
