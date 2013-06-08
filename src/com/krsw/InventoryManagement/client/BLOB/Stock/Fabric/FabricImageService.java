package com.krsw.InventoryManagement.client.BLOB.Stock.Fabric;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FabricImages")
public interface FabricImageService extends RemoteService{
	public String getBlobstoreUploadUrl();
}
