package cn.zxf.spring.boot.mvc.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.zxf.spring.boot.mvc.security.demo.dao.SysUserRepository;
import cn.zxf.spring.boot.mvc.security.demo.domain.SysUser;

public class CustomUserService implements UserDetailsService { //1
	@Autowired
	SysUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) { //2
		
		SysUser user = userRepository.findByUsername(username); 
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return user; //3
	}

}
