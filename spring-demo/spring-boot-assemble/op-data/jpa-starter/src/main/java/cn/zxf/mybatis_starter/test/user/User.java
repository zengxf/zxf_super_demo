package cn.zxf.mybatis_starter.test.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.zxf.mybatis_starter.test.common.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@DynamicInsert
@DynamicUpdate
@Entity
@Table( name = "user" )
@Data
@Accessors( fluent = true )
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class User extends AbstractEntity {

    private String  name;
    private Integer age;
    private Integer status;

    @Column( length = 20 )
    private String  loginMobile;
    private Date    lastLoginDate;

}
