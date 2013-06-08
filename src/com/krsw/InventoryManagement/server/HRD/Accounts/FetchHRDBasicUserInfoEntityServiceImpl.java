package com.krsw.InventoryManagement.server.HRD.Accounts;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.SerializeHRDBasicUserInfoEntity;
import com.krsw.InventoryManagement.server.PMF;

@SuppressWarnings("serial")
public class FetchHRDBasicUserInfoEntityServiceImpl extends RemoteServiceServlet implements FetchHRDBasicUserInfoEntityService{
	public List<SerializeHRDBasicUserInfoEntity> getRange(int start, int Length) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + HRDBasicUserInfoEntity.class.getName();
		List<HRDBasicUserInfoEntity> list = (List<HRDBasicUserInfoEntity>)pm.newQuery(query).execute();
		ArrayList<SerializeHRDBasicUserInfoEntity> listsserializedata = new ArrayList<SerializeHRDBasicUserInfoEntity>();
		for(HRDBasicUserInfoEntity basicuserdata : list){
			Long id = basicuserdata.getId();
			String lastName = basicuserdata.getLastName();
			String firstName = basicuserdata.getFirstName();
			String section = basicuserdata.getSection();
			String authority = basicuserdata.getAuthority();
			String loginId = basicuserdata.getLoginId();
			String loginPassword = basicuserdata.getLoginPassword();
			String email = basicuserdata.getEmail();
			Boolean enable = basicuserdata.getEnable();
			String createDate = basicuserdata.getCreateDate();
			String updateDate = basicuserdata.getUpdateDate();
			String reserveArea01_String = basicuserdata.getReserveArea01_String();
			String reserveArea02_String = basicuserdata.getReserveArea02_String();
			listsserializedata.add(new SerializeHRDBasicUserInfoEntity(id, lastName, firstName, section, authority, loginId, loginPassword, email, enable, createDate, updateDate, reserveArea01_String, reserveArea02_String));
		}
		return listsserializedata;
	}

	@SuppressWarnings("unchecked")
	public List<SerializeHRDBasicUserInfoEntity> getMatchUser(String userid, String pass){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(HRDBasicUserInfoEntity.class);
		query.setFilter("LoginId == paramID && LoginPassword == paramPass");
		query.declareParameters("String paramID, String paramPass");
		List<HRDBasicUserInfoEntity> list = (List<HRDBasicUserInfoEntity>)pm.newQuery(query).execute(userid, pass);
		ArrayList<SerializeHRDBasicUserInfoEntity> listserializedata = new ArrayList<SerializeHRDBasicUserInfoEntity>();
		for(HRDBasicUserInfoEntity logindata : list){
			Long id = logindata.getId();
			String lastName = logindata.getLastName();
			String firstName = logindata.getFirstName();
			String section = logindata.getSection();
			String authority = logindata.getAuthority();
			String loginId = logindata.getLoginId();
			String loginPassword = logindata.getLoginPassword();
			String email = logindata.getEmail();
			Boolean enable = logindata.getEnable();
			String createDate = logindata.getCreateDate();
			String updateDate = logindata.getUpdateDate();
			String reserveArea01_String = logindata.getReserveArea01_String();
			String reserveArea02_String = logindata.getReserveArea02_String();
			listserializedata.add(new SerializeHRDBasicUserInfoEntity(id, lastName, firstName, section, authority, loginId, loginPassword, email, enable, createDate, updateDate, reserveArea01_String, reserveArea02_String));
		}
		return listserializedata;
	}

	@SuppressWarnings("unchecked")
	public List<SerializeHRDBasicUserInfoEntity> getAvailabilityUser(String deleteMsg){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(HRDBasicUserInfoEntity.class);
		query.setFilter("ReserveArea01_String == paramReserveArea01_String");
		query.declareParameters("String paramReserveArea01_String");
		List<HRDBasicUserInfoEntity> list = (List<HRDBasicUserInfoEntity>)pm.newQuery(query).execute(deleteMsg);
		ArrayList<SerializeHRDBasicUserInfoEntity> listserializedata = new ArrayList<SerializeHRDBasicUserInfoEntity>();
		for(HRDBasicUserInfoEntity logindata : list){
			Long id = logindata.getId();
			String lastName = logindata.getLastName();
			String firstName = logindata.getFirstName();
			String section = logindata.getSection();
			String authority = logindata.getAuthority();
			String loginId = logindata.getLoginId();
			String loginPassword = logindata.getLoginPassword();
			String email = logindata.getEmail();
			Boolean enable = logindata.getEnable();
			String createDate = logindata.getCreateDate();
			String updateDate = logindata.getUpdateDate();
			String reserveArea01_String = logindata.getReserveArea01_String();
			String reserveArea02_String = logindata.getReserveArea02_String();
			listserializedata.add(new SerializeHRDBasicUserInfoEntity(id, lastName, firstName, section, authority, loginId, loginPassword, email, enable, createDate, updateDate, reserveArea01_String, reserveArea02_String));
		}
		return listserializedata;
	}

}
