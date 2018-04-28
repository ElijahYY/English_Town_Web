package cn.soul.Town.util;

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
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件的类。
 * @author kING
 *
 */
public class MailUtils {
	//to就是收件人，code就是激活码
	public static void sendMail(String to,String code) throws AddressException, MessagingException {
		Properties props = new Properties();
		 // 指定验证为true
		 props.setProperty("mail.smtp.auth", "true");
		 props.put("mail.transport.protocol", "smtp");// 连接协议        
		 props.put("mail.smtp.host", "smtp.qq.com");// 主机名        
		 props.put("mail.smtp.port", 465);// 端口号        
		 props.put("mail.smtp.auth", "true");        
		 props.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        
		 props.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        
		 Session session = Session.getInstance(props);        
		// 获取邮件对象        
		Message message = new MimeMessage(session);        
		//设置发件人邮箱地址       
		 message.setFrom(new InternetAddress("1508245097@qq.com"));       
		 //设置收件人地址        
		 message.setRecipients(RecipientType.TO,new InternetAddress[] { new InternetAddress(to) });       
		 //设置邮件标题        
		message.setSubject("来自英语小镇的一个官方激活邮件");        
		//设置邮件内容        
		message.setContent("<h1>英语小镇的一个官方激活邮件!点此链接完成激活操作</h1><h3><a href = 'http://219.226.133.75:8080/TownOfEnglish/user_active.action?code="+code+"'>http:219.226.133.75:8080/TownOfEnglish/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		 //得到邮差对象
		Transport transport = session.getTransport();
		//连接自己的邮箱账户
		transport.connect("1508245097@qq.com", "itullnynmstebafa");//密码为刚才得到的授权码 
		//发送邮件 
		transport.sendMessage(message,message.getAllRecipients());    
		
	}
	public static void main(String args[]) throws AddressException, MessagingException {
		int i=0;
		sendMail("1341511419@qq.com",""+i++);
		while(true) {
			sendMail("1341511419@qq.com",""+i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
