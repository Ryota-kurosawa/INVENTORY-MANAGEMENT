package com.krsw.InventoryManagement.client.HRD.Accounts;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AddHRDBasicUserInfoEntityServiceAsync {
	void AddHRDBasicUserInfoEntity(Long id, String lastName, String firstName, String section, String authority,
			String loginId, String loginPassword, String email, Boolean enable, String createDate, String updateDate,
			String reserveArea01_String, String reserveArea02_String, AsyncCallback callback);
}
