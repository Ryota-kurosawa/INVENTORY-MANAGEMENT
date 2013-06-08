package com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SerializeHRDFabricCountingResultEntity implements IsSerializable{
	private Long id;
	private String section;
	private String name;
	private String voted;
	private String inputdate;
	private Boolean deleteflg;
	/**
	 * コンストラクタ
	 */
	public SerializeHRDFabricCountingResultEntity(){

	}

	/**
	 * コンストラクタ
	 * @param ID
	 * @param SECTION
	 * @param NAME
	 * @param VOTED
	 * @param INPUTDATE
	 */
	public SerializeHRDFabricCountingResultEntity(Long ID, String SECTION, String NAME, String VOTED, String INPUTDATE, Boolean DELETEFLG){
		this.id = ID;
		this.section = SECTION;
		this.name = NAME;
		this.voted = VOTED;
		this.inputdate = INPUTDATE;
		this.deleteflg = DELETEFLG;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVoted() {
		return voted;
	}

	public void setVoted(String voted) {
		this.voted = voted;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public Boolean getDeleteflg() {
		return deleteflg;
	}

	public void setDeleteflg(Boolean deleteflg) {
		this.deleteflg = deleteflg;
	}



}
