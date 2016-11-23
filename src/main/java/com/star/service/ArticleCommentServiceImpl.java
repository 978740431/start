package com.star.service;

import com.star.dao.ArticleCommentDao;
import com.star.model.ArticleComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 */
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Resource
    private ArticleCommentDao articleCommentDao;

    @Override
    public void addArticleComment(ArticleComment articleComment) {
        articleCommentDao.addArticleComment(articleComment);
    }

    @Override
    public List<ArticleComment> queryArticleCommentListByArticleId(int articleId) {
        return articleCommentDao.queryArticleCommentListByArticleId(articleId);
    }
}


