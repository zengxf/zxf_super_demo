package cn.simple.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectionUtil {

    /**
     * 获取本地连接
     * 
     * @return
     */
    public static Connection getLocalConnection() {
	try {
	    String url = "jdbc:mysql://localhost:3306/zxf_dev";
	    String user = "root";
	    String password = "admin";

	    Driver.class.getName();
	    Connection conn = DriverManager.getConnection(url, user, password);

	    return conn;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }

}
