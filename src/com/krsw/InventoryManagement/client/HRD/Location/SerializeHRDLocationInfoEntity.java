package com.krsw.InventoryManagement.client.HRD.Location;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializeHRDLocationInfoEntity implements IsSerializable{
	private Long Id;
	private Integer Number;
	private String Name;
	private String Address;
	private Boolean Enable;
	private String CreateDate;
	private String UpdateDate;
	private String ReserveArea01_String;
	private String ReserveArea02_String;
	private String ReserveArea03_String;
	private String ReserveArea04_String;
	private String ReserveArea05_String;


	/**
	 * コンストラクタ
	 */
	public SerializeHRDLocationInfoEntity(){
	}

	public SerializeHRDLocationInfoEntity(Long id,Integer number, String name, String address, Boolean enable, String createDate, String updateDate,
			String reserveArea01_String, String reserveArea02_String, String reserveArea03_String, String reserveArea04_String,
			String reserveArea05_String){
		this.Id = id; this.Number = number; this.Name = name; this.Enable = enable; this.Address = address; this.CreateDate = createDate;
		this.UpdateDate = updateDate; this.ReserveArea01_String = reserveArea01_String; this.ReserveArea02_String = reserveArea02_String;
		this.ReserveArea03_String = reserveArea03_String; this.ReserveArea04_String = reserveArea04_String; this.ReserveArea05_String = reserveArea05_String;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public String getReserveArea03_String() {
		return ReserveArea03_String;
	}

	public void setReserveArea03_String(String reserveArea03_String) {
		ReserveArea03_String = reserveArea03_String;
	}

	public String getReserveArea04_String() {
		return ReserveArea04_String;
	}

	public void setReserveArea04_String(String reserveArea04_String) {
		ReserveArea04_String = reserveArea04_String;
	}

	public String getReserveArea05_String() {
		return ReserveArea05_String;
	}

	public void setReserveArea05_String(String reserveArea05_String) {
		ReserveArea05_String = reserveArea05_String;
	}

}
