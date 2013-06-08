package com.krsw.InventoryManagement.client.HRD.ViewMode;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AddHRDGeneralUserModeEntityServiceAsync {
	void AddHRDGeneralUserModeEntity(Long id, String status, String statusLabel, String lastSwitched,
			String createDate, String updateDate, String reserveArea01_String,	String reserveArea02_String, AsyncCallback callback);
}
