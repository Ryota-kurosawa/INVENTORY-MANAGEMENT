package com.krsw.InventoryManagement.server.HRD.Location;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Location.FetchHRDLocationInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Location.SerializeHRDLocationInfoEntity;
import com.krsw.InventoryManagement.server.PMF;
import com.krsw.InventoryManagement.server.HRD.Accounts.HRDBasicUserInfoEntity;

public class FetchHRDLocationInfoEntityServiceImpl extends RemoteServiceServlet implements FetchHRDLocationInfoEntityService{

	public List<SerializeHRDLocationInfoEntity> getRange(int start, int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDLocationInfoEntity.class.getName();
		List<HRDLocationInfoEntity> list = (List<HRDLocationInfoEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDLocationInfoEntity> listsserializedata = new ArrayList<SerializeHRDLocationInfoEntity>();
		for(HRDLocationInfoEntity locationinfo : list){
			Long id = locationinfo.getId();
			Integer number = locationinfo.getNumber();
			String name = locationinfo.getName();
			String address = locationinfo.getAddress();
			Boolean enable = locationinfo.getEnable();
			String createDate = locationinfo.getCreateDate();
			String updateDate = locationinfo.getUpdateDate();
			String reserveArea01_String = locationinfo.getReserveArea01_String();
			String reserveArea02_String = locationinfo.getReserveArea02_String();
			String reserveArea03_String = locationinfo.getReserveArea03_String();
			String reserveArea04_String = locationinfo.getReserveArea04_String();
			String reserveArea05_String = locationinfo.getReserveArea05_String();
			listsserializedata.add(new SerializeHRDLocationInfoEntity(id, number, name, address, enable, createDate, updateDate, reserveArea01_String, reserveArea02_String, reserveArea03_String, reserveArea04_String, reserveArea05_String));
		}
		return listsserializedata;
	}

	@SuppressWarnings("unchecked")
	public List<SerializeHRDLocationInfoEntity> getAvailabilityRange(String deleteMsg) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(HRDLocationInfoEntity.class);
		query.setFilter("ReserveArea01_String == paramReserveArea01_String");
		query.declareParameters("String paramReserveArea01_String");
//		String query = "select from " + HRDLocationInfoEntity.class.getName();
		List<HRDLocationInfoEntity> list = (List<HRDLocationInfoEntity>)pm.newQuery(query).execute(deleteMsg);
		ArrayList<SerializeHRDLocationInfoEntity> listsserializedata = new ArrayList<SerializeHRDLocationInfoEntity>();
		for(HRDLocationInfoEntity locationinfo : list){
			if(locationinfo.getEnable() == true){
				Long id = locationinfo.getId();
				Integer number = locationinfo.getNumber();
				String name = locationinfo.getName();
				String address = locationinfo.getAddress();
				Boolean enable = locationinfo.getEnable();
				String createDate = locationinfo.getCreateDate();
				String updateDate = locationinfo.getUpdateDate();
				String reserveArea01_String = locationinfo.getReserveArea01_String();
				String reserveArea02_String = locationinfo.getReserveArea02_String();
				String reserveArea03_String = locationinfo.getReserveArea03_String();
				String reserveArea04_String = locationinfo.getReserveArea04_String();
				String reserveArea05_String = locationinfo.getReserveArea05_String();
				listsserializedata.add(new SerializeHRDLocationInfoEntity(id, number, name, address, enable, createDate,
						updateDate, reserveArea01_String, reserveArea02_String, reserveArea03_String, reserveArea04_String,
						reserveArea05_String));
			}
		}
		return listsserializedata;
	}

	@SuppressWarnings("unchecked")
	public List<SerializeHRDLocationInfoEntity> getAvailabilityRange2(String deleteMsg) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(HRDLocationInfoEntity.class);
		query.setFilter("ReserveArea01_String == paramReserveArea01_String");
		query.declareParameters("String paramReserveArea01_String");
//		String query = "select from " + HRDLocationInfoEntity.class.getName();
		List<HRDLocationInfoEntity> list = (List<HRDLocationInfoEntity>)pm.newQuery(query).execute(deleteMsg);
		ArrayList<SerializeHRDLocationInfoEntity> listsserializedata = new ArrayList<SerializeHRDLocationInfoEntity>();
		for(HRDLocationInfoEntity locationinfo : list){
				Long id = locationinfo.getId();
				Integer number = locationinfo.getNumber();
				String name = locationinfo.getName();
				String address = locationinfo.getAddress();
				Boolean enable = locationinfo.getEnable();
				String createDate = locationinfo.getCreateDate();
				String updateDate = locationinfo.getUpdateDate();
				String reserveArea01_String = locationinfo.getReserveArea01_String();
				String reserveArea02_String = locationinfo.getReserveArea02_String();
				String reserveArea03_String = locationinfo.getReserveArea03_String();
				String reserveArea04_String = locationinfo.getReserveArea04_String();
				String reserveArea05_String = locationinfo.getReserveArea05_String();
				listsserializedata.add(new SerializeHRDLocationInfoEntity(id, number, name, address, enable, createDate,
						updateDate, reserveArea01_String, reserveArea02_String, reserveArea03_String, reserveArea04_String,
						reserveArea05_String));
			}
		return listsserializedata;
	}
}
