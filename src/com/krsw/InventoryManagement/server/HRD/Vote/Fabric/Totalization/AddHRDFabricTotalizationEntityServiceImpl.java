package com.krsw.InventoryManagement.server.HRD.Vote.Fabric.Totalization;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.AddHRDFabricTotalizationService;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class AddHRDFabricTotalizationEntityServiceImpl extends RemoteServiceServlet implements AddHRDFabricTotalizationService{

	public void AddHRDFabricTotalization(Long ID, int NO1, int NO2, int NO3,
			int NO4, int NO5, int NO6, int NO7, int NO8, int NO9, int NO10,
			int NO11, int NO12, int NO13, int NO14, int NO15, int NO16,
			int NO17, int NO18, int NO19, int NO20, int NO21, int NO22,
			int NO23, int NO24, int NO25, int NO26, int NO27, int NO28,
			int NO29, int NO30, int NO31, int NO32, int NO33, int NO34,
			int NO35, int NO36, int NO37, int NO38, int NO39, int NO40,
			int NO41, int NO42, int NO43, int NO44, int NO45, int NO46,
			int NO47, int NO48, int NO49, int NO50, int NO51, int NO52,
			int NO53, int NO54, int NO55, int NO56, int NO57, int NO58,
			int NO59, int NO60, int NO61, int NO62, int NO63, int NO64,
			int NO65, int NO66, int NO67, int NO68, int NO69, int NO70,
			int NO71, int NO72, int NO73, int NO74, int NO75, int NO76,
			int NO77, int NO78, int NO79, int NO80, int NO81, int NO82,
			int NO83, int NO84, int NO85, int NO86, int NO87, int NO88,
			int NO89, int NO90, int NO91, int NO92, int NO93, int NO94,
			int NO95, int NO96, int NO97, int NO98, int NO99, int NO100,
			String UPDATEDATE) {
		HRDFabricTotalizationEntity FTE = new HRDFabricTotalizationEntity(ID, NO1, NO2, NO3, NO4, NO5, NO6, NO7, NO8, NO9, NO10,
				NO11, NO12, NO13, NO14, NO15, NO16, NO17, NO18, NO19, NO20, NO21, NO22, NO23, NO24, NO25, NO26, NO27, NO28, NO29,
				NO30, NO31, NO32, NO33, NO34, NO35, NO36, NO37, NO38, NO39, NO40, NO41, NO42, NO43, NO44, NO45, NO46, NO47, NO48, NO49,
				NO50, NO51, NO52, NO53, NO54, NO55, NO56, NO57, NO58, NO59, NO60, NO61, NO62, NO63, NO64, NO65, NO66, NO67, NO68, NO69,
				NO70, NO71, NO72, NO73, NO74, NO75, NO76, NO77, NO78, NO79, NO80, NO81, NO82, NO83, NO84, NO85, NO86, NO87, NO88, NO89,
				NO90, NO91, NO92, NO93, NO94, NO95, NO96, NO97, NO98, NO99, NO100, UPDATEDATE);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(FTE);
		}finally{
			pm.close();
		}
	}
}
