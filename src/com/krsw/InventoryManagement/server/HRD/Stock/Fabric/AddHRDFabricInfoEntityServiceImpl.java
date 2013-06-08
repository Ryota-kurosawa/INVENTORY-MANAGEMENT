package com.krsw.InventoryManagement.server.HRD.Stock.Fabric;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class AddHRDFabricInfoEntityServiceImpl extends RemoteServiceServlet implements AddHRDFabricInfoEntityService{
	public void AddFabricInfo(Long id, int controlnumber, String material,
			String size, String storagelocation, Boolean enabled,
			String remarks, String imageUrl01, String imageUrl02,
			String imageUrl03, String imageUrl04, String createdate,
			String updatedate, String reserveArea01_String,
			String reserveArea02_String, String reserveArea03_String,
			String reserveArea04_String, Boolean reserveArea01_Boolean,
			Boolean reserveArea02_Boolean, Boolean reserveArea03_Boolean) {
		HRDFabricInfoEntity FIE = new HRDFabricInfoEntity(id, controlnumber, material, size, storagelocation, enabled,
				remarks, imageUrl01, imageUrl02, imageUrl03, imageUrl04, createdate, updatedate, reserveArea01_String,
				reserveArea02_String, reserveArea03_String, reserveArea04_String, reserveArea01_Boolean, reserveArea02_Boolean,
				reserveArea03_Boolean);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(FIE);
		}finally{
			pm.close();
		}
	}

}
