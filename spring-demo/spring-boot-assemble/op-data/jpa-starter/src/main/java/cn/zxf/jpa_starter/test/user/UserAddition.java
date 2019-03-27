package cn.zxf.jpa_starter.test.user;

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
@Table
@Data
@Accessors( fluent = true )
@ToString( callSuper = true )
@EqualsAndHashCode( callSuper = true )
public class UserAddition extends AbstractEntity {

    private String name;

}
