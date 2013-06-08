package com.krsw.InventoryManagement.client.HRD.Location;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface AddHRDLocationInfoEntityServiceAsync {
	void AddHRDLocationInfoEntity(Long id,Integer number,String name, String address, Boolean enable, String createDate, String updateDate,
			String reserveArea01_String, String reserveArea02_String, String reserveArea03_String, String reserveArea04_String,
			String reserveArea05_String, AsyncCallback callback);
}
