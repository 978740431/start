package com.star.controller;

import com.star.model.Question;
import com.star.model.User;
import com.star.service.ArticleService;
import com.star.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zhangnan on 16/7/23.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 跳转注册页面
     */
    @RequestMapping(value = "/goRegister",method = RequestMethod.GET)
    public ModelAndView goRegister(){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    /**
     * 跳转登陆页面
     */
    @RequestMapping(value = "/goLogin",method = RequestMethod.GET)
    public ModelAndView goLogin(){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /**
     * 注册
     */
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(User user){

        boolean result = userService.register(user);
        return result;
    }



    /**
     * 登陆
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(User user,HttpServletRequest request){

        User loginUser=userService.login(user);
        if (null==loginUser){
            //没有用户
            return false;
        }else {
            //存在用户
            //保存用户信息到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",loginUser);
            session.setMaxInactiveInterval(1296000);
            return true;
        }
    }


    /**
     * 退出登录
     */
    @RequestMapping(value = "/login_out",method = RequestMethod.GET)
    public ModelAndView loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return new ModelAndView("redirect:/article/queryArticleList");
    }


    /**
     * 查询用户是否存在
     * 用户注册时使用
     */
    @ResponseBody
    @RequestMapping(value = "/queryUserIsExist",method = RequestMethod.POST)
    public Object queryUserIsExist(User user) {

        User userIsExist = userService.queryUserIsExist(user);
        if (null == userIsExist) {
            return "false";
        } else {
            return "true";
        }
    }


    /**
     * 查询用户的文章
     */

}
