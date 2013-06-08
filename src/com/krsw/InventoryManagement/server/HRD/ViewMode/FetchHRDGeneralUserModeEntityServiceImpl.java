package com.krsw.InventoryManagement.server.HRD.ViewMode;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.SerializeHRDGeneralUserModeEntity;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class FetchHRDGeneralUserModeEntityServiceImpl extends RemoteServiceServlet implements FetchHRDGeneralUserModeEntityService{
	public List<SerializeHRDGeneralUserModeEntity> getStatusLabel(String statuslabel) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDGeneralUserModeEntity.class.getName();
		List<HRDGeneralUserModeEntity> list = (List<HRDGeneralUserModeEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDGeneralUserModeEntity> listsserializedata = new ArrayList<SerializeHRDGeneralUserModeEntity>();
		for(HRDGeneralUserModeEntity usermode : list){
			Long id = usermode.getId();
			String status = usermode.getStatus();
			String statusLabel = usermode.getStatusLabel();
			String lastswitched = usermode.getLastSwitched();
			String createdate = usermode.getCreateDate();
			String updatedate = usermode.getUpdateDate();
			String reservearea01_string = usermode.getReserveArea01_String();
			String reservearea02_string = usermode.getReserveArea02_String();
			listsserializedata.add(new SerializeHRDGeneralUserModeEntity(id, status, statusLabel, lastswitched, createdate, updatedate, reservearea01_string, reservearea02_string));
		}
		return listsserializedata;
	}

}
