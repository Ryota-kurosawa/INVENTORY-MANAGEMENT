package com.krsw.InventoryManagement.server.BLOB.Stock.Fabric;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.BLOB.Stock.Fabric.FabricImageService;

public class FabricImageServiceImpl extends RemoteServiceServlet implements FabricImageService{
	public String getBlobstoreUploadUrl() {
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		return blobstoreService.createUploadUrl("/FabricUpload");
	}
}
