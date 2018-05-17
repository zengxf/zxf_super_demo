package cn.zxf.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * <p>
 * Created by zengxf on 2018-01-11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser( User.withUsername( "user_1" )
                .password( "123456" )
                .authorities( "client" )
                .disabled( false )
                .accountExpired( false )
                .accountLocked( false )
                .credentialsExpired( false )
                .build() );
        manager.createUser( User.withUsername( "user_2" )
                .password( "123456" )
                .authorities( "client" )
                .disabled( true )
                .accountExpired( true )
                .accountLocked( true )
                .credentialsExpired( true )
                .build() );
        return manager;
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.requestMatchers()
                .anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers( "/oauth/*" )
                .permitAll()
                .and()
                .formLogin()
                .permitAll();
    }

}
