package cn.zxf.jpa_starter.test.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName( String name );

    @Query( value = "SELECT status FROM user WHERE id = ?1", nativeQuery = true )
    Integer findStatus( Integer id );

    @Query( value = "SELECT id, status FROM user WHERE id = ?1", nativeQuery = true )
    Object findStatusAndId( Integer id );

    @Modifying
    @Transactional
    @Query( value = "REPLACE INTO user (id, name, login_mobile, status) VALUE(:#{#user.id}, :#{#user.name}, :#{#user.loginMobile}, :#{#user.status})", nativeQuery = true )
    void replace( @Param( "user" ) User user );

    @Modifying
    @Transactional
    @Query( value = "REPLACE INTO user (id, name, login_mobile, status) VALUE(:id, :name, :loginMobile, :status)", nativeQuery = true )
    void replace( @Param( "id" ) int id, @Param( "name" ) String name, @Param( "loginMobile" ) String loginMobile, @Param( "status" ) int status );

    @Modifying
    @Transactional
    @Query( value = "INSERT INTO user (id, name, login_mobile, status) VALUE(?1, ?2, ?3, ?4)", nativeQuery = true )
    void insert( Integer id, String name, String loginMobile, Integer status );

}
