package com.krsw.InventoryManagement.client.HRD.Logging;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AddHRDLoggingUserInfoEntityService")
public interface AddHRDLoggingUserInfoEntityService extends RemoteService{
	void AddHRDLoggingUserInfoEntity(Long ID, String STATUS, String MESSAGE, String TYPING_LOGINID,
			String TYPING_LOGINPASSWORD, String CREATEDATE, String RESERVEAREA01_STRING, String RESERVEAREA02_STRING);
}
