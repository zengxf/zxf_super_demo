package cn.zxf.jpa_starter.test.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.zxf.jpa_starter.test.common.AbstractEntity;
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

    public String  name;
    public Integer age;
    public Integer status;
    public Integer type;

    @Column( length = 20 )
    public String  loginMobile;
    public Date    lastLoginDate;

    public User() {
    }

    public User( Integer id, Integer status ) {
        this.id = id;
        this.status = status;
    }

    public User id( Integer id ) {
        super.id( id );
        return this;
    }

}
