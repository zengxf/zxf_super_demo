package cn.zxf.security_token.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.experimental.Accessors;

@DynamicInsert
@DynamicUpdate
@Entity
@Table( name = "security_token_user" )
@Data
@Accessors( fluent = true )
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    public Integer id;
    @Column( columnDefinition = "DATETIME default CURRENT_TIMESTAMP" )
    protected Date createDate;
    public String  name;

    @Column( length = 20 )
    public String  loginAccount;
    @Column( length = 20 )
    public String  loginMobile;
    public String  loginPassword;

}
