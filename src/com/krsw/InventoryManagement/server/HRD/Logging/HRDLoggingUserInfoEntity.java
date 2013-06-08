package com.krsw.InventoryManagement.server.HRD.Logging;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION )
public class HRDLoggingUserInfoEntity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long Id;
	@Persistent
	private String Status;
	@Persistent
	private String Message;
	@Persistent
	private String Typing_LoginId;
	@Persistent
	private String Typing_LoginPassword;
	@Persistent
	private String CreateDate;
	@Persistent
	private String ReserveArea01_String;
	@Persistent
	private String ReserveArea02_String;

	/**
	 * コンストラクタ
	 */
	public HRDLoggingUserInfoEntity(){
	}

	/**
	 * コンストラクタ
	 * @param ID
	 * @param STATUS
	 * @param MESSAGE
	 * @param TYPING_LOGINID
	 * @param TYPING_LOGINPASSWORD
	 * @param CREATEDATE
	 * @param RESERVEAREA01_STRING
	 * @param RESERVEAREA02_STRING
	 */
	public HRDLoggingUserInfoEntity(Long ID, String STATUS, String MESSAGE, String TYPING_LOGINID,
			String TYPING_LOGINPASSWORD, String CREATEDATE, String RESERVEAREA01_STRING, String RESERVEAREA02_STRING){
		this.Id = ID; this.Status = STATUS; this.Message = MESSAGE; this.Typing_LoginId = TYPING_LOGINID;
		this.Typing_LoginPassword = TYPING_LOGINPASSWORD; this.CreateDate = CREATEDATE;
		this.ReserveArea01_String = RESERVEAREA01_STRING; this.ReserveArea02_String = RESERVEAREA02_STRING;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getTyping_LoginId() {
		return Typing_LoginId;
	}

	public void setTyping_LoginId(String typing_LoginId) {
		Typing_LoginId = typing_LoginId;
	}

	public String getTyping_LoginPassword() {
		return Typing_LoginPassword;
	}

	public void setTyping_LoginPassword(String typing_LoginPassword) {
		Typing_LoginPassword = typing_LoginPassword;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String createDate) {
		CreateDate = createDate;
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
