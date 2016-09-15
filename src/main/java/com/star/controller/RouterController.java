package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangnan on 16/8/22.
 */
@Controller
public class RouterController {

    @RequestMapping(value = "/goEditPage",method = RequestMethod.GET)
    public ModelAndView goEditPage(){
        return new ModelAndView("redirect:/goEditPage2");
    }

    @RequestMapping(value = "/goEditPage2",method = RequestMethod.GET)
    public ModelAndView goEditPage2(){
        return new ModelAndView("/editPlug");
//        return new ModelAndView("/jsp/editPlug");
    }


}
