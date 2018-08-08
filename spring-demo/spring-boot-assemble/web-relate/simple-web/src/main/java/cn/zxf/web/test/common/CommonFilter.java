package cn.zxf.web.test.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter
public class CommonFilter implements Filter {

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        System.out.println( "~~ CommonFilter-init：" + this );
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
        System.out.println( "~~ CommonFilter-doFilter-in：" + this );
        chain.doFilter( request, response );
        System.out.println( "~~ CommonFilter-doFilter-out：" + this );
    }

    @Override
    public void destroy() {
        System.out.println( "~~ CommonFilter-destroy：" + this );
    }

}
