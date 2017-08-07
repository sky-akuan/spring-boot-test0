package com.akuan.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryFirst",
        transactionManagerRef = "transactionManagerFirst",
        basePackages = {"com.akuan.springboot.first.dao"}) //设置Repository所在位置
public class JpaConfigFirst {
    @Autowired
    @Qualifier("firstDataSource")
    private DataSource firstDataSource;

    @Primary
    @Bean(name = "entityManagerFirst")
    public EntityManager entityManagerFirst(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryFirst(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryFirst")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFirst(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(firstDataSource)
                .properties(getVendorProperties(firstDataSource))
                .packages("com.akuan.springboot.first.entity") //设置实体类所在位置
                .persistenceUnit("persistenceUnitFirst")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerFirst")
    public PlatformTransactionManager transactionManagerFirst(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryFirst(builder).getObject());
    }
}