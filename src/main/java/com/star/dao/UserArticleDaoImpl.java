package com.star.dao;

import com.star.mapper.UserArticleMapper;
import com.star.model.Article;
import com.star.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangnan on 16/7/24.
 */
@Repository
public class UserArticleDaoImpl implements UserArticleDao{

    @Resource
    private UserArticleMapper userArticleMapper;
    @Override
    public List<Article> queryUserArticleList(User user) {
        return userArticleMapper.queryUserArticleList(user);
    }

    @Override
    public void deleteUserArticle(Article article) {
        userArticleMapper.deleteUserArticle(article);
    }

    @Override
    public void insertUserArticle(Article article) {
        userArticleMapper.insertUserArticle(article);
    }

    @Override
    public Article queryUserArticleById(int articleId) {
        return userArticleMapper.queryUserArticleById(articleId);
    }

    @Override
    public void updateUserArticle(Article article) {
        userArticleMapper.updateUserArticle(article);
    }
}
