package com.akuan.springboot;

import com.akuan.springboot.first.dao.UserRepository;
import com.akuan.springboot.first.entity.User;
import com.akuan.springboot.second.dao.ArticleRepository;
import com.akuan.springboot.second.entity.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest08ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMultiJpa() {
        String name = "jpa multi多数据源";
        Integer age = 199;

        userRepository.save(new User(name, age));

        Assert.assertEquals(age.longValue(), userRepository.findByNameAndAge(name, age).getAge().longValue());

        Assert.assertEquals(name, userRepository.findUser(name).getName());


        String author = "author";
        String title = "title";

       articleRepository.save(new Article(author, title));

        Assert.assertEquals(author, articleRepository.findByAuthorAndTitle(author, title).getAuthor());

//        Assert.assertEquals(author, articleRepository.findArticle(author).getAuthor());


    }

}
