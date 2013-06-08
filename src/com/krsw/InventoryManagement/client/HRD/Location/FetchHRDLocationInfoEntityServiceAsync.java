package com.krsw.InventoryManagement.client.HRD.Location;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDLocationInfoEntityServiceAsync {
	void getRange(int start, int Length, AsyncCallback<List<SerializeHRDLocationInfoEntity>> callback);
	void getAvailabilityRange(String deleteMsg, AsyncCallback<List<SerializeHRDLocationInfoEntity>> callback);
	void getAvailabilityRange2(String deleteMsg, AsyncCallback<List<SerializeHRDLocationInfoEntity>> callback);
}
