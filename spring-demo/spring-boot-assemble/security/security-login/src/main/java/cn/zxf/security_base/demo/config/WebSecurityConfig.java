package cn.zxf.security_base.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure1( HttpSecurity http ) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/", "/home" )
                .permitAll()

                .anyRequest()
                .authenticated()
                .and()

                .formLogin()
                .loginPage( "/login" )
                .permitAll()
                .and()

                .logout()
                .permitAll();
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http //
                .authorizeRequests() // T
                .antMatchers( "/resources/**", "/signup", "/about" )
                .permitAll() // 1
                .antMatchers( "/ui/user/login" )
                .permitAll() // 1

                .antMatchers( "/admin/**" )
                .hasRole( "ADMIN" ) // 2

                .antMatchers( "/db/**" )
                .access( "hasRole('ADMIN') and hasRole('DBA')" ) // 3

                .anyRequest()
                .authenticated() // 4
                .and() // A

                .formLogin()
                .usernameParameter( "username" )
                .passwordParameter( "password" )
                .failureForwardUrl( "/login?error" )
                .loginPage( "/login" )
                .permitAll()
                .and() // B

                .logout()
                .logoutUrl( "/logout" )
                .logoutSuccessUrl( "/index" )
                .permitAll()
                .and() // C

                .httpBasic()
                .disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername( "zxf" )
                .password( "abc" )
                .roles( "USER" )
                .build();
        InMemoryUserDetailsManager msg = new InMemoryUserDetailsManager();
        msg.createUser( user );
        return msg;
    }

}