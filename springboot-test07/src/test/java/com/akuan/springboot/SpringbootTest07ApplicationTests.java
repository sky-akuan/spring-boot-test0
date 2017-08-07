package com.akuan.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest07ApplicationTests {
    @Autowired
//    @Qualifier(value = "firstJdbcTemplate")
    private JdbcTemplate firstJdbcTemplate;

    @Autowired
    @Qualifier(value = "secondJdbcTemplate")
    private JdbcTemplate secondJdbcTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMultiDataSource() {
        int i = firstJdbcTemplate.update("INSERT INTO USER (NAME ,AGE) VALUES (?,?)","name1",18);
        Assert.assertEquals(1,i);
        int j = secondJdbcTemplate.update("INSERT INTO USER (NAME ,AGE) VALUES (?,?)","name2",18);
        Assert.assertEquals(1,i);
    }
}
