package com.krsw.InventoryManagement.client.HRD.Stock.Fabric;

import java.util.List;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FetchHRDFabricInfoEntityServiceAsync {
void getRange(int start, int Length, AsyncCallback<List<SerializeHRDFabricInfoEntity>> callback);
void getRangeAll(int start, int Length, AsyncCallback<List<SerializeHRDFabricInfoEntity>> callback);
void getAvailabilityRange(String deleteMsg, AsyncCallback<List<SerializeHRDFabricInfoEntity>> callback);
void getAvailabilityRange2(String deleteMsg, AsyncCallback<List<SerializeHRDFabricInfoEntity>> callback);
}
