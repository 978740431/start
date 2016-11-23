package com.star.service;

import com.star.dao.ArticleDao;
import com.star.model.Article;
import com.star.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by admin on 2016/6/18.
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> queryArticleList() {
        return articleDao.queryArticleList();
    }

    @Override
    public void insertArticle(Article article) {
        articleDao.insertArticle(article);
    }

    @Override
    public Article queryArticleById(int articleId) {
        return articleDao.queryArticleById(articleId);
    }

    @Override
    public void updateReadTimesById(int articleId) {
        articleDao.updateReadTimesById(articleId);
    }
}
