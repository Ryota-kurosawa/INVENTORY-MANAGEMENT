package com.krsw.InventoryManagement.client.Mail;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.krsw.InventoryManagement.client.Mail.EmailService.COMMAND;

public interface EmailServiceAsync {
	void sendMail(String mailAddress, String sendAddress, String name, COMMAND command, String subject, String msg, AsyncCallback callback);
}
