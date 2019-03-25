package cn.zxf.mybatis_starter.test.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface UserMapper {

    @Insert( "INSERT INTO user (name, age, login_mobile) VALUES(#{name}, #{age}, #{loginMobile})" )
    @Options( useGeneratedKeys = true, keyProperty = "id" )
    void insert( User user );

    @Select( "SELECT id, name, age, login_mobile loginMobile FROM user WHERE id = #{id}" )
    User findById( long id );

    @Select( "SELECT id, name, age, login_mobile loginMobile FROM user WHERE name = #{key} OR login_mobile = #{key}" )
    List<User> findListByKey( String key );

    @Update( "UPDATE user SET name=#{name}, age=#{age}, login_mobile=#{loginMobile} WHERE id = #{id}" )
    void update( User user );

    @UpdateProvider( type = SqlBuilder.class, method = "buildUpdate" )
    void updateFieldNullable( User user );

    static class SqlBuilder {
        public static String buildUpdate( User user ) {
            return new SQL() {
                {
                    UPDATE( "user" );
                    if ( user.getName() != null )
                        SET( "name = #{name}" );
                    if ( user.getAge() != null )
                        SET( "age = #{age}" );
                    WHERE( "id = #{id}" );
                }
            }.toString();
        }
    }
}
