package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AddHRDFabricCountingResultServiceAsync {
	void AddFabricCountingResult(Long ID, String SECTION, String NAME, String VOTED, String INPUTDATE, Boolean DELETEFLG, AsyncCallback callback);
}
