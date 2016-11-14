package com.nome.util;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.nome.po.Push;

public class SendEmail {

    public static final String HOST = "smtp.163.com";	//邮箱服务器的主机
    public static final String PROTOCOL = "smtp";   //发送邮箱的协议
    public static final int PORT = 25;		//邮箱服务器的端口号
    public static final String FROM = "15626186248@163.com";//发件人的email
    public static final String PWD = "junjie01";//发件人密码

    /**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.host","smtp.163.com");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth" , true);

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }
        };
        Session session = Session.getDefaultInstance(props,authenticator);
        session.getDebug();
        return session;
    }

    
    /**
     * 发送纯文本的邮件
     * @param toEmail	收件人
     * @param content	内容
     */
    public static void send(String toEmail , String content ,String password,String name) {
        Session session = getSession();
        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("账号激活邮箱");
            msg.setSentDate(new Date());
            msg.setContent(name + "用户你好，" +content + "<a href=\"http://localhost:8080/user/validateRegister?email=" + toEmail + "&validate=" + password + "\">点击激活</a>", "text/html;charset=utf-8");
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
    /**
     * 发送纯文本的推送文本
     * @param toEmail	收件人
     * @param content	内容
     */
    public static void sendPush(String toEmail,String name,Push push) {
        Session session = getSession();
        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);
            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("降价提醒");
            msg.setSentDate(new Date());
            msg.setContent("你好，您订阅的" + name + "\n 已经降到 " + push.getCurPrice() + ",比您的最低价:" + push.getLowestPrice() + "低" , "text/html;charset=utf-8");
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
    /**
     * 发送纯文本的邮件
     * @param toEmail	收件人
     * @param content	内容
     */
    public static void sendFindPassword(String toEmail,String validate) {
        Session session = getSession();
        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);
            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("更改密码");
            msg.setSentDate(new Date());
            msg.setContent("你好，您修改密码的验证码为" + validate + ",请在48小时内进行修改 ", "text/html;charset=utf-8");
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
    
    /**
     * 发送带图片的邮件
     * @param toEmail
     * @param content
     */
    public static void sendImage(String toEmail, String content) {
    	
    	Session session = getSession();
        try {
            // Instantiate a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("账号激活邮箱");
            msg.setSentDate(new Date());
            
             //创建邮件的正文  
            MimeBodyPart text = new MimeBodyPart();  
             //setContent(“邮件的正文内容”,”设置邮件内容的编码方式”)  
            text.setContent("此邮件为系统自动发送<img src='cid:a'>",  
                    "text/html;charset=gb2312");  
            
         // 创建图片  
            MimeBodyPart img = new MimeBodyPart();  
            DataHandler dh = new DataHandler(new FileDataSource("F://picture//1.jpg"));//图片路径  
            img.setDataHandler(dh);  
            img.setContentID("a");  
            MimeMultipart mm = new MimeMultipart();  
            mm.addBodyPart(text);  
            mm.addBodyPart(img);  
            mm.setSubType("related");// 设置正文与图片之间的关系  
            
            // 图班与正文的 body  
            MimeBodyPart all = new MimeBodyPart();  
            all.setContent(mm);  
      
            msg.setContent(mm);  
            msg.saveChanges(); // 保存修改
            //Send the message
            Transport ts = session.getTransport();
            ts.connect(HOST, FROM, PWD);
            ts.sendMessage(msg, msg.getAllRecipients());
    		ts.close();
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
}