package cn.zxf.test.ldap;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import lombok.Data;

@Data
@Entry( base = "ou=people,dc=zxf,dc=com", objectClasses = "inetOrgPerson" )
public class Person {

    @Id
    private Name   id;
    @DnAttribute( value = "uid", index = 3 )
    private String uid;
    @Attribute( name = "cn" )
    private String commonName;
    @Attribute( name = "sn" )
    private String suerName;
    private String userPassword;

}