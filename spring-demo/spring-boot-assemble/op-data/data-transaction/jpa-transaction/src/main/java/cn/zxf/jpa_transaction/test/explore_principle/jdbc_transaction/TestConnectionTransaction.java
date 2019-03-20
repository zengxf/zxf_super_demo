package cn.zxf.jpa_transaction.test.explore_principle.jdbc_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Random;

public class TestConnectionTransaction {
    static String userSqlFmt    = "insert into user(name, age) values('user-%tT', %d)";
    static String userLogSqlFmt = "insert into user_log(user_id, msg) values(%d, 'log-%tT')";

    public static void main( String[] args ) throws SQLException {
        // testSimpleCommit();
        // testSimpleRollback();
        // testCommitAndRollback();
        // testSimpleSavePoint();
        testComplexSavePoint();
        // testSavePointRelease();
    }

    static void testSavePointRelease() throws SQLException {
        truncateTable();

        Connection conn = getLocalConnection();
        Statement userStmt = conn.createStatement();

        Savepoint spUser = conn.setSavepoint( "user-test" );
        String userSql = String.format( userSqlFmt, System.currentTimeMillis(), new Random().nextInt( 100 ) );
        userStmt.execute( userSql );
        System.out.println( spUser );
        System.out.println( "insert into : " + userSql );

        Savepoint spUserLog = conn.setSavepoint( "user-log-test" );
        String userLogSql = String.format( userLogSqlFmt, System.currentTimeMillis() % 1000, System.currentTimeMillis() );
        userStmt.execute( userLogSql );
        System.out.println( spUserLog );
        System.out.println( "insert into : " + userLogSql );

        conn.releaseSavepoint( spUserLog ); // MySql 并没有实现
        conn.rollback( spUserLog );

        conn.commit();
    }

    static void testComplexSavePoint() throws SQLException {
        truncateTable();

        Connection conn = getLocalConnection();
        Statement userStmt = conn.createStatement();

        Savepoint spUser = conn.setSavepoint( "user-test" );
        String userSql = String.format( userSqlFmt, System.currentTimeMillis(), new Random().nextInt( 100 ) );
        userStmt.execute( userSql );
        System.out.println( spUser );
        System.out.println( "insert into : " + userSql );

        Savepoint spUserLog1 = conn.setSavepoint( "user-log-test" );
        String userLogSql = String.format( userLogSqlFmt, System.currentTimeMillis() % 1000, System.currentTimeMillis() );
        userStmt.execute( userLogSql );
        System.out.println( spUserLog1 );
        System.out.println( "insert into : " + userLogSql );

        conn.rollback( spUserLog1 );

        Savepoint spUserLog2 = conn.setSavepoint( "user-log-test" );
        userLogSql = String.format( userLogSqlFmt, System.currentTimeMillis() % 1000, System.currentTimeMillis() );
        userStmt.execute( userLogSql );
        System.out.println( spUserLog2 );
        System.out.println( "insert into : " + userLogSql );

        conn.commit();
    }

    static void testSimpleSavePoint() throws SQLException {
        truncateTable();

        Connection conn = getLocalConnection();
        Statement userStmt = conn.createStatement();

        Savepoint spUser = conn.setSavepoint( "user-test" );
        String userSql = String.format( userSqlFmt, System.currentTimeMillis(), new Random().nextInt( 100 ) );
        userStmt.execute( userSql );
        System.out.println( spUser );
        System.out.println( "insert into : " + userSql );

        Savepoint spUserLog = conn.setSavepoint( "user-log-test" );
        String userLogSql = String.format( userLogSqlFmt, System.currentTimeMillis() % 1000, System.currentTimeMillis() );
        userStmt.execute( userLogSql );
        System.out.println( spUserLog );
        System.out.println( "insert into : " + userLogSql );

        // conn.rollback( spUser ); // 下面的都会回滚
        conn.rollback( spUserLog );

        conn.commit();
    }

    static void testCommitAndRollback() throws SQLException {
        truncateTable();

        Connection userConn = getLocalConnection();
        Statement userStmt = userConn.createStatement();
        Connection userLogConn = getLocalConnection();
        Statement userLogStmt = userLogConn.createStatement();

        String userSql = String.format( userSqlFmt, System.currentTimeMillis(), new Random().nextInt( 100 ) );
        userStmt.execute( userSql );
        System.out.println( "insert into : " + userSql );

        String userLogSql = String.format( userLogSqlFmt, System.currentTimeMillis() % 1000, System.currentTimeMillis() );
        userLogStmt.execute( userLogSql );
        System.out.println( "insert into : " + userLogSql );
        userLogConn.rollback();

        userConn.commit();
    }

    static void testSimpleCommit() throws SQLException {
        truncateTable();

        Connection conn = getLocalConnection();
        Statement stmt = conn.createStatement();

        String userSql = String.format( userSqlFmt, System.currentTimeMillis(), new Random().nextInt( 100 ) );
        stmt.execute( userSql );
        System.out.println( "insert into : " + userSql );
        conn.commit();
    }

    static void testSimpleRollback() throws SQLException {
        truncateTable();

        Connection conn = getLocalConnection();
        Statement stmt = conn.createStatement();

        String userSql = String.format( userSqlFmt, System.currentTimeMillis(), new Random().nextInt( 100 ) );
        stmt.execute( userSql );
        System.out.println( "insert into : " + userSql );
        conn.rollback();
    }

    static void truncateTable() throws SQLException {
        Connection conn = getLocalConnection();
        Statement stmt = conn.createStatement();
        stmt.execute( "truncate table user" );
        stmt.execute( "truncate table user_log" );
    }

    /**
     * 获取本地连接
     */
    public static Connection getLocalConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&enableQueryTimeouts=true&connectTimeout=100";
            String user = "root";
            String password = "admin";
            Connection conn = DriverManager.getConnection( url, user, password );
            conn.setAutoCommit( false );
            return conn;
        } catch ( SQLException e ) {
            throw new RuntimeException( "获取连接出错", e );
        }
    }

}
