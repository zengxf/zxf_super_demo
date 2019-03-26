package cn.zxf.mybatis_starter.test.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName( String name );

    @Query( value = "SELECT status FROM user WHERE id = ?1", nativeQuery = true )
    Integer findStatus( Integer id );

    @Deprecated
    @Query( value = "SELECT u.id, u.status FROM User u WHERE u.id = ?1" )
    User findOneOnlyStatus( Integer id );

}
