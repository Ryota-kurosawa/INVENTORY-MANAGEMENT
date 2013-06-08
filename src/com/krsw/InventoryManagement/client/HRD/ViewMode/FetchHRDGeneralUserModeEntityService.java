package com.krsw.InventoryManagement.client.HRD.ViewMode;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDGeneralUserModeEntityServiceAsync")
public interface FetchHRDGeneralUserModeEntityService extends RemoteService{
	List<SerializeHRDGeneralUserModeEntity> getStatusLabel(String statuslabel );
}
