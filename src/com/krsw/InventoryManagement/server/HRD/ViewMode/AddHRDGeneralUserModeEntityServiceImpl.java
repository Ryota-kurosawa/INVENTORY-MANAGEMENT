package com.krsw.InventoryManagement.server.HRD.ViewMode;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.ViewMode.AddHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.server.PMF;

public class AddHRDGeneralUserModeEntityServiceImpl extends RemoteServiceServlet implements AddHRDGeneralUserModeEntityService{
	public void AddHRDGeneralUserModeEntity(Long id, String status,
			String statusLabel, String lastSwitched, String createDate,
			String updateDate, String reserveArea01_String,
			String reserveArea02_String) {
		HRDGeneralUserModeEntity usermode = new HRDGeneralUserModeEntity(id, status, statusLabel, lastSwitched, createDate, updateDate, reserveArea01_String, reserveArea02_String);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(usermode);
		}finally{
			pm.close();
		}
	}
}
