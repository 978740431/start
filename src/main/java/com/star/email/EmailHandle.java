package com.star.email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * 本程序用java来实现Email的发送， 所用到的协议为：smtp
 * <p>Company:  疯狂的IT人</p>
 * time:2013-04-05
 *
 * @author www.crazyiter.com
 * @version 1.0
 * @date
 */
public class EmailHandle {

    private MimeMessage mimeMsg; //邮件对象

    private Session session; //发送邮件的Session会话

    private Properties props;//邮件发送时的一些配置信息的一个属性对象

    private String sendUserName; //发件人的用户名

    private String sendUserPass; //发件人密码

    private Multipart mp;//附件添加的组件

    private String nickName;

    private int port;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private List files = new LinkedList();//存放附件文件

    public EmailHandle(String smtp) {
        sendUserName = "";
        sendUserPass = "";
        setSmtpHost(smtp);// 设置邮件服务器
        createMimeMessage(); // 创建邮件
    }

    public void setSmtpHost(String hostName) {
        if (props == null)
            props = System.getProperties();
        props.put("mail.smtp.host", hostName);
    }

    public void setPort(int port) {
        if (props == null)
            props = System.getProperties();
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
    }


    public boolean createMimeMessage() {
        try {
            // 用props对象来创建并初始化session对象
            session = Session.getDefaultInstance(props, null);
        } catch (Exception e) {
            System.err.println("获取邮件会话对象时发生错误！" + e);
            return false;
        }
        try {
            mimeMsg = new MimeMessage(session);  // 用session对象来创建并初始化邮件对象
            mp = new MimeMultipart();// 生成附件组件的实例
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 设置SMTP的身份认证
     */
    public void setNeedAuth(boolean need) {
        if (props == null)
            props = System.getProperties();
        if (need) {
            props.put("mail.smtp.auth", "true");
        } else {
            props.put("mail.smtp.auth", "false");

        }
    }

    /**
     * 进行用户身份验证时，设置用户名和密码
     */
    public void setNamePass(String name, String pass) {
        sendUserName = name;
        sendUserPass = pass;
    }

    /**
     * 设置邮件主题
     *
     * @param mailSubject
     * @return
     */
    public boolean setSubject(String mailSubject) {
        try {
            mimeMsg.setSubject(mailSubject);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 设置邮件内容,并设置其为文本格式或HTML文件格式，编码方式为UTF-8
     *
     * @param mailBody
     * @return
     */
    public boolean setBody(String mailBody) {
        try {
            BodyPart bp = new MimeBodyPart();
            bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody, "text/html;charset=UTF-8");
            // 在组件上添加邮件文本
            mp.addBodyPart(bp);
        } catch (Exception e) {
            System.err.println("设置邮件正文时发生错误！" + e);
            return false;
        }
        return true;
    }

    /**
     * 增加发送附件
     *
     * @param filename 邮件附件的地址，只能是本机地址而不能是网络地址，否则抛出异常
     * @return
     */
    public boolean addFileAffix(String filename) {
        try {
            BodyPart bp = new MimeBodyPart();
            FileDataSource fileds = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(fileds));
            bp.setFileName(MimeUtility.encodeText(fileds.getName(), "utf-8", null));  // 解决附件名称乱码
            mp.addBodyPart(bp);// 添加附件
            files.add(fileds);
        } catch (Exception e) {
            System.err.println("增加邮件附件：" + filename + "发生错误！" + e);
            return false;
        }
        return true;
    }

    public boolean delFileAffix() {
        try {
            FileDataSource fileds = null;
            for (Iterator it = files.iterator(); it.hasNext(); ) {
                fileds = (FileDataSource) it.next();
                if (fileds != null && fileds.getFile() != null) {
                    fileds.getFile().delete();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 设置发件人地址
     *
     * @param from 发件人地址
     * @return
     */
    public boolean setFrom(String from) {
        try {
            if (nickName != null && !nickName.isEmpty()) {
                String nick = javax.mail.internet.MimeUtility.encodeText(nickName);
                mimeMsg.setFrom(new InternetAddress(nick + " <" + from + ">"));
            } else {
                mimeMsg.setFrom(new InternetAddress(from));
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 设置收件人地址
     *
     * @return
     */
    public boolean setTo(String to) {
        if (to == null)
            return false;
        try {
            mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 发送附件
     *
     * @param copyto
     * @return
     */
    public boolean setCopyTo(String copyto) {
        if (copyto == null)
            return false;
        try {
            mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(copyto));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void setMp(Multipart mp) {
        this.mp = mp;
    }

    /**
     * 发送邮件
     *
     * @return
     */
    public boolean sendEmail() throws Exception {
        mimeMsg.setContent(mp);
        //设置收件人,以后app可以设置多个收件人,定时发送等,状态的查看是通过轮询后台的接口,并没有特殊的
        // 接口来返回发送状态////////
        Address[] addresses = new Address[1];
        InternetAddress internetAddress = new InternetAddress("731306156@qq.com");
        addresses[0] = internetAddress;
        //mimeMsg.setFrom(new InternetAddress("chinese_shuomao"));
        mimeMsg.setReplyTo(addresses);

        //修改结束
        mimeMsg.saveChanges();
        Session mailSession = Session.getInstance(props, null);
        Transport transport = mailSession.getTransport("smtp");
        // 连接邮件服务器并进行身份验证
        transport.connect((String) props.get("mail.smtp.host"), Integer.parseInt(props.get("mail.smtp.port").toString()), sendUserName, sendUserPass);

        // 发送邮件
        transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
        transport.close();
        return true;
    }

    public int getPort() {
        return port;
    }

}
