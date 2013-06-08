package com.krsw.InventoryManagement.client.Mail;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("EmailService")
public interface EmailService extends RemoteService{
	enum COMMAND{
		NORMAL,
		BCC,
		ATTACHE
	};
	void sendMail(String mailAddress, String sendAddress, String name, COMMAND command, String subject, String msg);
}
