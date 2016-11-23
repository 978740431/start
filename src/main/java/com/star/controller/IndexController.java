package com.star.controller;

import com.star.model.Article;
import com.star.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zhangnan on 16/11/23.
 */
@Controller
public class IndexController {


    @Autowired
    private ArticleService articleService;

    /**
     * 文章列表
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        List<Article> articleList= articleService.queryArticleList();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleList");
        mv.addObject("articleList",articleList);
        return mv;
    }
}
