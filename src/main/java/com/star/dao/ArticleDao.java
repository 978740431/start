package com.star.dao;

import com.star.model.Article;
import com.star.model.Question;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface ArticleDao {
    List<Article> queryArticleList();

    void insertArticle(Article article);

    Article queryArticleById(int articleId);

    void updateReadTimesById(int articleId);
}
