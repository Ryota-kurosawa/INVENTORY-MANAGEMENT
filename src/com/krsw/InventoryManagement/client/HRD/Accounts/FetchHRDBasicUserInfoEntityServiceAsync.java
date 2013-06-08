package com.krsw.InventoryManagement.client.HRD.Accounts;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDBasicUserInfoEntityServiceAsync {
	void getRange(int start, int Length, AsyncCallback<List<SerializeHRDBasicUserInfoEntity>> callback);
	void getMatchUser(String userid, String pass, AsyncCallback<List<SerializeHRDBasicUserInfoEntity>> callback);
	void getAvailabilityUser(String deleteMsg, AsyncCallback<List<SerializeHRDBasicUserInfoEntity>> callback);
}
