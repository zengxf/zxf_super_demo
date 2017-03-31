package cn.zxf.spring.boot.mvc.security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.zxf.spring.boot.mvc.security.demo.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	
	SysUser findByUsername(String username);

}
