package com.krsw.InventoryManagement.client.HRD.Stock.Fabric;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDFabricInfoEntityServiceAsync")
public interface FetchHRDFabricInfoEntityService extends RemoteService{
	List<SerializeHRDFabricInfoEntity> getRange(int start, int Length );
	List<SerializeHRDFabricInfoEntity> getRangeAll(int start, int Length );
	List<SerializeHRDFabricInfoEntity> getAvailabilityRange(String deleteMsg);
	List<SerializeHRDFabricInfoEntity> getAvailabilityRange2(String deleteMsg);
}
