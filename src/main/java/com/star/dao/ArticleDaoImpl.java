package com.star.dao;

import com.star.mapper.ArticleMapper;
import com.star.model.Article;
import com.star.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {


    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> queryArticleList() {
        return articleMapper.queryArticleList();
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public Article queryArticleById(int articleId) {
        return articleMapper.queryArticleById(articleId);
    }

    @Override
    public void updateReadTimesById(int articleId) {
        articleMapper.updateReadTimesById(articleId);
    }
}
