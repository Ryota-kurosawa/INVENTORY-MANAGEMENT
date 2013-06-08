package com.krsw.InventoryManagement.client.HRD.Location;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AddHRDLocationInfoEntityService")
public interface AddHRDLocationInfoEntityService extends RemoteService{
	void AddHRDLocationInfoEntity(Long id,Integer number, String name, String address, Boolean enable, String createDate, String updateDate,
			String reserveArea01_String, String reserveArea02_String, String reserveArea03_String, String reserveArea04_String,
			String reserveArea05_String);
}
