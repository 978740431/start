package com.star.dao;

import com.star.mapper.ArticleCommentMapper;
import com.star.model.ArticleComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 */
@Repository("articleDaoComment")
public class ArticleCommentDaoImpl implements ArticleCommentDao{


    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    public List<ArticleComment> queryArticleCommentListByArticleId(int articleId){
        return articleCommentMapper.queryArticleCommentListByArticleId(articleId);
    }

    public void addArticleComment(ArticleComment articleComment){
        articleCommentMapper.addArticleComment(articleComment);
    }
}
