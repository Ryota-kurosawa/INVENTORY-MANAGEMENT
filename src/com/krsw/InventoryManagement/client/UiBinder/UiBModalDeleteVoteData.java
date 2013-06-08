
package com.krsw.InventoryManagement.client.UiBinder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.FormLabel;
import com.github.gwtbootstrap.client.ui.ProgressBar;
import com.google.gwt.user.client.ui.Image;
import com.github.gwtbootstrap.client.ui.Badge;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.AddHRDFabricTotalizationService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.AddHRDFabricTotalizationServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.AddHRDFabricCountingResultService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.AddHRDFabricCountingResultServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.FetchHRDFabricCountingResultService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.FetchHRDFabricCountingResultServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.SerializeHRDFabricCountingResultEntity;
import com.google.gwt.event.dom.client.BlurEvent;

public class UiBModalDeleteVoteData extends Composite implements HasText {

	private static UiBModalDeleteVoteDataUiBinder uiBinder = GWT.create(UiBModalDeleteVoteDataUiBinder.class);
	@UiField com.github.gwtbootstrap.client.ui.Button btn_delete;
	@UiField PasswordTextBox passwordtxtbox_deletepass;
	@UiField FormLabel fmlbl_discription;
	@UiField Image image_Spin;
	@UiField Badge badge_Survey;
//	@UiField ProgressBar progressbar;

	interface UiBModalDeleteVoteDataUiBinder extends UiBinder<Widget, UiBModalDeleteVoteData> {
	}

	private final AddHRDFabricInfoEntityServiceAsync AddStorageInfoAsync = GWT.create(AddHRDFabricInfoEntityService.class);
	private final FetchHRDFabricInfoEntityServiceAsync FetchFabricInfoAsync = GWT.create(FetchHRDFabricInfoEntityService.class);
	private final FetchHRDFabricCountingResultServiceAsync FetchFabricCountingResultAsync = GWT.create(FetchHRDFabricCountingResultService.class);
	private final AddHRDFabricCountingResultServiceAsync AddFabricCountingDataAsync = GWT.create(AddHRDFabricCountingResultService.class);
	private final AddHRDFabricTotalizationServiceAsync AddFabricTotalizationAsync = GWT.create(AddHRDFabricTotalizationService.class);

	public UiBModalDeleteVoteData() {
		initWidget(uiBinder.createAndBindUi(this));
		btn_delete.setEnabled(false);
		image_Spin.setVisible(false);
		badge_Survey.setVisible(false);
//		progressbar.setVisible(false);
	}

	public UiBModalDeleteVoteData(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	@UiHandler("btn_delete")
	void onBtn_deleteClick(ClickEvent event) {

		if(Window.confirm("削除すると二度と復元できませんがよろしいですか?") == false){
			return;
		}
		if(Window.confirm("「削除してしまいました!てへぺろ☆(・ω<)」では済まないかもしれませんがよろしいですか?") == false){
			return;
		}
		final DateTimeFormat formati18YMD = DateTimeFormat.getFormat("yyyy年MM月dd日");
		Calendar now = Calendar.getInstance();
	      int h = now.get(now.HOUR_OF_DAY);
	      int m = now.get(now.MINUTE);
	      int s = now.get(now.SECOND);
		//�f�[�^�o�^��
		final String DeleteDate = formati18YMD.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
//		progressbar.setVisible(true);
		image_Spin.setVisible(true);
//		progressbar.setPercent(10);
//		progressbar.setPercent(20);
//		progressbar.setPercent(30);
		AsyncCallback<List<SerializeHRDFabricInfoEntity>> callback = new AsyncCallback<List<SerializeHRDFabricInfoEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert("削除対象データ取得中に例外が発生しました。" + "AsyncCallback<List<SerializeHRDFabricInfoEntity>>" + caught.getLocalizedMessage());
			}
			public void onSuccess(List<SerializeHRDFabricInfoEntity> result) {
				for(int i = 0; i <= result.size();){
					AddStorageInfoAsync.AddFabricInfo(result.get(i).getId(), result.get(i).getControlNumber(), result.get(i).getMaterial(), result.get(i).getSize(),
							result.get(i).getStorageLocation(), result.get(i).getEnabled(), result.get(i).getRemarks(), result.get(i).getImageUrl01(), result.get(i).getImageUrl02(),
							result.get(i).getImageUrl03(), result.get(i).getImageUrl04(), result.get(i).getCreateDate(), result.get(i).getUpdateDate(), result.get(i).getReserveArea01_String(), "",
							result.get(i).getReserveArea03_String(), result.get(i).getReserveArea04_String(), result.get(i).getReserveArea01_Boolean(), result.get(i).getReserveArea02_Boolean(),
							result.get(i).getReserveArea03_Boolean(), new AsyncCallback(){
								public void onFailure(Throwable caught) {
									Window.alert("削除対象データ削除中に例外が発生しました。" + "AddStorageInfoAsync.AddFabricInfo" + caught.getLocalizedMessage());
								}
								public void onSuccess(Object result) {
//									progressbar.setPercent(40);
								}
					});
					i++;
				}
			}
		};
		FetchFabricInfoAsync.getAvailabilityRange("", callback);

		AsyncCallback<List<SerializeHRDFabricCountingResultEntity>> callback2 = new AsyncCallback<List<SerializeHRDFabricCountingResultEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert("削除対象データ取得中に例外が発生しました。" + "AsyncCallback<List<SerializeHRDFabricCountingResultEntity>>" + caught.getLocalizedMessage());
			}
			public void onSuccess(List<SerializeHRDFabricCountingResultEntity> result) {
				for(int i = 0; i <= result.size();){
					AddFabricCountingDataAsync.AddFabricCountingResult(result.get(i).getId(), result.get(i).getSection(), result.get(i).getName(),
							result.get(i).getVoted(), result.get(i).getInputdate(), false, new AsyncCallback(){
								public void onFailure(Throwable caught) {
									Window.alert("削除対象データ削除中に例外が発生しました。" + "AddFabricCountingDataAsync.AddFabricCountingResult" + caught.getLocalizedMessage());
								}
								public void onSuccess(Object result) {
//									progressbar.setPercent(80);
								}
					});
					i++;
				}
			}
		};
		FetchFabricCountingResultAsync.getRange(0, 0, callback2);
		final Long UID = (long) 000001;
		AddFabricTotalizationAsync.AddHRDFabricTotalization(UID, 0, 0, 0, 0, 0, 0, 0,0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, DeleteDate, new AsyncCallback(){
					public void onFailure(Throwable caught) {
						Window.alert("削除対象データ削除中に例外が発生しました。" + "AddFabricTotalizationAsync.AddHRDFabricTotalization" + caught.getLocalizedMessage());
					}
					public void onSuccess(Object result) {
//						progressbar.setPercent(100);
						Window.alert("削除完了");
					}
		});
		image_Spin.setVisible(false);
//		progressbar.setVisible(false);
		badge_Survey.setVisible(true);
	}
	@UiHandler("passwordtxtbox_deletepass")
	void onPasswordtxtbox_deletepassBlur(BlurEvent event) {
		if(passwordtxtbox_deletepass.getText() == "deleteok"){
			btn_delete.setEnabled(true);
		}else{
			btn_delete.setEnabled(false);
			Window.alert("パスワードが違います。");
		}
	}
}
