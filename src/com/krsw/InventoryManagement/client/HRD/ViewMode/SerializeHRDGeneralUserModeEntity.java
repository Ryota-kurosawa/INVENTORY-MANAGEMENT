package com.krsw.InventoryManagement.client.HRD.ViewMode;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializeHRDGeneralUserModeEntity implements IsSerializable{
	private Long Id;
	private String Status;
	private String StatusLabel;
	private String LastSwitched;
	private String CreateDate;
	private String UpdateDate;
	private String ReserveArea01_String;
	private String ReserveArea02_String;

	/**
	 * コンストラクタ
	 */
	public SerializeHRDGeneralUserModeEntity(){
	}

	/**
	 *
	 * @param id
	 * @param status
	 * @param statusLabel
	 * @param lastSwitched
	 * @param createDate
	 * @param updateDate
	 * @param reserveArea01_String
	 * @param reserveArea02_String
	 */
	public SerializeHRDGeneralUserModeEntity(Long id, String status, String statusLabel, String lastSwitched,
			String createDate, String updateDate, String reserveArea01_String,	String reserveArea02_String){
		this.Id = id; this.Status = status; this.StatusLabel = statusLabel; LastSwitched = lastSwitched;
		this.CreateDate = createDate; this.UpdateDate = updateDate; this.ReserveArea01_String = reserveArea01_String;
		this.ReserveArea02_String = reserveArea02_String;
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

	public String getStatusLabel() {
		return StatusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		StatusLabel = statusLabel;
	}

	public String getLastSwitched() {
		return LastSwitched;
	}

	public void setLastSwitched(String lastSwitched) {
		LastSwitched = lastSwitched;
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
