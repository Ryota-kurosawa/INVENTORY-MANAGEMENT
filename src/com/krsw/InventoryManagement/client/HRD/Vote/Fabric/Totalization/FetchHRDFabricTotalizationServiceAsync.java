package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDFabricTotalizationServiceAsync {
	void getRange(int start, int Length, AsyncCallback<List<SerializeHRDFabricTotalizationEntity>> callback);
}
