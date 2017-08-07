package com.akuan.springboot.second.dao;

import com.akuan.springboot.second.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByAuthor(String author);

    Article findByAuthorAndTitle(String author, String title);

//    @Query("from ARTICLE a where a.author=:author")
//    Article findArticle(@Param("author") String author);

}
