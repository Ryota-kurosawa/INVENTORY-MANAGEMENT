package com.krsw.InventoryManagement.server.HRD.Vote.Fabric.VotingResults;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.AddHRDFabricCountingResultService;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class AddHRDFabricCountingResultEntityServiceImpl extends RemoteServiceServlet implements AddHRDFabricCountingResultService {
	public void AddFabricCountingResult(Long ID, String SECTION, String NAME, String VOTED, String INPUTDATE, Boolean DELETEFLG) {
		HRDFabricCountingResultEntity HFCRE = new HRDFabricCountingResultEntity(ID, SECTION, NAME, VOTED, INPUTDATE, DELETEFLG);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(HFCRE);
		}finally{
			pm.close();
		}
	}
}
