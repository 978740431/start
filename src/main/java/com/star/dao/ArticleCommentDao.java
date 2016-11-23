package com.star.dao;

import com.star.model.ArticleComment;

import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 */
public interface ArticleCommentDao {

    public List<ArticleComment> queryArticleCommentListByArticleId(int articleId);


    public void addArticleComment(ArticleComment articleComment);
}
