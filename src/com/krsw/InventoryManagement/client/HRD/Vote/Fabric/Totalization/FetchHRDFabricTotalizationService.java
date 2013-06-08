package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDFabricTotalizationServiceAsync")
public interface FetchHRDFabricTotalizationService extends RemoteService{
	List<SerializeHRDFabricTotalizationEntity> getRange(int start, int Length );
}
