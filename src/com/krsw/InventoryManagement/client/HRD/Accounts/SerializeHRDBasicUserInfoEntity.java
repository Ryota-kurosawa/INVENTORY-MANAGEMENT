package com.krsw.InventoryManagement.client.HRD.Accounts;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializeHRDBasicUserInfoEntity implements IsSerializable{
	private Long Id;
	private String FirstName;
	private String LastName;
	private String Section;
	private String Authority;
	private String LoginId;
	private String LoginPassword;
	private String Email;
	private Boolean Enable;
	private String CreateDate;
	private String UpdateDate;
	private String ReserveArea01_String;
	private String ReserveArea02_String;

	/**
	 * construction
	 */
	public SerializeHRDBasicUserInfoEntity(){
	}

	/**
	 * construction
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param section
	 * @param authority
	 * @param loginId
	 * @param loginPassword
	 * @param email
	 * @param enable
	 * @param createDate
	 * @param updateDate
	 * @param reserveArea01_String
	 * @param reserveArea02_String
	 */
	public SerializeHRDBasicUserInfoEntity(Long id, String firstName, String lastName, String section, String authority,
			String loginId, String loginPassword, String email, Boolean enable, String createDate, String updateDate,
			String reserveArea01_String, String reserveArea02_String){
		this.Id = id; this.FirstName = firstName; this.LastName = lastName; this.Section = section; this.Authority = authority;
		this.LoginId = loginId; this.LoginPassword = loginPassword; this.Email = email; this.Enable = enable; this.CreateDate = createDate;
		this.UpdateDate = updateDate; this.ReserveArea01_String = reserveArea01_String; this.ReserveArea02_String = reserveArea02_String;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	public String getLoginPassword() {
		return LoginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Boolean getEnable() {
		return Enable;
	}

	public void setEnable(Boolean enable) {
		Enable = enable;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}

	public String getReserveArea01_String() {
		return ReserveArea01_String;
	}

	public void setReserveArea01_String(String reserveArea01_String) {
		ReserveArea01_String = reserveArea01_String;
	}

	public String getReserveArea02_String() {
		return ReserveArea02_String;
	}

	public void setReserveArea02_String(String reserveArea02_String) {
		ReserveArea02_String = reserveArea02_String;
	}

}
