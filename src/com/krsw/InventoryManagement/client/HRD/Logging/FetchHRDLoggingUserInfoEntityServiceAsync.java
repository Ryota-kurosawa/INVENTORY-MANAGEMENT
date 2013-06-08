package com.krsw.InventoryManagement.client.HRD.Logging;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDLoggingUserInfoEntityServiceAsync {
	void getRange(int start, int Length, AsyncCallback<List<SerializeHRDLoggingUserInfoEntity>> callback);
}
