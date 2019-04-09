package cn.zxf.security_token.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query( value = "FROM User WHERE loginMobile = ?1 OR loginAccount = ?1" )
    User login( String account );

}
