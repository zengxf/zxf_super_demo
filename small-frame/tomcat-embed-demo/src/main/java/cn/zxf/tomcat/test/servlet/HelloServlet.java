package cn.zxf.tomcat.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "MyServlet", urlPatterns = "/hello" )
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write( "hello world by servlet".getBytes() );
        out.flush();
        out.close();
    }

}