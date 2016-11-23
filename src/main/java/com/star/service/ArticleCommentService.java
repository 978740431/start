package com.star.service;

import com.star.model.ArticleComment;

import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 */
public interface ArticleCommentService {


    public void addArticleComment(ArticleComment articleComment);


    public List<ArticleComment> queryArticleCommentListByArticleId(int articleId);

}
