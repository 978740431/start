package com.star.service;

import com.star.dao.UserArticleDao;
import com.star.model.Article;
import com.star.model.Question;
import com.star.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangnan on 16/7/24.
 */
@Service
public class UserArticleServiceImpl implements UserArticleService{


    @Resource
    private UserArticleDao userArticleDao;
    @Override
    public List<Article> queryUserArticleList(User user) {
        return userArticleDao.queryUserArticleList(user);
    }

    @Override
    public void updateUserArticle(Article article) {
//        userArticleDao.deleteUserArticle(article);
//        Article article1 = userArticleDao.queryUserArticleById(article.getId());
//        article.setReadTimes(article1.getReadTimes());
        userArticleDao.updateUserArticle(article);
    }

    @Override
    public Article queryUserArticleById(int articleId) {
        return userArticleDao.queryUserArticleById(articleId);
    }
}
