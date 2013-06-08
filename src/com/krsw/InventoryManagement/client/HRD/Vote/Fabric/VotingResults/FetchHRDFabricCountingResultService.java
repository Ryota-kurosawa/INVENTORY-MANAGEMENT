package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDFabricCountingResultServiceAsync")
public interface FetchHRDFabricCountingResultService extends RemoteService{
	List<SerializeHRDFabricCountingResultEntity> getRange(int start, int Length );
}
