package cn.zxf.web.test.user;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// @WebFilter( "/users/*" )
public class UserFilter implements Filter {

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        System.out.println( "~~ UserFilter-init：" + this );
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
        System.out.println( "~~ UserFilter-doFilter-in：" + this );
        chain.doFilter( request, response );
        System.out.println( "~~ UserFilter-doFilter-out：" + this );
    }

    @Override
    public void destroy() {
        System.out.println( "~~ UserFilter-destroy：" + this );
    }

}
