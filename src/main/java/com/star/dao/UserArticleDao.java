package com.star.dao;

import com.star.model.Article;
import com.star.model.User;

import java.util.List;

/**
 * Created by zhangnan on 16/7/24.
 */
public interface UserArticleDao {
    List<Article> queryUserArticleList(User user);

    void deleteUserArticle(Article article);

    void insertUserArticle(Article article);

    Article queryUserArticleById(int articleId);

    void updateUserArticle(Article article);
}
