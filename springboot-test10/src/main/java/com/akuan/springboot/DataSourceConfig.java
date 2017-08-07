package com.akuan.springboot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceConfig
 * @Description: 数据源配置
 * @author: zhaozhenkuan
 * @date: 2017-07-28 下午5:21
 * @version: V1.0
 */
@Configuration
public class DataSourceConfig {
    @Bean("firstDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("firstTransactionManager")
    @Primary
    public DataSourceTransactionManager firstTransactionManager() {
        return new DataSourceTransactionManager(firstDataSource());
    }

    @Bean("firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory firstSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(firstDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:*/first/mapper/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com/akuan/springboot/first/domain");
        return sqlSessionFactoryBean.getObject();
    }

    /********************************************************************************************************************/

    @Bean("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean("secondTransactionManager")
    public DataSourceTransactionManager secondTransactionManager() {
        return new DataSourceTransactionManager(secondDataSource());
    }


    @Bean("secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(secondDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:*/second/mapper/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com/akuan/springboot/second/domain");
        return sqlSessionFactoryBean.getObject();
    }
}
