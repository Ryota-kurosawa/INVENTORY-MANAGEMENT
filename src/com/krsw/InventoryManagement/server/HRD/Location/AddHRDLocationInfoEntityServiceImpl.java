package com.krsw.InventoryManagement.server.HRD.Location;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Location.AddHRDLocationInfoEntityService;
import com.krsw.InventoryManagement.server.PMF;

public class AddHRDLocationInfoEntityServiceImpl extends RemoteServiceServlet implements AddHRDLocationInfoEntityService{

	public void AddHRDLocationInfoEntity(Long id, Integer number, String name,
			String address, Boolean enable, String createDate,
			String updateDate, String reserveArea01_String,
			String reserveArea02_String, String reserveArea03_String,
			String reserveArea04_String, String reserveArea05_String) {
		HRDLocationInfoEntity locationinfo = new HRDLocationInfoEntity(id, number, name, address, enable, createDate, updateDate, reserveArea01_String, reserveArea02_String, reserveArea03_String, reserveArea04_String, reserveArea05_String);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(locationinfo);
		}finally{
			pm.close();
		}
	}

}
