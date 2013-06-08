package com.krsw.InventoryManagement.client.HRD.Stock.Fabric;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AddHRDFabricInfoEntityServiceAsync {
	void AddFabricInfo(Long id, int controlnumber, String material, String size, String storagelocation,
			Boolean enabled, String remarks, String imageUrl01, String imageUrl02, String imageUrl03, String imageUrl04,
			String createdate, String updatedate, String reserveArea01_String, String reserveArea02_String,
			String reserveArea03_String,	String reserveArea04_String, Boolean reserveArea01_Boolean,
			Boolean reserveArea02_Boolean, Boolean reserveArea03_Boolean, AsyncCallback callback);
}
