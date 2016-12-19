package com.star.interceptor;

import com.star.model.User;
import com.star.model.VisitRecord;
import com.star.service.VisitRecordInterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by zhangnan on 16/7/27.
 */
public class VisitRecordInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private VisitRecordInterceptorService visitRecordInterceptorService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        String path = request.getServletPath();
        try {
            if(path.matches(".*/((login)|(logout)|(plugins)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*")){
                return true;
            }else {
                //System.out.println("wojinlaile ");
                String ip = request.getHeader("x-forwarded-for");
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("Proxy-Client-IP");
                }
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("WL-Proxy-Client-IP");
                }
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getRemoteAddr();
                }


                User user = (User) request.getSession().getAttribute("user");
                //System.out.println(username);

                //获取到/test/index.jsp （服务路径名）
                //System.out.println("aaa" + request.getServletPath());
                //获取到/epet/test/index.jsp（请求地址）
                //System.out.println("bb" + request.getRequestURI());
                VisitRecord visitRecord = new VisitRecord();
                if (request.getRequestURI().startsWith("/")) {
                    visitRecord.setRequestUrl(request.getRequestURI().substring(1));
                } else {
                    visitRecord.setRequestUrl(request.getRequestURI());
                }
                visitRecord.setIp(ip);
                visitRecord.setUsername(null==user?"":user.getUsername());
                visitRecord.setVisitTime(new Date());
                visitRecordInterceptorService.saveVisitRecord(visitRecord);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }
}
