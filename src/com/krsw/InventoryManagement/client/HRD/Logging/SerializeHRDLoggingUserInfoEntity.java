package com.krsw.InventoryManagement.client.HRD.Logging;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializeHRDLoggingUserInfoEntity implements IsSerializable{
	private Long Id;
	private String Status;
	private String Message;
	private String Typing_LoginId;
	private String Typing_LoginPassword;
	private String CreateDate;
	private String ReserveArea01_String;
	private String ReserveArea02_String;

	/**
	 * コンストラクタ
	 */
	public SerializeHRDLoggingUserInfoEntity(){
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
	public SerializeHRDLoggingUserInfoEntity(Long ID, String STATUS, String MESSAGE, String TYPING_LOGINID,
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
