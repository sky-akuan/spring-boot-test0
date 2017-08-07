package com.akuan.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName: JdbcTemplateConfig
 * @Description: JdbcTemplateConfig
 * @author: zhaozhenkuan
 * @date: 2017-07-28 下午5:34
 * @version: V1.0
 */
@Configuration
public class JdbcTemplateConfig {

    @Bean("firstJdbcTemplate")
    JdbcTemplate firstJdbcTemplate(@Qualifier("firstDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("secondJdbcTemplate")
    JdbcTemplate secondJdbcTemplate(@Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
