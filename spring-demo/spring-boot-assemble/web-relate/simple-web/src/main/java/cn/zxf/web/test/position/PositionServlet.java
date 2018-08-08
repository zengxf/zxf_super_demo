package cn.zxf.web.test.position;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/position-servlet" )
public class PositionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init( ServletConfig config ) throws ServletException {
        super.init( config );
        System.out.println( "++ PositionServlet-init：" + this );
    }

    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        // super.doGet( req, res ); // 直接调用父类的，会返回 405 错误
        System.out.println( "++ PositionServlet-doGet：" + this );
        res.getWriter()
                .write( "OK" );
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println( "++ PositionServlet-destroy：" + this );
    }

}
