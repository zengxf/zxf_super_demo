package cn.zxf.swagger2_test_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http //
                .authorizeRequests()
                .antMatchers( "/fuck" //

                        , "/swagger-resources/**" // swagger api ui
                        , "/webjars/**" // swagger api ui
                        , "/v2/api-docs/**" // swagger api ui
                        , "/swagger-ui.html" // swagger api ui

                        , "/api/**" // api

                )
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}