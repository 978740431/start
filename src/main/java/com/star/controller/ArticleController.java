package com.star.controller;

import com.star.model.Article;
import com.star.model.Question;
import com.star.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */

@Controller
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    /**
     * 问题列表
     * @return
     */
    @RequestMapping(value = "/queryArticleList",method = RequestMethod.GET)
    public ModelAndView queryArticleList(){

        List<Question> articleList= articleService.queryArticleList();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleList");
        mv.addObject("articleList",articleList);

        return mv;
    }

    /**
     * 插入问题详情
     * @param article
     * @return
     */
    @RequestMapping(value = "/insertArticle",method = RequestMethod.POST)
    public String insertArticle(Article article){


        articleService.insertArticle(article);
        return null;
    }

    @RequestMapping(value = "/queryArticleDetail",method = RequestMethod.GET)
    public ModelAndView queryArticleDetail(@RequestParam int articleId){

        Article article= articleService.queryArticleById(articleId);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleDetail");
        mv.addObject("article",article);

        //mv.addObject("questionList", questionList);
        return mv;

    }




}
