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
        /*try {
            SendEmail.sendWithAttach("带附件的邮件测试182", "978740431@qq.com", "尊敬的${docName}医生：<br />您好！<br />欢迎您加入哮喘管家。您已经开通了哮喘管家的医生端权限，现在您可以使用智能设备及哮喘管家APP来管理您的病人。<br />您可以通过电脑、IPAD或手机登录以下网址<br />网址：med.asthmanager.com<br />登陆账号：${account}<br />初始密码：${registerPasswd}<br /><br />医生端的主要功能：<br /><br />1.查看患者汇总信息<br />2.查看需随访患者列表并进行远程随<br />3.高危患者预警<br />4.患者详情查阅及信息推送<br />5.回复患者咨询<br />6.审核患者申请<br />7.患者管理收入账户查询<br />以下是关于医生端的视频使用说明，请点击查看XXX<br />" +
                    "立即下载哮喘管家医生版APP，更好的管理您的患者。<img src=\"http://static.healthcare-inc.com/two_code/WechatIMG247.jpg\" style=\"width: 10%;\"alt='如未显示图片,请查看邮件提示是否显示图片按钮'><br />最后，衷心感谢您对哮喘管家团队的认可，使用过程中，若有任何问题，请拨打客服热线400-8217-403<br />Thanks & Regards<br />" +
                    "<br />哮喘管家", null);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return mv;
    }
}
