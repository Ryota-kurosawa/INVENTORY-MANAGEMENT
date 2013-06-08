package com.krsw.InventoryManagement.client.HRD.Accounts;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDBasicUserInfoEntityServiceAsync")
public interface FetchHRDBasicUserInfoEntityService extends RemoteService{
	List<SerializeHRDBasicUserInfoEntity> getRange(int start, int Length );
	List<SerializeHRDBasicUserInfoEntity> getMatchUser(String userid, String pass);
	List<SerializeHRDBasicUserInfoEntity> getAvailabilityUser(String deleteMsg);
}
