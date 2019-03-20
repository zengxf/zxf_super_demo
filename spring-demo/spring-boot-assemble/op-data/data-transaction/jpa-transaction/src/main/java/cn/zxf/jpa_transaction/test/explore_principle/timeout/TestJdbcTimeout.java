package cn.zxf.jpa_transaction.test.explore_principle.timeout;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.zxf.jpa_transaction.test.explore_principle.jdbc_transaction.TestConnectionTransaction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestJdbcTimeout {

    public static void main( String[] args ) throws SQLException {
        Connection conn = TestConnectionTransaction.getLocalConnection();
        Statement stmt = conn.createStatement();
        log.info( "stmt: {}", stmt );
        stmt.setQueryTimeout( 1 );
        stmt.executeQuery( "select * from user_log" );
    }

}
