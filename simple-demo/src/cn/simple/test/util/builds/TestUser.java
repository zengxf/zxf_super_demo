package cn.simple.test.util.builds;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.simple.test.util.builds.aa.TestAa;

public class TestUser extends TestPerson {
    private String		name;
    private Integer		age;
    private Date		createTime;
    private Timestamp		updateTime;
    private int			status;
    private List<String>	tags;
    private Map<String, TestAa>	results;

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

    public Date getCreateTime() {
	return createTime;
    }

    public void setCreateTime( Date createTime ) {
	this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
	return updateTime;
    }

    public void setUpdateTime( Timestamp updateTime ) {
	this.updateTime = updateTime;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus( int status ) {
	this.status = status;
    }

    public List<String> getTags() {
	return tags;
    }

    public void setTags( List<String> tags ) {
	this.tags = tags;
    }

    public Map<String, TestAa> getResults() {
	return results;
    }

    public void setResults( Map<String, TestAa> results ) {
	this.results = results;
    }

}
