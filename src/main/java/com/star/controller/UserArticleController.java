package com.star.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.common.RedisService;
import com.star.model.Article;
import com.star.model.User;
import com.star.service.UserArticleService;
import com.star.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangnan on 16/7/24.
 */

@Controller
@RequestMapping("/user_article")
public class UserArticleController {


    @Resource
    private UserArticleService userArticleService;
    @Resource
    private UserService userService;
    @Resource
    private RedisService redisService;


    /**
     * 用户文章列表
     * @return
     */
    @RequestMapping(value = "/queryUserArticleList",method = RequestMethod.GET)
    public ModelAndView queryUserArticleList(HttpServletRequest request){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleList");
        ObjectMapper mapper = new ObjectMapper();
        Cookie[] cookies = request.getCookies();
        User user=null;
        for (Cookie cookie : cookies) {
            if ("user".equals(cookie.getName())){
                String loginUser = redisService.get(cookie.getValue());
                try {
                    user = mapper.readValue(loginUser, new TypeReference<User>() {});
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (null==user){
            mv.addObject("error","用户不存在");
        }
        User queryUser=userService.queryUserByUserAndUUID(user);
        if (null==queryUser){
            mv.addObject("error","用户非法");
        }
        List<Article> articleList= userArticleService.queryUserArticleList(user);
        mv.addObject("articleList",articleList);
        return mv;
    }


    /**
     * 用户修改文章
     */
    /**
     * 插入文章详情
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserArticle",method = RequestMethod.POST)
    public String updateUserArticle(Article article,HttpServletRequest request){

        HttpSession session = request.getSession();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleList");
        User user=(User)session.getAttribute("user");
        if (null==user){
            mv.addObject("error","用户不存在");
        }
        User queryUser=userService.queryUserByUserAndUUID(user);
        if (null==queryUser){
            mv.addObject("error","用户非法");
        }
        article.setUid(queryUser.getId());
        //修改文章
        userArticleService.updateUserArticle(article);
        return "success";
    }

    /**
     * 查询文章详情
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/queryArticleDetail",method = RequestMethod.GET)
    public ModelAndView queryArticleDetail(@RequestParam int articleId){

        Article article= userArticleService.queryUserArticleById(articleId);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("articleDetail");
        mv.addObject("article",article);
        return mv;

    }



}
