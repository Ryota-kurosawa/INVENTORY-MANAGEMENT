package com.krsw.InventoryManagement.server.HRD.Stock.Fabric;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.server.PMF;
import com.krsw.InventoryManagement.server.HRD.Location.HRDLocationInfoEntity;
@SuppressWarnings("serial")
public class FetchHRDFabricInfoEntityServiceImpl extends RemoteServiceServlet implements FetchHRDFabricInfoEntityService{
	//一般ユーザー用
	public List<SerializeHRDFabricInfoEntity> getRange(int start, int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDFabricInfoEntity.class.getName();
		List<HRDFabricInfoEntity> list = (List<HRDFabricInfoEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDFabricInfoEntity> listsserializedata = new ArrayList<SerializeHRDFabricInfoEntity>();
		for(HRDFabricInfoEntity FabricInfo : list){
			if(FabricInfo.getEnabled() == true && FabricInfo.getReserveArea04_String().equals("")){
				Long id = FabricInfo.getId();
				int controlnumber = FabricInfo.getControlNumber();
				String material = FabricInfo.getMaterial();
				String size = FabricInfo.getSize();
				String storagelocation = FabricInfo.getStorageLocation();
				Boolean enabled = FabricInfo.getEnabled();
				String remarks = FabricInfo.getRemarks();
				String imageurl01 = FabricInfo.getImageUrl01();
				String imageurl02 = FabricInfo.getImageUrl02();
				String imageurl03 = FabricInfo.getImageUrl03();
				String imageurl04 = FabricInfo.getImageUrl04();
				String createdate = FabricInfo.getCreateDate();
				String updatedate = FabricInfo.getUpdateDate();
				String reservearea01_string = FabricInfo.getReserveArea01_String();
				String reservearea02_string = FabricInfo.getReserveArea02_String();
				String reservearea03_string = FabricInfo.getReserveArea03_String();
				String reservearea04_string = FabricInfo.getReserveArea04_String();
				Boolean reservearea01_boolean = FabricInfo.getReserveArea01_Boolean();
				Boolean reservearea02_boolean = FabricInfo.getReserveArea02_Boolean();
				Boolean reservearea03_boolean = FabricInfo.getReserveArea03_Boolean();
				listsserializedata.add(new SerializeHRDFabricInfoEntity(id, controlnumber, material, size, storagelocation, enabled,
						remarks, imageurl01, imageurl02, imageurl03, imageurl04, createdate, updatedate, reservearea01_string,
						reservearea02_string, reservearea03_string, reservearea04_string, reservearea01_boolean, reservearea02_boolean,
						reservearea03_boolean));
			}
		}
		return listsserializedata;
	}


	public List<SerializeHRDFabricInfoEntity> getRangeAll(int start, int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDFabricInfoEntity.class.getName();
		List<HRDFabricInfoEntity> list = (List<HRDFabricInfoEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDFabricInfoEntity> listsserializedata = new ArrayList<SerializeHRDFabricInfoEntity>();
		for(HRDFabricInfoEntity FabricInfo : list){
//			if(FabricInfo.getEnabled() == true){
				Long id = FabricInfo.getId();
				int controlnumber = FabricInfo.getControlNumber();
				String material = FabricInfo.getMaterial();
				String size = FabricInfo.getSize();
				String storagelocation = FabricInfo.getStorageLocation();
				Boolean enabled = FabricInfo.getEnabled();
				String remarks = FabricInfo.getRemarks();
				String imageurl01 = FabricInfo.getImageUrl01();
				String imageurl02 = FabricInfo.getImageUrl02();
				String imageurl03 = FabricInfo.getImageUrl03();
				String imageurl04 = FabricInfo.getImageUrl04();
				String createdate = FabricInfo.getCreateDate();
				String updatedate = FabricInfo.getUpdateDate();
				String reservearea01_string = FabricInfo.getReserveArea01_String();
				String reservearea02_string = FabricInfo.getReserveArea02_String();
				String reservearea03_string = FabricInfo.getReserveArea03_String();
				String reservearea04_string = FabricInfo.getReserveArea04_String();
				Boolean reservearea01_boolean = FabricInfo.getReserveArea01_Boolean();
				Boolean reservearea02_boolean = FabricInfo.getReserveArea02_Boolean();
				Boolean reservearea03_boolean = FabricInfo.getReserveArea03_Boolean();
				listsserializedata.add(new SerializeHRDFabricInfoEntity(id, controlnumber, material, size, storagelocation, enabled,
						remarks, imageurl01, imageurl02, imageurl03, imageurl04, createdate, updatedate, reservearea01_string,
						reservearea02_string, reservearea03_string, reservearea04_string, reservearea01_boolean, reservearea02_boolean,
						reservearea03_boolean));
			}
//		}
		return listsserializedata;
	}

	//管理者画面用
	@SuppressWarnings("unchecked")
	public List<SerializeHRDFabricInfoEntity> getAvailabilityRange(String deleteMsg) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(HRDFabricInfoEntity.class);
		query.setFilter("ReserveArea04_String == paramReserveArea04_String");
		query.declareParameters("String paramReserveArea04_String");
//		String query = "select from " + HRDFabricInfoEntity.class.getName();
		List<HRDFabricInfoEntity> list = (List<HRDFabricInfoEntity>)pm.newQuery(query).execute(deleteMsg);
		ArrayList<SerializeHRDFabricInfoEntity> listsserializedata = new ArrayList<SerializeHRDFabricInfoEntity>();
		for(HRDFabricInfoEntity FabricInfo : list){
//			if(FabricInfo.getEnabled() == true){
				Long id = FabricInfo.getId();
				int controlnumber = FabricInfo.getControlNumber();
				String material = FabricInfo.getMaterial();
				String size = FabricInfo.getSize();
				String storagelocation = FabricInfo.getStorageLocation();
				Boolean enabled = FabricInfo.getEnabled();
				String remarks = FabricInfo.getRemarks();
				String imageurl01 = FabricInfo.getImageUrl01();
				String imageurl02 = FabricInfo.getImageUrl02();
				String imageurl03 = FabricInfo.getImageUrl03();
				String imageurl04 = FabricInfo.getImageUrl04();
				String createdate = FabricInfo.getCreateDate();
				String updatedate = FabricInfo.getUpdateDate();
				String reservearea01_string = FabricInfo.getReserveArea01_String();
				String reservearea02_string = FabricInfo.getReserveArea02_String();
				String reservearea03_string = FabricInfo.getReserveArea03_String();
				String reservearea04_string = FabricInfo.getReserveArea04_String();
				Boolean reservearea01_boolean = FabricInfo.getReserveArea01_Boolean();
				Boolean reservearea02_boolean = FabricInfo.getReserveArea02_Boolean();
				Boolean reservearea03_boolean = FabricInfo.getReserveArea03_Boolean();
				listsserializedata.add(new SerializeHRDFabricInfoEntity(id, controlnumber, material, size, storagelocation, enabled,
						remarks, imageurl01, imageurl02, imageurl03, imageurl04, createdate, updatedate, reservearea01_string,
						reservearea02_string, reservearea03_string, reservearea04_string, reservearea01_boolean, reservearea02_boolean,
						reservearea03_boolean));
			}
//		}
		return listsserializedata;
	}

	//管理者画面用
	@SuppressWarnings("unchecked")
	public List<SerializeHRDFabricInfoEntity> getAvailabilityRange2(String deleteMsg) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(HRDFabricInfoEntity.class);
		query.setFilter("ReserveArea04_String == paramReserveArea04_String");
		query.declareParameters("String paramReserveArea04_String");
//		String query = "select from " + HRDFabricInfoEntity.class.getName();
		List<HRDFabricInfoEntity> list = (List<HRDFabricInfoEntity>)pm.newQuery(query).execute(deleteMsg);
		ArrayList<SerializeHRDFabricInfoEntity> listsserializedata = new ArrayList<SerializeHRDFabricInfoEntity>();
		for(HRDFabricInfoEntity FabricInfo : list){
			if(FabricInfo.getEnabled() == true){
				Long id = FabricInfo.getId();
				int controlnumber = FabricInfo.getControlNumber();
				String material = FabricInfo.getMaterial();
				String size = FabricInfo.getSize();
				String storagelocation = FabricInfo.getStorageLocation();
				Boolean enabled = FabricInfo.getEnabled();
				String remarks = FabricInfo.getRemarks();
				String imageurl01 = FabricInfo.getImageUrl01();
				String imageurl02 = FabricInfo.getImageUrl02();
				String imageurl03 = FabricInfo.getImageUrl03();
				String imageurl04 = FabricInfo.getImageUrl04();
				String createdate = FabricInfo.getCreateDate();
				String updatedate = FabricInfo.getUpdateDate();
				String reservearea01_string = FabricInfo.getReserveArea01_String();
				String reservearea02_string = FabricInfo.getReserveArea02_String();
				String reservearea03_string = FabricInfo.getReserveArea03_String();
				String reservearea04_string = FabricInfo.getReserveArea04_String();
				Boolean reservearea01_boolean = FabricInfo.getReserveArea01_Boolean();
				Boolean reservearea02_boolean = FabricInfo.getReserveArea02_Boolean();
				Boolean reservearea03_boolean = FabricInfo.getReserveArea03_Boolean();
				listsserializedata.add(new SerializeHRDFabricInfoEntity(id, controlnumber, material, size, storagelocation, enabled,
						remarks, imageurl01, imageurl02, imageurl03, imageurl04, createdate, updatedate, reservearea01_string,
						reservearea02_string, reservearea03_string, reservearea04_string, reservearea01_boolean, reservearea02_boolean,
						reservearea03_boolean));
			}
		}
		return listsserializedata;
	}

}
