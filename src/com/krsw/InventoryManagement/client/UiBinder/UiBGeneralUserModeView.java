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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.krsw.InventoryManagement.client.HRD.ViewMode.AddHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.AddHRDGeneralUserModeEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.SerializeHRDGeneralUserModeEntity;
import com.google.gwt.user.client.ui.Image;
import com.github.gwtbootstrap.client.ui.Badge;
import com.github.gwtbootstrap.client.ui.TextBox;

public class UiBGeneralUserModeView extends Composite implements HasText {

	private static UiBGeneralUserModeViewUiBinder uiBinder = GWT.create(UiBGeneralUserModeViewUiBinder.class);
//	@UiField LayoutPanel layoutpanel;
	@UiField HTMLPanel htmlpanel;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_radio_standard;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_radio_survey;
	@UiField Image image_spin;
	@UiField Badge badge_survey;
	@UiField Badge badge_general;
	@UiField TextBox txtbox_sendAddress01;
	@UiField TextBox txtbox_sendAddress02;
	String loginusername;
	String sendAddress01;
	String sendAddress02;

	interface UiBGeneralUserModeViewUiBinder extends UiBinder<Widget, UiBGeneralUserModeView> {
	}

	//一般ユーザーモードの設定用
	private final AddHRDGeneralUserModeEntityServiceAsync AddUserModeAsync = GWT.create(AddHRDGeneralUserModeEntityService.class);
	private final FetchHRDGeneralUserModeEntityServiceAsync FetchUserModeAsync = GWT.create(FetchHRDGeneralUserModeEntityService.class);

	public UiBGeneralUserModeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public UiBGeneralUserModeView(String LoginUserName) {
		initWidget(uiBinder.createAndBindUi(this));
		badge_survey.setVisible(false);
		badge_general.setVisible(false);
		image_spin.setVisible(true);
		loginusername = LoginUserName;
		btn_radio_standard.setActive(false);
		btn_radio_survey.setActive(false);
		txtbox_sendAddress01.setEnabled(false);
		txtbox_sendAddress02.setEnabled(false);
		AsyncCallback<List<SerializeHRDGeneralUserModeEntity>> usermodecallback = new AsyncCallback<List<SerializeHRDGeneralUserModeEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(this.getClass() + "FetchUserModeAsync.getStatusLabel" + caught.getLocalizedMessage());
			}
			public void onSuccess(List<SerializeHRDGeneralUserModeEntity> result) {
				image_spin.setVisible(false);
				if(result.get(0).getStatus() == "アンケートモード"){
					badge_general.setVisible(false);
					badge_survey.setVisible(true);
					btn_radio_survey.setActive(true);
					sendAddress01 = result.get(0).getReserveArea01_String();
					sendAddress02 = result.get(0).getReserveArea02_String();
					txtbox_sendAddress01.setText(result.get(0).getReserveArea01_String());
					txtbox_sendAddress02.setText(result.get(0).getReserveArea02_String());
					txtbox_sendAddress01.setEnabled(true);
					txtbox_sendAddress02.setEnabled(true);

				}else if(result.get(0).getStatus() == "標準モード"){
					badge_general.setVisible(true);
					badge_survey.setVisible(false);
					btn_radio_standard.setActive(true);
					sendAddress01 = result.get(0).getReserveArea01_String();
					sendAddress02 = result.get(0).getReserveArea02_String();
					txtbox_sendAddress01.setText(result.get(0).getReserveArea01_String());
					txtbox_sendAddress02.setText(result.get(0).getReserveArea02_String());
					txtbox_sendAddress01.setEnabled(false);
					txtbox_sendAddress02.setEnabled(false);
				}
			}
		};
		FetchUserModeAsync.getStatusLabel("", usermodecallback);
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	@UiHandler("btn_radio_standard")
	void onBtn_radio_standardClick(ClickEvent event) {
		if(btn_radio_standard.isActive()){
			return;
		}
		image_spin.setVisible(true);
//		if(StatusLabelString == navLink_ViewMode.getText().toString()){
			//一般ユーザービューモードのテーブル更新処理
			final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
			Calendar now = Calendar.getInstance();
			int h = now.get(now.HOUR_OF_DAY);
			int m = now.get(now.MINUTE);
			int s = now.get(now.SECOND);
			String registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			String updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			AddUserModeAsync.AddHRDGeneralUserModeEntity(Long.valueOf(000001), "標準モード", "アンケートモードに設定する", loginusername, registerDate,
					updateDate, sendAddress01, sendAddress02, new AsyncCallback() {
						public void onFailure(Throwable caught) {
							Window.alert(this.getClass() + caught.getLocalizedMessage() + "AddUserModeAsync.AddHRDGeneralUserModeEntity");
							image_spin.setVisible(false);
						}
						public void onSuccess(Object result) {
							image_spin.setVisible(false);
							Window.alert("標準モードに設定しました。");
							badge_general.setVisible(true);
							badge_survey.setVisible(false);
							txtbox_sendAddress01.setEnabled(false);
							txtbox_sendAddress02.setEnabled(false);
						}
					});
	}
	@UiHandler("btn_radio_survey")
	void onBtn_radio_surveyClick(ClickEvent event) {
		if(btn_radio_survey.isActive()){
			return;
		}
		image_spin.setVisible(true);
//		if(StatusLabelString == navLink_ViewMode.getText().toString()){
		//一般ユーザービューモードのテーブル更新処理
		final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
		Calendar now = Calendar.getInstance();
		int h = now.get(now.HOUR_OF_DAY);
		int m = now.get(now.MINUTE);
		int s = now.get(now.SECOND);
		String registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
		String updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
		AddUserModeAsync.AddHRDGeneralUserModeEntity(Long.valueOf(000001), "アンケートモード", "標準モードに設定する", loginusername, registerDate,
				updateDate, txtbox_sendAddress01.getText().toString(), txtbox_sendAddress02.getText().toString(), new AsyncCallback() {
					public void onFailure(Throwable caught) {
						Window.alert(this.getClass() + caught.getLocalizedMessage() + "AddUserModeAsync.AddHRDGeneralUserModeEntity");
						image_spin.setVisible(false);
					}
					public void onSuccess(Object result) {
						image_spin.setVisible(false);
						Window.alert("アンケートモードに設定しました。");
						badge_general.setVisible(false);
						badge_survey.setVisible(true);
						txtbox_sendAddress01.setEnabled(true);
						txtbox_sendAddress02.setEnabled(true);
					}
				});
	}
}
