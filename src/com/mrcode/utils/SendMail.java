package com.mrcode.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的类
 * @author 羽中
 *
 */
public class SendMail {
	public static void sendMail(String host, final String username, String from,
			final String password, String to, String subject, String context) {
        boolean isSSL = true;
        boolean isAuth = true;
 
        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", isSSL);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465); //默认使用465号端口
        props.put("mail.smtp.auth", isAuth);
 
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(context);
 
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("发送完毕!");
    }

	public static void sendMail(String host, int port, final String username, String from,
			final String password, String to, String subject, String context) {
        boolean isSSL = true;
        boolean isAuth = true;
 
        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", isSSL);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", isAuth);
 
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(context);
 
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("发送完毕!");
    }
	
	public static void sendMail(String to, String subject, String context) {
		String host = "smtp.163.com"; //发送邮件的host,如163邮箱的是smtp.163.com
		int port = 465;//发送端口号
		final String username = "mayingdong999@163.com";//发送者的用户名(username和from设置成相同的即可)
		String from = "mayingdong999@163.com";//发送者邮箱
		final String password = "";//发送者的邮箱密码
		
		SendMail.sendMail(host, port, username, from, password, to, subject, context);
	}
	/*
	public static void main(String args[]) {
		String host = "smtp.163.com"; //发送邮件的host,如163邮箱的是smtp.163.com
		int port = 465;//发送端口号
		final String username = "mayingdong999@163.com";//发送者的用户名(username和from设置成相同的即可)
		String from = "mayingdong999@163.com";//发送者邮箱
		final String password = "";//发送者的邮箱密码
		String to = "1353795848@qq.com";//收件人的邮箱
		String subject = "主题测试";
		String context = "主题测试123456789";
		SendMail.sendMail(host, port, username, from, password, to, subject, context);
	}
	*/
}