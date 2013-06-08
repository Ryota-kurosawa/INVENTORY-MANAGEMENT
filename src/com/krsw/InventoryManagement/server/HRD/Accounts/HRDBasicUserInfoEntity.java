package com.krsw.InventoryManagement.server.HRD.Accounts;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION )
public class HRDBasicUserInfoEntity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long Id;
	@Persistent
	private String FirstName;
	@Persistent
	private String LastName;
	@Persistent
	private String Section;
	@Persistent
	private String Authority;
	@Persistent
	private String LoginId;
	@Persistent
	private String LoginPassword;
	@Persistent
	private String Email;
	@Persistent
	private Boolean Enable;
	@Persistent
	private String CreateDate;
	@Persistent
	private String UpdateDate;
	@Persistent
	private String ReserveArea01_String;
	@Persistent
	private String ReserveArea02_String;

	/**
	 * construction
	 */
	public HRDBasicUserInfoEntity(){
	}

	public HRDBasicUserInfoEntity(Long id){
		this.Id = id;
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
	public HRDBasicUserInfoEntity(Long id, String firstName, String lastName, String section, String authority,
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
