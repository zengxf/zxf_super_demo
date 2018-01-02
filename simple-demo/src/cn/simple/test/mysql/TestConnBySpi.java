package cn.simple.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试 - 通过 SPI 获取连接 <br>
 * 不再需要调用 Class.forName("com.mysql.jdbc.Driver")
 * 
 * <p>
 * Created by zengxf on 2018-01-02
 */
public class TestConnBySpi {

    public static void main( String[] args ) {
        Connection conn = getLocalConnection();
        System.out.println( conn );
    }

    static Connection getLocalConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/zxf_dev";
            String user = "root";
            String password = "admin";

            Connection conn = DriverManager.getConnection( url, user, password );

            return conn;
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return null;
    }

}
