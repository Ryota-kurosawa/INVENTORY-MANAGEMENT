package com.krsw.InventoryManagement.client.HRD.Location;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDLocationInfoEntityServiceAsync")
public interface FetchHRDLocationInfoEntityService extends RemoteService{
	List<SerializeHRDLocationInfoEntity> getRange(int start, int Length );
	List<SerializeHRDLocationInfoEntity> getAvailabilityRange(String deleteMsg );
	List<SerializeHRDLocationInfoEntity> getAvailabilityRange2(String deleteMsg );
}
