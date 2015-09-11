package email;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDriver {
	private String to;
	public EmailDriver(){
		
	}
	
	public EmailDriver(String to) {
		this.to = to;
		Properties props = new Properties();
		
		props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable","true");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("team4softengg@gmail.com", "softengg1");
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		
		Message msg = new MimeMessage(session);
		
		try {
			msg.setSubject("RIDESHARE - Validate Your Account");
			msg.setText("Please click this link: http://www.rideShare.com/verify?user=someone"
					+ "\n\nTest Email from RideShare Web Interface");
			msg.setFrom(new InternetAddress("team4softengg@gmail.com", "Team4"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress("sujasghiya@gmail.com"));
			
			Transport.send(msg);
		} catch (MessagingException | UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
	}

}

