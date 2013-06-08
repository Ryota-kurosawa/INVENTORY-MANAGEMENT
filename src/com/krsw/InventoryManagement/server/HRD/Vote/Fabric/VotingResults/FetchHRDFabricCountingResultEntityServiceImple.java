package com.krsw.InventoryManagement.server.HRD.Vote.Fabric.VotingResults;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.FetchHRDFabricCountingResultService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.SerializeHRDFabricCountingResultEntity;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class FetchHRDFabricCountingResultEntityServiceImple extends RemoteServiceServlet implements FetchHRDFabricCountingResultService{
	@SuppressWarnings("unchecked")
	public List<SerializeHRDFabricCountingResultEntity> getRange(int start, int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDFabricCountingResultEntity.class.getName();
		List<HRDFabricCountingResultEntity> list = (List<HRDFabricCountingResultEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDFabricCountingResultEntity> listsserializedata = new ArrayList<SerializeHRDFabricCountingResultEntity>();
		for(HRDFabricCountingResultEntity CountingData : list){
			if(CountingData.getDeleteflg() == true){
				Long id = CountingData.getId();
				String section = CountingData.getSection();
				String name = CountingData.getName();
				String voted = CountingData.getVoted();
				String inputdate = CountingData.getInputdate();
				Boolean deleteflg = CountingData.getDeleteflg();
				listsserializedata.add(new SerializeHRDFabricCountingResultEntity(id, section, name, voted, inputdate, deleteflg));
			}
		}
		return listsserializedata;
	}

}
