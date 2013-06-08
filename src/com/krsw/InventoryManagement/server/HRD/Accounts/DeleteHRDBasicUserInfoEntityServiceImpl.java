package com.krsw.InventoryManagement.server.HRD.Accounts;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Accounts.DeleteHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class DeleteHRDBasicUserInfoEntityServiceImpl extends RemoteServiceServlet implements DeleteHRDBasicUserInfoEntityService{
	public void DeleteHRDBasicUserInfoEntity(Long id){
		HRDBasicUserInfoEntity basicuserinfo = new HRDBasicUserInfoEntity(id);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.deletePersistent(pm.getObjectById(basicuserinfo));
		}finally{
			pm.close();
		}
	}
}
