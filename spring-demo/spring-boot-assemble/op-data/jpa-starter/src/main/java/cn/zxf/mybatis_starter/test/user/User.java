package cn.zxf.mybatis_starter.test.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.zxf.mybatis_starter.test.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table( name = "user" )
@Data
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    private String  name;
    private Integer age;

    @Column( name = "login_mobile", length = 20 )
    private String  loginMobile;

    private Date    lastLoginDate;

}
