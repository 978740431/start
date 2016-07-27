package com.star.mapper;

import com.star.model.Article;
import com.star.model.User;

import java.util.List;

/**
 * Created by zhangnan on 16/7/24.
 */
public interface UserArticleMapper {
    List<Article> queryUserArticleList(User user);

    void deleteUserArticle(Article article);

    void insertUserArticle(Article article);
}
