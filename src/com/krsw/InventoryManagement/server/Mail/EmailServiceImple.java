package com.krsw.InventoryManagement.server.Mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.Mail.EmailService;

@SuppressWarnings("serial")
public class EmailServiceImple extends RemoteServiceServlet implements EmailService{

	public void sendMail(String mailAddress, String sendAddress, String name, COMMAND command, String subject, String msg) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try{
			InternetAddress address = new InternetAddress(mailAddress, name, "iso-2022-jp");
			InternetAddress sendaddress = new InternetAddress(sendAddress, "", "iso-2022-jp");
			Message message = null;
			switch(command){
			case NORMAL:
				message = createMessage(session, address, sendaddress, subject, msg);
				break;
			case BCC:
				message = createMessageAsBCC(session, address, sendaddress, address, subject, msg);
				break;
			case ATTACHE:
				message = createMessage(session, address, sendaddress, subject, msg);
				break;
				default:
			}
			Transport.send(message);
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}catch(MessagingException e){
			e.printStackTrace();
		}
	}
	private Message createMessage(Session session, InternetAddress mailaddress, InternetAddress sendaddress, String subject, String msg) throws MessagingException {


		MimeMessage message = new MimeMessage(session);
		message.setFrom(mailaddress);//送信元アドレス
		message.addRecipient(Message.RecipientType.TO, sendaddress);//あて先アドレス
		message.setSubject(subject);//件名
		message.setText(msg);//本文
		return message;
	}

	private Message createMessageAsBCC(Session session, InternetAddress mailaddress, InternetAddress sendaddress, InternetAddress BCCaddress, String subject, String msg) throws MessagingException {

		MimeMessage message = new MimeMessage(session);
		message.setFrom(mailaddress);//送信元アドレス
		message.addRecipient(Message.RecipientType.TO, sendaddress);//あて先アドレス
		message.addRecipient(Message.RecipientType.BCC, BCCaddress);//BCCアドレス
		message.setSubject(subject);//件名
		message.setText(msg);//本文
		return message;
	}
}
