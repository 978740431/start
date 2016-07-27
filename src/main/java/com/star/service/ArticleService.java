package com.star.service;


import com.star.model.Article;
import com.star.model.Question;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */
public interface ArticleService {
    List<Article> queryArticleList();

    void insertArticle(Article article);

    Article queryArticleById(int questionId);
}
