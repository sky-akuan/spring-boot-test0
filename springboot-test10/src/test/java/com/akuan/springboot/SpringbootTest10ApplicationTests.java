package com.akuan.springboot;

import com.akuan.springboot.first.domain.User;
import com.akuan.springboot.first.mapper.UserMapper;
import com.akuan.springboot.second.domain.Article;
import com.akuan.springboot.second.mapper.ArticleMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest10ApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional(transactionManager ="secondTransactionManager" )
    public void testMybatis() {
        User user = new User();
        user.setName("小小");
        user.setAge(11);
        int result = userMapper.insert(user);
//        if (result == 1) {
//            throw new RuntimeException();
//        }
        Assert.assertEquals(1, result);
        Article article = new Article();
        article.setAuthor("author123");
        article.setTitle("123");
        int j = articleMapper.insert(article);
        Assert.assertEquals(1, j);


    }


}
