package com.star.email;

/**
 * @Author 张楠
 * @Date 2017/5/29 下午6:20
 * @Describe 发送邮件
 * @Version V1
 * @since 1.0
 */
public class SendEmail {


    /***以后需要两个参数：接收方地址 、 内容***/
    public static void sendWithAttach(String subject, String toaddress, String content, String[] attach) throws Exception {
        System.out.println("我已进入sendEmail==================================");
        //EmailHandle emailHandle = new EmailHandle("smtp-relay.gmail.com");
        EmailHandle emailHandle = new EmailHandle("smtp.gmail.com");
        emailHandle.setNickName("上海朔茂");
        emailHandle.setFrom("731306156@qq.com");
        //emailHandle.setFrom("zhangnan@goodinvoice.com");
        //emailHandle.setFrom("zn978740431@goodinvoice.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject(subject);
        emailHandle.setBody(content);
        emailHandle.setTo(toaddress);
        emailHandle.setPort(465);

        // 添加附件
        if (null != attach && attach.length > 0) {
            for (String filename : attach) {
                emailHandle.addFileAffix(filename);
            }
        }
        emailHandle.setNickName("张楠发送");
//      emailHandle.addFileAffix("D:/myself/help/txt/java环境变量.txt");// 附件文件路径
        emailHandle.setNamePass("zn978740431@gmail.com", "qajrgddqzxxvengf");
        //emailHandle.setNamePass("zhangnan@goodinvoice.com", "wo1wusuoyou");
        System.out.println("我要开始发送了.................");
        emailHandle.sendEmail();
    }


    public static void main(String[] args) throws Exception {
        sendWithAttach("带附件的邮件测试182", "978740431@qq.com", "尊敬的${docName}医生：", null);

    }
}
