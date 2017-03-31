package cn.simple.test.util.builds;

import cn.simple.test.util.builds.aa.TestAa;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestUserBuilder {

    private TestUser value;

    public static TestUserBuilder get() {
	TestUserBuilder build = new TestUserBuilder();
	build.value = new TestUser();
	return build;
    }

    public static TestUserBuilder get( TestUser value ) {
	TestUserBuilder build = new TestUserBuilder();
	build.value = value;
	return build;
    }

    public TestUser build() {
	return this.value;
    }

    public TestUserBuilder setName( String name ) {
	this.value.setName( name );
	return this;
    }

    public TestUserBuilder setUpdateTime( Timestamp updateTime ) {
	this.value.setUpdateTime( updateTime );
	return this;
    }

    public TestUserBuilder setAge( Integer age ) {
	this.value.setAge( age );
	return this;
    }

    public TestUserBuilder setStatus( int status ) {
	this.value.setStatus( status );
	return this;
    }

    public TestUserBuilder setCreateTime( Date createTime ) {
	this.value.setCreateTime( createTime );
	return this;
    }

    public TestUserBuilder setResults( Map<String, TestAa> results ) {
	this.value.setResults( results );
	return this;
    }

    public TestUserBuilder setTags( List<String> tags ) {
	this.value.setTags( tags );
	return this;
    }

    public TestUserBuilder setType( String type ) {
	this.value.setType( type );
	return this;
    }

}
