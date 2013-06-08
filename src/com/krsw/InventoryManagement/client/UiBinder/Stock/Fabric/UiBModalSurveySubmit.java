package com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.github.gwtbootstrap.client.ui.Image;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.SerializeHRDGeneralUserModeEntity;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.AddHRDFabricTotalizationService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.AddHRDFabricTotalizationServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.FetchHRDFabricTotalizationService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.FetchHRDFabricTotalizationServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.SerializeHRDFabricTotalizationEntity;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.AddHRDFabricCountingResultService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.AddHRDFabricCountingResultServiceAsync;
import com.krsw.InventoryManagement.client.Mail.EmailService;
import com.krsw.InventoryManagement.client.Mail.EmailServiceAsync;
import com.krsw.InventoryManagement.client.Mail.EmailService.COMMAND;
import com.krsw.InventoryManagement.server.HRD.Stock.Fabric.HRDFabricInfoEntity;
import com.krsw.InventoryManagement.shared.FieldVerifier;
import com.github.gwtbootstrap.client.ui.Button;

public class UiBModalSurveySubmit extends Composite implements HasText {

	private static UiBModalSurveySubmitUiBinder uiBinder = GWT.create(UiBModalSurveySubmitUiBinder.class);
	@UiField Image img_Spin;
	@UiField Label lbl_End;
	@UiField TextBox txtbox_Name;
	@UiField ListBox cmb_searchBusho;
	@UiField Button btn_Send;
	String sendAddress01;
	String sendAddress02;
	List<Integer> _controlNumberList = new ArrayList<Integer>();
	String lstring = ",";
	int NOint[] = new int[100];
	int INT_NO1 = 0;
	int INT_NO2 = 0;
	int INT_NO3 = 0;
	int INT_NO4 = 0;
	int INT_NO5 = 0;
	int INT_NO6 = 0;
	int INT_NO7 = 0;
	int INT_NO8 = 0;
	int INT_NO9 = 0;
	int INT_NO10 = 0;
	int INT_NO11 = 0;
	int INT_NO12 = 0;
	int INT_NO13 = 0;
	int INT_NO14 = 0;
	int INT_NO15 = 0;
	int INT_NO16 = 0;
	int INT_NO17 = 0;
	int INT_NO18 = 0;
	int INT_NO19 = 0;
	int INT_NO20 = 0;
	int INT_NO21 = 0;
	int INT_NO22 = 0;
	int INT_NO23 = 0;
	int INT_NO24 = 0;
	int INT_NO25 = 0;
	int INT_NO26 = 0;
	int INT_NO27 = 0;
	int INT_NO28 = 0;
	int INT_NO29 = 0;
	int INT_NO30 = 0;
	int INT_NO31 = 0;
	int INT_NO32 = 0;
	int INT_NO33 = 0;
	int INT_NO34 = 0;
	int INT_NO35 = 0;
	int INT_NO36 = 0;
	int INT_NO37 = 0;
	int INT_NO38 = 0;
	int INT_NO39 = 0;
	int INT_NO40 = 0;
	int INT_NO41 = 0;
	int INT_NO42 = 0;
	int INT_NO43 = 0;
	int INT_NO44 = 0;
	int INT_NO45 = 0;
	int INT_NO46 = 0;
	int INT_NO47 = 0;
	int INT_NO48 = 0;
	int INT_NO49 = 0;
	int INT_NO50 = 0;
	int INT_NO51 = 0;
	int INT_NO52 = 0;
	int INT_NO53 = 0;
	int INT_NO54 = 0;
	int INT_NO55 = 0;
	int INT_NO56 = 0;
	int INT_NO57 = 0;
	int INT_NO58 = 0;
	int INT_NO59 = 0;
	int INT_NO60 = 0;
	int INT_NO61 = 0;
	int INT_NO62 = 0;
	int INT_NO63 = 0;
	int INT_NO64 = 0;
	int INT_NO65 = 0;
	int INT_NO66 = 0;
	int INT_NO67 = 0;
	int INT_NO68 = 0;
	int INT_NO69 = 0;
	int INT_NO70 = 0;
	int INT_NO71 = 0;
	int INT_NO72 = 0;
	int INT_NO73 = 0;
	int INT_NO74 = 0;
	int INT_NO75 = 0;
	int INT_NO76 = 0;
	int INT_NO77 = 0;
	int INT_NO78 = 0;
	int INT_NO79 = 0;
	int INT_NO80 = 0;
	int INT_NO81 = 0;
	int INT_NO82 = 0;
	int INT_NO83 = 0;
	int INT_NO84 = 0;
	int INT_NO85 = 0;
	int INT_NO86 = 0;
	int INT_NO87 = 0;
	int INT_NO88 = 0;
	int INT_NO89 = 0;
	int INT_NO90 = 0;
	int INT_NO91 = 0;
	int INT_NO92 = 0;
	int INT_NO93 = 0;
	int INT_NO94 = 0;
	int INT_NO95 = 0;
	int INT_NO96 = 0;
	int INT_NO97 = 0;
	int INT_NO98 = 0;
	int INT_NO99 = 0;
	int INT_NO100 = 0;

