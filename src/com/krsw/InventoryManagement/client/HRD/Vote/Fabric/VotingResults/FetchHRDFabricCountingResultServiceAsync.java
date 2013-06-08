package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDFabricCountingResultServiceAsync {
	void getRange(int start, int Length, AsyncCallback<List<SerializeHRDFabricCountingResultEntity>> callback);
}
