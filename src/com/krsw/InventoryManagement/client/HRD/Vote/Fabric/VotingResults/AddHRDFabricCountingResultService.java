package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AddHRDFabricCountingResultService")
public interface AddHRDFabricCountingResultService extends RemoteService{
	void AddFabricCountingResult(Long ID, String SECTION, String NAME, String VOTED, String INPUTDATE, Boolean DELETEFLG);
}
