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
 * �����ʼ����ࡣ
 * @author kING
 *
 */
public class MailUtils {
	//to�����ռ��ˣ�code���Ǽ�����
	public static void sendMail(String to,String code) throws AddressException, MessagingException {
		Properties props = new Properties();
		 // ָ����֤Ϊtrue
		 props.setProperty("mail.smtp.auth", "true");
		 props.put("mail.transport.protocol", "smtp");// ����Э��        
		 props.put("mail.smtp.host", "smtp.qq.com");// ������        
		 props.put("mail.smtp.port", 465);// �˿ں�        
		 props.put("mail.smtp.auth", "true");        
		 props.put("mail.smtp.ssl.enable", "true");//�����Ƿ�ʹ��ssl��ȫ����  ---һ�㶼ʹ��        
		 props.put("mail.debug", "true");//�����Ƿ���ʾdebug��Ϣ  true ���ڿ���̨��ʾ�����Ϣ        
		 Session session = Session.getInstance(props);        
		// ��ȡ�ʼ�����        
		Message message = new MimeMessage(session);        
		//���÷����������ַ       
		 message.setFrom(new InternetAddress("1508245097@qq.com"));       
		 //�����ռ��˵�ַ        
		 message.setRecipients(RecipientType.TO,new InternetAddress[] { new InternetAddress(to) });       
		 //�����ʼ�����        
		message.setSubject("����Ӣ��С���һ���ٷ������ʼ�");        
		//�����ʼ�����        
		message.setContent("<h1>Ӣ��С���һ���ٷ������ʼ�!���������ɼ������</h1><h3><a href = 'http://219.226.133.75:8080/TownOfEnglish/user_active.action?code="+code+"'>http:219.226.133.75:8080/TownOfEnglish/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		 //�õ��ʲ����
		Transport transport = session.getTransport();
		//�����Լ��������˻�
		transport.connect("1508245097@qq.com", "itullnynmstebafa");//����Ϊ�ղŵõ�����Ȩ�� 
		//�����ʼ� 
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
