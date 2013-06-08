package com.krsw.InventoryManagement.client.HRD.Logging;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FetchHRDLoggingUserInfoEntityServiceAsync")
public interface FetchHRDLoggingUserInfoEntityService extends RemoteService{
	List<SerializeHRDLoggingUserInfoEntity> getRange(int start, int Length );
}
