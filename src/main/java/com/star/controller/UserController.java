package com.star.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.common.RedisService;
import com.star.model.User;
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

/**
 * Created by zhangnan on 16/7/23.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;


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
    public String login(User user,HttpServletResponse response){

//        ModelAndView modelAndView=new ModelAndView();
        User loginUser=userService.login(user);
        if (null==loginUser){
            //没有用户
            //modelAndView.addObject("error","用户不存在");
            return "error";
        }else {
            //存在用户
            //保存用户信息到cookie中
            Cookie cookie=new Cookie("user",loginUser.getUuid());
            cookie.setMaxAge(1296000);
            cookie.setPath("/");
            response.addCookie(cookie);
            ObjectMapper json = new ObjectMapper();
            String userJson = null;
            try {
                userJson = json.writeValueAsString(user);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            redisService.set(loginUser.getUuid(),userJson,1296000);
            //userService.updateUserLastLoginTime(user);
//            modelAndView.setViewName("redirect:/article/queryArticleList");
            return "true";
        }
    }


    /**
     * 退出登录
     */
    @RequestMapping(value = "/login_out",method = RequestMethod.GET)
    public ModelAndView loginOut(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        session.removeAttribute("user");
        Cookie[] cookies = request.getCookies();
       /* if (null==cookies){
            return "false";
        }*/
        for (Cookie cookie : cookies) {
            if ("user".equals(cookie.getName())){
                redisService.del(cookie.getValue());

            }
        }
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


    @ResponseBody
    @RequestMapping(value = "/queryUserIsLogin",method = RequestMethod.GET)
    public String queryUserIsLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (null==cookies){
            return "false";
        }
        for (Cookie cookie : cookies) {
            if ("user".equals(cookie.getName())){
                String loginUser = redisService.get(cookie.getValue());
                if (null!=loginUser){
                    return "true";
                }else {
                    return "false";
                }
            }
        }
        return "false";
    }

}
