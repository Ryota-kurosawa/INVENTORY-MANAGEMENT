package com.krsw.InventoryManagement.server.HRD.Accounts;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Accounts.AddHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class AddHRDBasicUserInfoEntityServiceImpl extends RemoteServiceServlet implements AddHRDBasicUserInfoEntityService{
	public void AddHRDBasicUserInfoEntity(Long id, String lastName,
			String firstName, String section, String authority, String loginId,
			String loginPassword, String email, Boolean enable,
			String createDate, String updateDate, String reserveArea01_String,
			String reserveArea02_String) {
		HRDBasicUserInfoEntity basicuserinfo = new HRDBasicUserInfoEntity(id, lastName, firstName, section, authority, loginId, loginPassword, email,
				enable, createDate, updateDate, reserveArea01_String, reserveArea02_String);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(basicuserinfo);
		}finally{
			pm.close();
		}
	}
}
