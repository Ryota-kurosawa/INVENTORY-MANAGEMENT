package com.krsw.InventoryManagement.client.HRD.Stock.Fabric;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializeHRDFabricInfoEntity implements IsSerializable{
	private Long Id;
	//幕管理番号
	private int ControlNumber;
	//材質
	private String Material;
	//サイズ
	private String Size;
	//保管場所
	private String StorageLocation;
	//有効or無効
	private Boolean Enabled;
	//備考
	private String Remarks;
	//画像URL01
	private String ImageUrl01;
	//画像URL02
	private String ImageUrl02;
	//画像URL03
	private String ImageUrl03;
	//画像URL04
	private String ImageUrl04;
	//データ登録日
	private String CreateDate;
	//データ更新日
	private String UpdateDate;
	//予備01
	private String ReserveArea01_String;
	//予備02
	private String ReserveArea02_String;
	//予備03
	private String ReserveArea03_String;
	//予備04
	private String ReserveArea04_String;
	//予備01
	private Boolean ReserveArea01_Boolean;
	//予備02
	private Boolean ReserveArea02_Boolean;
	//予備03
	private Boolean ReserveArea03_Boolean;

	/**
	 * コンストラクタ
	 */
	public SerializeHRDFabricInfoEntity(){
	}

	/**
	 * コンストラクタ
	 * @param id
	 * @param controlnumber
	 * @param material
	 * @param size
	 * @param storagelocation
	 * @param enabled
	 * @param remarks
	 * @param imageUrl01
	 * @param imageUrl02
	 * @param imageUrl03
	 * @param imageUrl04
	 * @param createdate
	 * @param updatedate
	 * @param reserveArea01_String
	 * @param reserveArea02_String
	 * @param reserveArea03_String
	 * @param reserveArea04_String
	 * @param reserveArea01_Boolean
	 * @param reserveArea02_Boolean
	 * @param reserveArea03_Boolean
	 */
	public SerializeHRDFabricInfoEntity(Long id, int controlnumber, String material, String size, String storagelocation,
			Boolean enabled, String remarks, String imageUrl01, String imageUrl02, String imageUrl03, String imageUrl04,
			String createdate, String updatedate, String reserveArea01_String, String reserveArea02_String, String reserveArea03_String,
			String reserveArea04_String, Boolean reserveArea01_Boolean, Boolean reserveArea02_Boolean, Boolean reserveArea03_Boolean){
		this.Id = id; this.ControlNumber = controlnumber; this.Material = material; this.Size = size; this.StorageLocation = storagelocation;
		this.Enabled = enabled; this.Remarks = remarks; this.ImageUrl01 = imageUrl01; this.ImageUrl02 = imageUrl02;
		this.ImageUrl03 = imageUrl03; this.ImageUrl04 = imageUrl04; this.CreateDate = createdate; this.UpdateDate = updatedate;
		this.ReserveArea01_String = reserveArea01_String; this.ReserveArea02_String = reserveArea02_String;
		this.ReserveArea03_String = reserveArea03_String; this.ReserveArea04_String = reserveArea04_String;
		this.ReserveArea01_Boolean = reserveArea01_Boolean; this.ReserveArea02_Boolean = reserveArea02_Boolean;
		this.ReserveArea03_Boolean = reserveArea03_Boolean;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getControlNumber() {
		return ControlNumber;
	}

	public void setControlNumber(int controlNumber) {
		ControlNumber = controlNumber;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getStorageLocation() {
		return StorageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		StorageLocation = storageLocation;
	}

	public Boolean getEnabled() {
		return Enabled;
	}

	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getImageUrl01() {
		return ImageUrl01;
	}

	public void setImageUrl01(String imageUrl01) {
		ImageUrl01 = imageUrl01;
	}

	public String getImageUrl02() {
		return ImageUrl02;
	}

	public void setImageUrl02(String imageUrl02) {
		ImageUrl02 = imageUrl02;
	}

	public String getImageUrl03() {
		return ImageUrl03;
	}

	public void setImageUrl03(String imageUrl03) {
		ImageUrl03 = imageUrl03;
	}

	public String getImageUrl04() {
		return ImageUrl04;
	}

	public void setImageUrl04(String imageUrl04) {
		ImageUrl04 = imageUrl04;
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

	public Boolean getReserveArea01_Boolean() {
		return ReserveArea01_Boolean;
	}

	public void setReserveArea01_Boolean(Boolean reserveArea01_Boolean) {
		ReserveArea01_Boolean = reserveArea01_Boolean;
	}

	public Boolean getReserveArea02_Boolean() {
		return ReserveArea02_Boolean;
	}

	public void setReserveArea02_Boolean(Boolean reserveArea02_Boolean) {
		ReserveArea02_Boolean = reserveArea02_Boolean;
	}

	public Boolean getReserveArea03_Boolean() {
		return ReserveArea03_Boolean;
	}

	public void setReserveArea03_Boolean(Boolean reserveArea03_Boolean) {
		ReserveArea03_Boolean = reserveArea03_Boolean;
	}

}
