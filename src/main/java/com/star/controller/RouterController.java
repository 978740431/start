package com.star.controller;

import com.star.model.Article;
import com.star.service.UserArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zhangnan on 16/8/22.
 */
@Controller
public class RouterController {

    @Resource
    private UserArticleService userArticleService;


    @RequestMapping(value = "/goEditPage",method = RequestMethod.GET)
    public ModelAndView goEditPage(){
        return new ModelAndView("redirect:/goEditPage2");
    }

    @RequestMapping(value = "/goEditUserArticlePlug",method = RequestMethod.GET)
    public ModelAndView goEditUserArticlePlug(int id){
        Article article = userArticleService.queryUserArticleById(id);
        ModelAndView mv = new ModelAndView("editUserArticlePlug");
        mv.addObject("article",article);
        return mv;
    }

    @RequestMapping(value = "/goEditPage2",method = RequestMethod.GET)
    public ModelAndView goEditPage2(){
        return new ModelAndView("/editPlug");
//        return new ModelAndView("/jsp/editPlug");
    }


}
