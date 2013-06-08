package com.krsw.InventoryManagement.server.HRD.Vote.Fabric.Totalization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.FetchHRDFabricTotalizationService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.SerializeHRDFabricTotalizationEntity;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class FetchHRDFabricTotalizationEntityServiceImpl extends RemoteServiceServlet implements FetchHRDFabricTotalizationService{
	@SuppressWarnings("unchecked")
	public List<SerializeHRDFabricTotalizationEntity> getRange(int start,int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDFabricTotalizationEntity.class.getName();
		List<HRDFabricTotalizationEntity> list = (List<HRDFabricTotalizationEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDFabricTotalizationEntity> listsserializedata = new ArrayList<SerializeHRDFabricTotalizationEntity>();
		for(HRDFabricTotalizationEntity Data : list){
			Long ID = Data.getId();
			int NO1 = Data.getNo1();
			int NO2 = Data.getNo2();
			int NO3 = Data.getNo3();
			int NO4 = Data.getNo4();
			int NO5 = Data.getNo5();
			int NO6 = Data.getNo6();
			int NO7 = Data.getNo7();
			int NO8 = Data.getNo8();
			int NO9 = Data.getNo9();
			int NO10 = Data.getNo10();
			int NO11 = Data.getNo11();
			int NO12 = Data.getNo12();
			int NO13 = Data.getNo13();
			int NO14 = Data.getNo14();
			int NO15 = Data.getNo15();
			int NO16 = Data.getNo16();
			int NO17 = Data.getNo17();
			int NO18 = Data.getNo18();
			int NO19 = Data.getNo19();
			int NO20 = Data.getNo20();
			int NO21 = Data.getNo21();
			int NO22 = Data.getNo22();
			int NO23 = Data.getNo23();
			int NO24 = Data.getNo24();
			int NO25 = Data.getNo25();
			int NO26 = Data.getNo26();
			int NO27 = Data.getNo27();
			int NO28 = Data.getNo28();
			int NO29 = Data.getNo29();
			int NO30 = Data.getNo30();
			int NO31 = Data.getNo31();
			int NO32 = Data.getNo32();
			int NO33 = Data.getNo33();
			int NO34 = Data.getNo34();
			int NO35 = Data.getNo35();
			int NO36 = Data.getNo36();
			int NO37 = Data.getNo37();
			int NO38 = Data.getNo38();
			int NO39 = Data.getNo39();
			int NO40 = Data.getNo40();
			int NO41 = Data.getNo41();
			int NO42 = Data.getNo42();
			int NO43 = Data.getNo43();
			int NO44 = Data.getNo44();
			int NO45 = Data.getNo45();
			int NO46 = Data.getNo46();
			int NO47 = Data.getNo47();
			int NO48 = Data.getNo48();
			int NO49 = Data.getNo49();
			int NO50 = Data.getNo50();
			int NO51 = Data.getNo51();
			int NO52 = Data.getNo52();
			int NO53 = Data.getNo53();
			int NO54 = Data.getNo54();
			int NO55 = Data.getNo55();
			int NO56 = Data.getNo56();
			int NO57 = Data.getNo57();
			int NO58 = Data.getNo58();
			int NO59 = Data.getNo59();
			int NO60 = Data.getNo60();
			int NO61 = Data.getNo61();
			int NO62 = Data.getNo62();
			int NO63 = Data.getNo63();
			int NO64 = Data.getNo64();
			int NO65 = Data.getNo65();
			int NO66 = Data.getNo66();
			int NO67 = Data.getNo67();
			int NO68 = Data.getNo68();
			int NO69 = Data.getNo69();
			int NO70 = Data.getNo70();
			int NO71 = Data.getNo71();
			int NO72 = Data.getNo72();
			int NO73 = Data.getNo73();
			int NO74 = Data.getNo74();
			int NO75 = Data.getNo75();
			int NO76 = Data.getNo76();
			int NO77 = Data.getNo77();
			int NO78 = Data.getNo78();
			int NO79 = Data.getNo79();
			int NO80 = Data.getNo80();
			int NO81 = Data.getNo81();
			int NO82 = Data.getNo82();
			int NO83 = Data.getNo83();
			int NO84 = Data.getNo84();
			int NO85 = Data.getNo85();
			int NO86 = Data.getNo86();
			int NO87 = Data.getNo87();
			int NO88 = Data.getNo88();
			int NO89 = Data.getNo89();
			int NO90 = Data.getNo90();
			int NO91 = Data.getNo91();
			int NO92 = Data.getNo92();
			int NO93 = Data.getNo93();
			int NO94 = Data.getNo94();
			int NO95 = Data.getNo95();
			int NO96 = Data.getNo96();
			int NO97 = Data.getNo97();
			int NO98 = Data.getNo98();
			int NO99 = Data.getNo99();
			int NO100 = Data.getNo100();
			String OUTPUTDATE = Data.getUpdatedate();
			listsserializedata.add(new SerializeHRDFabricTotalizationEntity(ID, NO1, NO2, NO3, NO4, NO5, NO6, NO7, NO8, NO9, NO10,
					NO11, NO12, NO13, NO14, NO15, NO16, NO17, NO18, NO19, NO20,
					NO21, NO22, NO23, NO24, NO25, NO26, NO27, NO28, NO29, NO30,
					NO31, NO32, NO33, NO34, NO35, NO36, NO37, NO38, NO39, NO40,
					NO41, NO42, NO43, NO44, NO45, NO46, NO47, NO48, NO49, NO50,
					NO51, NO52, NO53, NO54, NO55, NO56, NO57, NO58, NO59, NO60,
					NO61, NO62, NO63, NO64, NO65, NO66, NO67, NO68, NO69, NO70,
					NO71, NO72, NO73, NO74, NO75, NO76, NO77, NO78, NO79, NO80,
					NO81, NO82, NO83, NO84, NO85, NO86, NO87, NO88, NO89, NO90,
					NO91, NO92, NO93, NO94, NO95, NO96, NO97, NO98, NO99, NO100, OUTPUTDATE));
		}
		return listsserializedata;
		}
}
