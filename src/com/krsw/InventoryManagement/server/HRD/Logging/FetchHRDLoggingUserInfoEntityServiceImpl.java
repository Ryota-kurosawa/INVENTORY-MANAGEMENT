package com.krsw.InventoryManagement.server.HRD.Logging;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Logging.FetchHRDLoggingUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Logging.SerializeHRDLoggingUserInfoEntity;
import com.krsw.InventoryManagement.server.PMF;
import com.krsw.InventoryManagement.server.HRD.Location.HRDLocationInfoEntity;

@SuppressWarnings("serial")
public class FetchHRDLoggingUserInfoEntityServiceImpl extends RemoteServiceServlet implements FetchHRDLoggingUserInfoEntityService{
	@SuppressWarnings("unchecked")
	public List<SerializeHRDLoggingUserInfoEntity> getRange(int start, int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDLocationInfoEntity.class.getName();
		List<HRDLoggingUserInfoEntity> list = (List<HRDLoggingUserInfoEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDLoggingUserInfoEntity> listsserializedata = new ArrayList<SerializeHRDLoggingUserInfoEntity>();
		for(HRDLoggingUserInfoEntity loginfo : list){
			Long id = loginfo.getId();
			String status = loginfo.getStatus();
			String message = loginfo.getMessage();
			String typeloginid = loginfo.getTyping_LoginId();
			String typeloginpassword = loginfo.getTyping_LoginPassword();
			String createdate = loginfo.getCreateDate();
			String reservearea01_string = loginfo.getReserveArea01_String();
			String reservearea02_string = loginfo.getReserveArea02_String();
			listsserializedata.add(new SerializeHRDLoggingUserInfoEntity(id, status, message, typeloginid, typeloginpassword, createdate, reservearea01_string, reservearea02_string));
		}
		return listsserializedata;
	}

}
