package com.star.service;

import com.star.model.Article;
import com.star.model.User;

import java.util.List;

/**
 * Created by zhangnan on 16/7/24.
 */
public interface UserArticleService {
    List<Article> queryUserArticleList(User user);

    void updateUserArticle(Article article);

    Article queryUserArticleById(int articleId);

}
