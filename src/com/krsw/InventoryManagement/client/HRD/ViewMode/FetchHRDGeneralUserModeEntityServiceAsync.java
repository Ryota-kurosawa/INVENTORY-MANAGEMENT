package com.krsw.InventoryManagement.client.HRD.ViewMode;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDGeneralUserModeEntityServiceAsync {
void getStatusLabel(String statuslabel, AsyncCallback<List<SerializeHRDGeneralUserModeEntity>> callback);
}
