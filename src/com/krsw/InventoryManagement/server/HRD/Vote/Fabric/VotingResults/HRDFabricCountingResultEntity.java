package com.krsw.InventoryManagement.server.HRD.Vote.Fabric.VotingResults;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION )
public class HRDFabricCountingResultEntity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	//部署
	@Persistent
	private String section;
	//氏名
	@Persistent
	private String name;
	//開票(No)
	@Persistent
	private String voted;
	//投票日時
	@Persistent
	private String inputdate;
	@Persistent
	private Boolean deleteflg;

	/**
	 * コンストラクタ
	 */
	public HRDFabricCountingResultEntity(){
	}
	/**
	 * コンストラクタ
	 * @param ID
	 * @param SECTION
	 * @param NAME
	 * @param VOTED
	 * @param INPUTDATE
	 */
	public HRDFabricCountingResultEntity(Long ID, String SECTION, String NAME, String VOTED, String INPUTDATE, Boolean DELETEFLG){
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
