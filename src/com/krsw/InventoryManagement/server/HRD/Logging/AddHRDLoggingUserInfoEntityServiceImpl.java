package com.krsw.InventoryManagement.server.HRD.Logging;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Logging.AddHRDLoggingUserInfoEntityService;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class AddHRDLoggingUserInfoEntityServiceImpl extends RemoteServiceServlet implements AddHRDLoggingUserInfoEntityService{
	public void AddHRDLoggingUserInfoEntity(Long ID, String STATUS, String MESSAGE, String TYPING_LOGINID,
			String TYPING_LOGINPASSWORD, String CREATEDATE, String RESERVEAREA01_STRING, String RESERVEAREA02_STRING) {
		HRDLoggingUserInfoEntity loginfo = new HRDLoggingUserInfoEntity(ID, STATUS, MESSAGE, TYPING_LOGINID, TYPING_LOGINPASSWORD, CREATEDATE, RESERVEAREA01_STRING, RESERVEAREA02_STRING);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(loginfo);
		}finally{
			pm.close();
		}
	}
}
