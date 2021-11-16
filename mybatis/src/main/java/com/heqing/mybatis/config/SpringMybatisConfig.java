package com.heqing.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author heqing
 * @since 2021-07-21
 *
 * @MapperScan : 扫描Mybatis的Mapper接口
 * @EnableTransactionManagement : 开启事务管理
 */
@Configuration
@ComponentScan("com.heqing.mybatis.*")
@MapperScan("com.heqing.mybatis.dao, com.heqing.mybatis.mapper")
@EnableTransactionManagement
public class SpringMybatisConfig {

    /**
     * 配置数据源
     **/
    @Bean
    public DataSource dataSource(DBProperty dbProperty) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(dbProperty.getUser());
        dataSource.setPassword(dbProperty.getPassword());
        dataSource.setUrl(dbProperty.getUrl());
        dataSource.setDriverClassName(dbProperty.getDriverClass());
        dataSource.setInitialSize(dbProperty.getInitialSize());
        dataSource.setMinIdle(dbProperty.getMinIdle());
        dataSource.setMaxActive(dbProperty.getMaxActive());
        dataSource.setMaxWait(dbProperty.getMaxWait());
        dataSource.setValidationQuery(dbProperty.getValidationQuery());
        dataSource.setTestWhileIdle(dbProperty.getTestWhileIdle());
        dataSource.setTestOnBorrow(dbProperty.getTestOnBorrow());
        dataSource.setTestOnReturn(dbProperty.getTestOnReturn());
        dataSource.setTimeBetweenEvictionRunsMillis(dbProperty.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(dbProperty.getMinEvictableIdleTimeMillis());
        dataSource.setPoolPreparedStatements(dbProperty.getPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(dbProperty.getMaxPoolPreparedStatementPerConnectionSize());
        return dataSource;
    }

    /**
     * 配置mybatis的SqlSessionFactoryBean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, MapperProperty mapperProperty) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(mapperProperty.getTypeAliasesPackage());

        // 动态获取SqlMapper
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(classPathResource.getResources(mapperProperty.getMapperLocations()));

        // 分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    /**
     * mybatis自动扫描加载Sql映射文件
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    /**
     * 配置spring的声明式事务
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;

    }
}
