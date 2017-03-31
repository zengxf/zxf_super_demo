package cn.simple.test.util.compare_field;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode£¨callSuper = false£©
public class TestCompareObj extends TestCompareObjSuper {

    private String		name;
    private Integer		age;
    private Date		createDate;
    private int			status;
    private TestCompareObjInter	internal;

    public TestCompareObj( String name, Integer age, Date createDate ) {
	super();
	this.name = name;
	this.age = age;
	this.createDate = createDate;
    }

}
