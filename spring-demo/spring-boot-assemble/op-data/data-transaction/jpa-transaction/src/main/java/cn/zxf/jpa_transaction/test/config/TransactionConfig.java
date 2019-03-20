package cn.zxf.jpa_transaction.test.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

// @org.springframework.context.annotation.Configuration
public class TransactionConfig {

    @Bean // 设置事务管理器默认用 DataSourceTransactionManager
    public DataSourceTransactionManager transactionManager( DataSource ds ) {
        return new DataSourceTransactionManager( ds );
    }

}
