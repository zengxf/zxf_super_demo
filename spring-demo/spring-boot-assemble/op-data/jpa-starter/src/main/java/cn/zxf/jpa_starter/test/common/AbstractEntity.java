package cn.zxf.jpa_starter.test.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.experimental.Accessors;

@MappedSuperclass
@Data
@Accessors( fluent = true )
public class AbstractEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    public Integer id;

    @Column( columnDefinition = "DATETIME default CURRENT_TIMESTAMP" )
    protected Date    createDate;

    @Column( columnDefinition = "DATETIME default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" )
    protected Date    updateDate;

}
