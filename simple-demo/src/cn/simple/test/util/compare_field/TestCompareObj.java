package cn.simple.test.util.compare_field;

import java.util.Date;

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

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge( Integer age ) {
	this.age = age;
    }

    public Date getCreateDate() {
	return createDate;
    }

    public void setCreateDate( Date createDate ) {
	this.createDate = createDate;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus( int status ) {
	this.status = status;
    }

    public TestCompareObjInter getInternal() {
	return internal;
    }

    public void setInternal( TestCompareObjInter internal ) {
	this.internal = internal;
    }

}
