package mailing;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Map;
import java.util.Properties;

public class SendMail extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("ejrl123", "Shadowor1!@");				
	}
	public boolean emailSending(Map<String, String> map) {
		//메일발송 성공 플래그
		boolean sendOk = false;
		
		//정보를 담을 객체
		Properties p = new Properties();
		// SMTP 서버에 접속하기 위한 정보들
		p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP	 
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try {
			Authenticator auth = new MailSending();
			Session ses = Session.getInstance(p,auth);
			
			ses.setDebug(true);
			
			MimeMessage msg = new MimeMessage(ses);//,메일의 내용을
			msg.setSubject(map.get("subject"));//제목
			
			Address fromAddr = new InternetAddress(map.get("from"));
			msg.setFrom(fromAddr);//보내는 사람
			
			Address toAddr = new InternetAddress(map.get("to"));
			msg.addRecipient(Message.RecipientType.TO, toAddr);//받는 사람
			msg.setContent(map.get("content"), "text/html;charset=UTF-8");
			
			Transport.send(msg);//전송
			
			//발송성공시
			sendOk = true;
			
		} catch (Exception e) {
			sendOk = false;
			e.printStackTrace();
			
		}
		return sendOk;
	}

}
}
