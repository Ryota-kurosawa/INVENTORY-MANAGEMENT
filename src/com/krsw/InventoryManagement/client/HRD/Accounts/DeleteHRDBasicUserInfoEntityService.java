package com.krsw.InventoryManagement.client.HRD.Accounts;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DeleteHRDBasicUserInfoEntityServiceAsync")
public interface DeleteHRDBasicUserInfoEntityService extends RemoteService{
	void DeleteHRDBasicUserInfoEntity(Long id);
}
