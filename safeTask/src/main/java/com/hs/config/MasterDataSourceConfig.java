package com.hs.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * mysql从库配置类 @日期： 2018年7月5日 下午10:05:25 @作者： Chendb
 */
@Configuration
@MapperScan(basePackages = "com.hs.mapper", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${spring.datasource.druid.url}")  
    private String url;  
      
    @Value("${spring.datasource.druid.username}")  
    private String username;  
      
    @Value("${spring.datasource.druid.password}")  
    private String password;  
      
    @Value("${spring.datasource.druid.driverClassName}")  
    private String driverClassName;  
    
    @Value("${spring.datasource.druid.initialSize}")  
    private int initialSize;  
      
    @Value("${spring.datasource.druid.minIdle}")  
    private int minIdle;  
      
    @Value("${spring.datasource.druid.maxActive}")  
    private int maxActive;  
      
    @Value("${spring.datasource.druid.maxWait}")  
    private int maxWait;  
      
    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")  
    private int timeBetweenEvictionRunsMillis;  
      
    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")  
    private int minEvictableIdleTimeMillis;  
      
    @Value("${spring.datasource.druid.validationQuery}")  
    private String validationQuery;  
      
    @Value("${spring.datasource.druid.testWhileIdle}")  
    private boolean testWhileIdle;  
      
    @Value("${spring.datasource.druid.testOnBorrow}")  
    private boolean testOnBorrow;  
      
    @Value("${spring.datasource.druid.testOnReturn}")  
    private boolean testOnReturn;  
      
    @Value("${spring.datasource.druid.poolPreparedStatements}")  
    private boolean poolPreparedStatements;  
      
    @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;  
      
    @Value("${spring.datasource.druid.filters}")  
    private String filters;  
      
    @Value("{spring.datasource.druid.connectionProperties}")  
    private String connectionProperties;  
    
    
    @Bean(name = "masterDataSource")
    @Primary 
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);  
        dataSource.setUsername(username);  
        dataSource.setPassword(password);  
        dataSource.setDriverClassName(driverClassName);  
          
        //具体配置 
        dataSource.setInitialSize(initialSize);  
        dataSource.setMinIdle(minIdle);  
        dataSource.setMaxActive(maxActive);  
        dataSource.setMaxWait(maxWait);  
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
        dataSource.setValidationQuery(validationQuery);  
        dataSource.setTestWhileIdle(testWhileIdle);  
        dataSource.setTestOnBorrow(testOnBorrow);  
        dataSource.setTestOnReturn(testOnReturn);  
        dataSource.setPoolPreparedStatements(poolPreparedStatements);  
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
        try {  
            dataSource.setFilters(filters);  
        } catch (SQLException e) { 
            e.printStackTrace();
        }  
        dataSource.setConnectionProperties(connectionProperties);  
        return dataSource;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}