	interface UiBModalSurveySubmitUiBinder extends UiBinder<Widget, UiBModalSurveySubmit> {
	}

	private final AddHRDFabricCountingResultServiceAsync AddFabricCountingDataAsync = GWT.create(AddHRDFabricCountingResultService.class);
	private final AddHRDFabricTotalizationServiceAsync AddFabricTotalizationAsync = GWT.create(AddHRDFabricTotalizationService.class);
	private final FetchHRDFabricTotalizationServiceAsync FetchFabricTotalizationAsync = GWT.create(FetchHRDFabricTotalizationService.class);
	private final FetchHRDGeneralUserModeEntityServiceAsync FetchUserModeAsync = GWT.create(FetchHRDGeneralUserModeEntityService.class);
	private final FetchHRDFabricInfoEntityServiceAsync FetchFabricInfoAsync = GWT.create(FetchHRDFabricInfoEntityService.class);
	private final AddHRDFabricInfoEntityServiceAsync AddFabricInfoAsync = GWT.create(AddHRDFabricInfoEntityService.class);
	public UiBModalSurveySubmit() {
		initWidget(uiBinder.createAndBindUi(this));
		img_Spin.setVisible(false);
	}

	public UiBModalSurveySubmit(final List<Integer> controlNumberList) {
		initWidget(uiBinder.createAndBindUi(this));
		_controlNumberList = controlNumberList;
		AsyncCallback<List<SerializeHRDGeneralUserModeEntity>> usermodecallback = new AsyncCallback<List<SerializeHRDGeneralUserModeEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(this.getClass() + "FetchUserModeAsync.getStatusLabel" + caught.getLocalizedMessage());
			}
			public void onSuccess(List<SerializeHRDGeneralUserModeEntity> result) {
				sendAddress01 = result.get(0).getReserveArea01_String();
				sendAddress02 = result.get(0).getReserveArea02_String();
			}
		};
		FetchUserModeAsync.getStatusLabel("", usermodecallback);
		setTabOrder();
		lbl_End.setVisible(false);
		img_Spin.setVisible(false);
		FieldVerifier.createSectionBox(cmb_searchBusho);
		final AsyncCallback<List<SerializeHRDFabricTotalizationEntity>> callback = new AsyncCallback<List<SerializeHRDFabricTotalizationEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage() + "SerializeHRDFabricTotalizationEntity");
			}
			public void onSuccess(List<SerializeHRDFabricTotalizationEntity> result) {
				for(SerializeHRDFabricTotalizationEntity serial : result){
					INT_NO1 = serial.getNo1();INT_NO2 = serial.getNo2();
					INT_NO3 = serial.getNo3();INT_NO4 = serial.getNo4();
					INT_NO5 = serial.getNo5();INT_NO6 = serial.getNo6();
					INT_NO7 = serial.getNo7();INT_NO8 = serial.getNo8();
					INT_NO9 = serial.getNo9();INT_NO10 = serial.getNo10();
					INT_NO11 = serial.getNo11();INT_NO12 = serial.getNo12();
					INT_NO13 = serial.getNo13();INT_NO14 = serial.getNo14();
					INT_NO15 = serial.getNo15();INT_NO16 = serial.getNo16();
					INT_NO17 = serial.getNo17();INT_NO18 = serial.getNo18();
					INT_NO19 = serial.getNo19();INT_NO20 = serial.getNo20();
					INT_NO21 = serial.getNo21();INT_NO22 = serial.getNo22();
					INT_NO23 = serial.getNo23();INT_NO24 = serial.getNo24();
					INT_NO25 = serial.getNo25();INT_NO26 = serial.getNo26();
					INT_NO27 = serial.getNo27();INT_NO28 = serial.getNo28();
					INT_NO29 = serial.getNo29();INT_NO30 = serial.getNo30();
					INT_NO31 = serial.getNo31();INT_NO32 = serial.getNo32();
					INT_NO33 = serial.getNo33();INT_NO34 = serial.getNo34();
					INT_NO35 = serial.getNo35();INT_NO36 = serial.getNo36();
					INT_NO37 = serial.getNo37();INT_NO38 = serial.getNo38();
					INT_NO39 = serial.getNo39();INT_NO40 = serial.getNo40();
					INT_NO41 = serial.getNo41();INT_NO42 = serial.getNo42();
					INT_NO43 = serial.getNo43();INT_NO44 = serial.getNo44();
					INT_NO45 = serial.getNo45();INT_NO46 = serial.getNo46();
					INT_NO47 = serial.getNo47();INT_NO48 = serial.getNo48();
					INT_NO49 = serial.getNo49();INT_NO50 = serial.getNo50();
					INT_NO51 = serial.getNo51();INT_NO52 = serial.getNo52();
					INT_NO53 = serial.getNo53();INT_NO54 = serial.getNo54();
					INT_NO55 = serial.getNo55();INT_NO56 = serial.getNo56();
					INT_NO57 = serial.getNo57();INT_NO58 = serial.getNo58();
					INT_NO59 = serial.getNo59();INT_NO60 = serial.getNo60();
					INT_NO61 = serial.getNo61();INT_NO62 = serial.getNo62();
					INT_NO63 = serial.getNo63();INT_NO64 = serial.getNo64();
					INT_NO65 = serial.getNo65();INT_NO66 = serial.getNo66();
					INT_NO67 = serial.getNo67();INT_NO68 = serial.getNo68();
					INT_NO69 = serial.getNo69();INT_NO70 = serial.getNo70();
					INT_NO71 = serial.getNo71();INT_NO72 = serial.getNo72();
					INT_NO73 = serial.getNo73();INT_NO74 = serial.getNo74();
					INT_NO75 = serial.getNo75();INT_NO76 = serial.getNo76();
					INT_NO77 = serial.getNo77();INT_NO78 = serial.getNo78();
					INT_NO79 = serial.getNo79();INT_NO80 = serial.getNo80();
					INT_NO81 = serial.getNo81();INT_NO82 = serial.getNo82();
					INT_NO83 = serial.getNo83();INT_NO84 = serial.getNo84();
					INT_NO85 = serial.getNo85();INT_NO86 = serial.getNo86();
					INT_NO87 = serial.getNo87();INT_NO88 = serial.getNo88();
					INT_NO89 = serial.getNo89();INT_NO90 = serial.getNo90();
					INT_NO91 = serial.getNo91();INT_NO92 = serial.getNo92();
					INT_NO93 = serial.getNo93();INT_NO94 = serial.getNo94();
					INT_NO95 = serial.getNo95();INT_NO96 = serial.getNo96();
					INT_NO97 = serial.getNo97();INT_NO98 = serial.getNo98();
					INT_NO99 = serial.getNo99();INT_NO100 = serial.getNo100();
				}
				int i = 0;
				int j = 0;
				for(; i <= controlNumberList.size() - 1;){
						switch(controlNumberList.get(i)){
						case 1:	INT_NO1 += 1; break;
						case 2: INT_NO2 += 1; break;
						case 3:	INT_NO3 += 1; break;
						case 4:	INT_NO4 += 1; break;
						case 5: INT_NO5	+= 1; break;
						case 6:	INT_NO6	+= 1; break;
						case 7:	INT_NO7	+= 1; break;
						case 8:	INT_NO8	+= 1; break;
						case 9:	INT_NO9	+= 1; break;
						case 10: INT_NO10 += 1; break;
						case 11: INT_NO11 += 1; break;
						case 12: INT_NO12 += 1; break;
						case 13: INT_NO13 += 1; break;
						case 14: INT_NO14 += 1; break;
						case 15: INT_NO15 += 1; break;
						case 16: INT_NO16 += 1; break;
						case 17: INT_NO17 += 1; break;
						case 18: INT_NO18 += 1; break;
						case 19: INT_NO19 += 1; break;
						case 20: INT_NO20 += 1; break;
						case 21: INT_NO21 += 1; break;
						case 22: INT_NO22 += 1; break;
						case 23: INT_NO23 += 1; break;
						case 24: INT_NO24 += 1; break;
						case 25: INT_NO25 += 1; break;
						case 26: INT_NO26 += 1; break;
						case 27: INT_NO27 += 1; break;
						case 28: INT_NO28 += 1; break;
						case 29: INT_NO29 += 1; break;
						case 30: INT_NO30 += 1; break;
						case 31: INT_NO31 += 1; break;
						case 32: INT_NO32 += 1; break;
						case 33: INT_NO33 += 1; break;
						case 34: INT_NO34 += 1; break;
						case 35: INT_NO35 += 1; break;
						case 36: INT_NO36 += 1; break;
						case 37: INT_NO37 += 1; break;
						case 38: INT_NO38 += 1; break;
						case 39: INT_NO39 += 1; break;
						case 40: INT_NO40 += 1; break;
						case 41: INT_NO41 += 1; break;
						case 42: INT_NO42 += 1; break;
						case 43: INT_NO43 += 1; break;
						case 44: INT_NO44 += 1; break;
						case 45: INT_NO45 += 1; break;
						case 46: INT_NO46 += 1; break;
						case 47: INT_NO47 += 1; break;
						case 48: INT_NO48 += 1; break;
						case 49: INT_NO49 += 1; break;
						case 50: INT_NO50 += 1; break;
						case 51: INT_NO51 += 1; break;
						case 52: INT_NO52 += 1; break;
						case 53: INT_NO53 += 1; break;
						case 54: INT_NO54 += 1; break;
						case 55: INT_NO55 += 1; break;
						case 56: INT_NO56 += 1; break;
						case 57: INT_NO57 += 1; break;
						case 58: INT_NO58 += 1; break;
						case 59: INT_NO59 += 1; break;
						case 60: INT_NO60 += 1; break;
						case 61: INT_NO61 += 1; break;
						case 62: INT_NO62 += 1; break;
						case 63: INT_NO63 += 1; break;
						case 64: INT_NO64 += 1; break;
						case 65: INT_NO65 += 1; break;
						case 66: INT_NO66 += 1; break;
						case 67: INT_NO67 += 1; break;
						case 68: INT_NO68 += 1; break;
						case 69: INT_NO69 += 1; break;
						case 70: INT_NO70 += 1; break;
						case 71: INT_NO71 += 1; break;
						case 72: INT_NO72 += 1; break;
						case 73: INT_NO73 += 1; break;
						case 74: INT_NO74 += 1; break;
						case 75: INT_NO75 += 1; break;
						case 76: INT_NO76 += 1; break;
						case 77: INT_NO77 += 1; break;
						case 78: INT_NO78 += 1; break;
						case 79: INT_NO79 += 1; break;
						case 80: INT_NO80 += 1; break;
						case 81: INT_NO81 += 1; break;
						case 82: INT_NO82 += 1; break;
						case 83: INT_NO83 += 1; break;
						case 84: INT_NO84 += 1; break;
						case 85: INT_NO85 += 1; break;
						case 86: INT_NO86 += 1; break;
						case 87: INT_NO87 += 1; break;
						case 88: INT_NO88 += 1; break;
						case 89: INT_NO89 += 1; break;
						case 90: INT_NO90 += 1; break;
						case 91: INT_NO91 += 1; break;
						case 92: INT_NO92 += 1; break;
						case 93: INT_NO93 += 1; break;
						case 94: INT_NO94 += 1; break;
						case 95: INT_NO95 += 1; break;
						case 96: INT_NO96 += 1; break;
						case 97: INT_NO97 += 1; break;
						case 98: INT_NO98 += 1; break;
						case 99: INT_NO99 += 1; break;
						case 100: INT_NO100 += 1; break;
						}
					lstring += controlNumberList.get(i).toString() + ",";
					i++;
				}
			}
		};
		FetchFabricTotalizationAsync.getRange(0, 0, callback);
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	public String getTxtbox_Name() {
		return txtbox_Name.getText();
	}

	public void setTxtbox_Name(String txtbox_Name) {
		this.txtbox_Name.setText(txtbox_Name);
	}

	public String getCmb_searchBusho() {
		return cmb_searchBusho.getValue(cmb_searchBusho.getSelectedIndex());
	}

	public void setCmb_searchBusho(ListBox cmb_searchBusho) {
		this.cmb_searchBusho = cmb_searchBusho;
	}

	@UiHandler("btn_Send")
	void onBtn_sendClick(ClickEvent event) {
		if(cmb_searchBusho.getSelectedIndex() == 0){
			Window.alert("リストから部門を選択してください。");
			return;
		}
		if(txtbox_Name.getText() == ""){
			Window.alert("氏名を入力してください.");
			return;
		}
		img_Spin.setVisible(true);
		btn_Send.setVisible(false);
		//幕番号で検索
		AsyncCallback<List<SerializeHRDFabricInfoEntity>>fabriccallback = new AsyncCallback<List<SerializeHRDFabricInfoEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(this.getClass() + "FetchFabricInfoAsync" + caught.getLocalizedMessage());
			}
			@SuppressWarnings("rawtypes")
			public void onSuccess(final List<SerializeHRDFabricInfoEntity> result) {
				for(int i = 0; i <= result.size();){
					for(int j = 0; j <= result.size();){
						if(_controlNumberList.get(i) == result.get(j).getControlNumber()){
							//同じコントロールナンバーの場合は登録処理
							AddFabricInfoAsync.AddFabricInfo(result.get(j).getId(), result.get(j).getControlNumber(), result.get(j).getMaterial(), result.get(j).getSize(),
									result.get(j).getStorageLocation(), result.get(j).getEnabled(), result.get(j).getRemarks(), result.get(j).getImageUrl01(), result.get(j).getImageUrl02(),
									result.get(j).getImageUrl03(), result.get(j).getImageUrl04(), result.get(j).getCreateDate(), result.get(j).getUpdateDate(), result.get(j).getReserveArea01_String(),
									result.get(j).getReserveArea02_String() + txtbox_Name.getText() + ",", result.get(j).getReserveArea03_String(), result.get(j).getReserveArea04_String(),
									result.get(j).getReserveArea01_Boolean(), result.get(j).getReserveArea02_Boolean(), result.get(j).getReserveArea03_Boolean(), new AsyncCallback(){
										public void onFailure(Throwable caught) {
											Window.alert(caught.getLocalizedMessage() + "AddFabricInfoAsync.AddFabricInfo");
										}
										public void onSuccess(Object oresult) {
//											Window.alert("登録完了");
										}
							});
							break;
						}
						j++;
					}
					 i++;
				}
			}
		};
		FetchFabricInfoAsync.getRange(0, 0, fabriccallback);

		final DateTimeFormat formati18YMD = DateTimeFormat.getFormat("yyyy年MM月dd日");
		Calendar now = Calendar.getInstance();
	      int h = now.get(now.HOUR_OF_DAY);
	      int m = now.get(now.MINUTE);
	      int s = now.get(now.SECOND);
		//データ登録日時
		final String InputDate = formati18YMD.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
		final Long UID = (long) 000001;
		AddFabricTotalizationAsync.AddHRDFabricTotalization(UID, INT_NO1, INT_NO2, INT_NO3, INT_NO4, INT_NO5, INT_NO6, INT_NO7,INT_NO8, INT_NO9, INT_NO10,
				INT_NO11, INT_NO12, INT_NO13, INT_NO14, INT_NO15, INT_NO16, INT_NO17, INT_NO18, INT_NO19, INT_NO20,
				INT_NO21, INT_NO22, INT_NO23, INT_NO24, INT_NO25, INT_NO26, INT_NO27, INT_NO28, INT_NO29, INT_NO30,
				INT_NO31, INT_NO32, INT_NO33, INT_NO34, INT_NO35, INT_NO36, INT_NO37, INT_NO38, INT_NO39, INT_NO40,
				INT_NO41, INT_NO42, INT_NO43, INT_NO44, INT_NO45, INT_NO46, INT_NO47, INT_NO48, INT_NO49, INT_NO50,
				INT_NO51, INT_NO52, INT_NO53, INT_NO54, INT_NO55, INT_NO56, INT_NO57, INT_NO58, INT_NO59, INT_NO60,
				INT_NO61, INT_NO62, INT_NO63, INT_NO64, INT_NO65, INT_NO66, INT_NO67, INT_NO68, INT_NO69, INT_NO70,
				INT_NO71, INT_NO72, INT_NO73, INT_NO74, INT_NO75, INT_NO76, INT_NO77, INT_NO78, INT_NO79, INT_NO80,
				INT_NO81, INT_NO82, INT_NO83, INT_NO84, INT_NO85, INT_NO86, INT_NO87, INT_NO88, INT_NO89, INT_NO90,
				INT_NO91, INT_NO92, INT_NO93, INT_NO94, INT_NO95, INT_NO96, INT_NO97, INT_NO98, INT_NO99, INT_NO100, InputDate, new AsyncCallback(){
					public void onFailure(Throwable caught) {
						Window.alert("送信に失敗しました. AddFabricTotalizationAsync" + caught.getMessage());
					}
					@SuppressWarnings("rawtypes")
					public void onSuccess(Object result) {
//						btn_Send.setText("終了");
//						btn_Send.setVisible(true);
					}
		});
		AddFabricCountingDataAsync.AddFabricCountingResult(null, getCmb_searchBusho(), txtbox_Name.getText(), lstring, InputDate, true, new AsyncCallback(){
			public void onFailure(Throwable caught) {
				Window.alert("送信に失敗しました.AddFabricCountingDataAsync" + caught.getMessage());
				img_Spin.setVisible(false);
			}
			public void onSuccess(Object result) {
				final EmailServiceAsync emailServiceAsync = GWT.create(EmailService.class);
				emailServiceAsync.sendMail("hinkan001@gmail.com", sendAddress02,
						"【千葉スタジオ有り物幕 投票完了お知らせメール】", COMMAND.BCC,
						"smz-inventorymanagement.appspot.com",
						getCmb_searchBusho() + "　" + txtbox_Name.getText() + "さんが投票しました." + "\n" +
						"管理者アカウントで下記URLにログインして確認してください。\n" +
						"http://smz-inventorymanagement.appspot.com",
						new AsyncCallback() {
							public void onFailure(Throwable caught) {
								Window.alert("emailServiceAsync - 01" + caught.getMessage());
							}
							public void onSuccess(Object result) {
//								Window.alert("終了します。お疲れ様でした。");
//								Window.Location.reload();
							}
				});
				emailServiceAsync.sendMail("hinkan001@gmail.com", sendAddress01,
						"【千葉スタジオ有り物幕 投票完了お知らせメール】", COMMAND.BCC,
						"smz-inventorymanagement.appspot.com",
						getCmb_searchBusho() + "　" + txtbox_Name.getText() + "さんが投票しました." + "\n" +
						"ID:006201/PW:smzS6201 で下記URLにログインして、\n" +
						"管理者アカウントで下記URLにログインして確認してください。\n" +
						"http://smz-inventorymanagement.appspot.com",
						new AsyncCallback() {
							public void onFailure(Throwable caught) {
								Window.alert("emailServiceAsync - 02" + caught.getMessage());
							}
							public void onSuccess(Object result) {
								Window.alert("終了します。お疲れ様でした。");
								Window.Location.reload();
							}
				});
				lbl_End.setVisible(true);
				img_Spin.setVisible(false);
			}
		});
	}
	private void setTabOrder(){
		cmb_searchBusho.setTabIndex(0);
		txtbox_Name.setTabIndex(1);
		btn_Send.setTabIndex(2);
	}
}
