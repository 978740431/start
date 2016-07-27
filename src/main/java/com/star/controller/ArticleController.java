package com.star.controller;

import com.star.model.Article;
import com.star.model.Question;
import com.star.model.User;
import com.star.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * 文章列表
     * @return
     */
    @RequestMapping(value = "/queryArticleList",method = RequestMethod.GET)
    public ModelAndView queryArticleList(){

        List<Article> articleList= articleService.queryArticleList();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleList");
        mv.addObject("articleList",articleList);
        return mv;
    }

    /**
     * 插入文章详情
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertArticle",method = RequestMethod.POST)
    public String insertArticle(Article article,HttpServletRequest request){

        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        if (null==user){
            return "error";
        }
        article.setUid(user.getId());
        articleService.insertArticle(article);
        return "success";
    }

    /**
     * 查询文章详情
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/queryArticleDetail",method = RequestMethod.GET)
    public ModelAndView queryArticleDetail(@RequestParam int articleId){

        Article article= articleService.queryArticleById(articleId);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleDetail");
        mv.addObject("article",article);
        return mv;

    }




}
