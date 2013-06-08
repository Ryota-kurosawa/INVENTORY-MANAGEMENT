package com.krsw.InventoryManagement.client.UiBinder;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.WellForm;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Image;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Accounts.SerializeHRDBasicUserInfoEntity;
import com.krsw.InventoryManagement.client.HRD.Logging.AddHRDLoggingUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Logging.AddHRDLoggingUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.SerializeHRDGeneralUserModeEntity;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBGeneralUserFabricListSurveyView;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBGeneralUserFabricListView;
import com.krsw.InventoryManagement.shared.HashUtilMD5;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.github.gwtbootstrap.client.ui.HelpBlock;
import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;
import com.github.gwtbootstrap.client.ui.Hero;
import com.github.gwtbootstrap.client.ui.Heading;
import com.github.gwtbootstrap.client.ui.Paragraph;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.github.gwtbootstrap.client.ui.Well;
import com.google.gwt.user.client.ui.LayoutPanel;

public class UiBLogin extends Composite implements HasText {

	private static UiBLoginUiBinder uiBinder = GWT.create(UiBLoginUiBinder.class);
	@UiField HTMLPanel htmlpanel;
//	@UiField WellForm Wellform;
	@UiField Image image;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_Login;
	@UiField PasswordTextBox passtxt_Password;
	@UiField TextBox txtbox_Id;
	@UiField Image img_spin;
//	@UiField HelpBlock helpBlock;
//	@UiField Hero hero;
//	@UiField Heading heading;
	@UiField Paragraph paragraph;
	@UiField HorizontalPanel horizontalpanel;
	@UiField Image image_smz;
//	@UiField Well well01;
	@UiField Well well02;
	@UiField HelpBlock helpblock01;

	interface UiBLoginUiBinder extends UiBinder<Widget, UiBLogin> {
	}
	//一般ユーザーレビューモード設定取得用
	private final FetchHRDGeneralUserModeEntityServiceAsync FetchUserModeAsync = GWT.create(FetchHRDGeneralUserModeEntityService.class);
	//ログ用
	private final AddHRDLoggingUserInfoEntityServiceAsync AddLoggingUserInfoEntityAsync = GWT.create(AddHRDLoggingUserInfoEntityService.class);

	private final FetchHRDBasicUserInfoEntityServiceAsync FetchBasicUserInfoAsync = GWT.create(FetchHRDBasicUserInfoEntityService.class);
	UiBInventoryManagement navbar = new UiBInventoryManagement();
	final RootPanel BrowserRoot_login = RootPanel.get("LoginPNL");
	final RootPanel BrowserRoot_UserBasicInfoView = RootPanel.get("UserBasicInfoViewPNL");



	public UiBLogin() {
		initWidget(uiBinder.createAndBindUi(this));
		BrowserRoot_login.setSize("100%", "100%");
		RootPanel.get().add(navbar);
		img_spin.setVisible(false);
		ResourceInjector.injectResourceCssAsFile("bootstrap-ie7buttonfix.css");

//		UiBModalAlertIE alertie = new UiBModalAlertIE();
//		alertie.setPixelSize(600, 340);
//		final Modal modal = new Modal(true);
//		modal.setPixelSize(640, 390);
//		modal.add(alertie);
//		modal.show();
	}

	public UiBLogin(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getTxtbox_Id() {
		return txtbox_Id.getText();
	}

	public void setTxtbox_Id(TextBox txtbox_Id) {
		this.txtbox_Id = txtbox_Id;
	}

	public String getPasstxt_Password() {
		return passtxt_Password.getValue().toString();
	}

	public void setPasstxt_Password(PasswordTextBox passtxt_Password) {
		this.passtxt_Password = passtxt_Password;
	}

	public String getText() {
		return null;
	}

	private Boolean InputCheck(){
		if( (getTxtbox_Id() == "" || getPasstxt_Password() == "") || (getTxtbox_Id() == "" && getPasstxt_Password() == "")){
			return false;
		}else{
			return true;
		}
	}

	@UiHandler("btn_Login")
	void onBtn_loginClick(ClickEvent event) {
		if(InputCheck() == false){
			Window.alert("未入力項目があります。");
			return;
		}
//		helpBlock.setText("Please wait.......");
		img_spin.setVisible(true);
		final AsyncCallback<List<SerializeHRDBasicUserInfoEntity>> callback = new AsyncCallback<List<SerializeHRDBasicUserInfoEntity>>() {
			public void onFailure(Throwable caught) {
//				Window.alert(caught.getMessage());
				final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
				Calendar now = Calendar.getInstance();
				int h = now.get(now.HOUR_OF_DAY);
				int m = now.get(now.MINUTE);
				int s = now.get(now.SECOND);
				String registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
				AddLoggingUserInfoEntityAsync.AddHRDLoggingUserInfoEntity(null, "ユーザー取得エラー", caught.getLocalizedMessage(), txtbox_Id.getText(), passtxt_Password.getText(), registerDate, "", "",
						new AsyncCallback() {
							public void onFailure(Throwable caught) {
							}
							public void onSuccess(Object result) {

							}
						});
			}
			public void onSuccess(List<SerializeHRDBasicUserInfoEntity> result) {
				if(result.size() == 0 || result.get(0).getEnable() == false){
					img_spin.setVisible(false);
					helpblock01.setText("入力したユーザーは存在しません");
					final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
					Calendar now = Calendar.getInstance();
					int h = now.get(now.HOUR_OF_DAY);
					int m = now.get(now.MINUTE);
					int s = now.get(now.SECOND);
					String registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
					AddLoggingUserInfoEntityAsync.AddHRDLoggingUserInfoEntity(null, "存在しないユーザー", "入力したユーザーは存在しません", txtbox_Id.getText(), passtxt_Password.getText(), registerDate, "", "",
							new AsyncCallback() {
								public void onFailure(Throwable caught) {
								}
								public void onSuccess(Object result) {
								}
							});
					return;
				}
				if(result.get(0).getAuthority() == "管理者"){
					RootPanel.get().remove(1);
					RootPanel.get().remove(navbar);
					//管理者がログインした場合は最初にユーザーアカウント一覧を表示する。
					BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
					UiBBasicUserInfoView userview = new UiBBasicUserInfoView(result.get(0).getLastName() + result.get(0).getFirstName(), result.get(0).getAuthority());
					RootLayoutPanel.get().add(userview);
					History.newItem("UserList");
				}else if(result.get(0).getAuthority() == "一般"){
					AsyncCallback<List<SerializeHRDGeneralUserModeEntity>> usermodecallback = new AsyncCallback<List<SerializeHRDGeneralUserModeEntity>>() {
						public void onFailure(Throwable caught) {
							Window.alert(this.getClass() + "FetchUserModeAsync.getStatusLabel" + caught.getLocalizedMessage());
						}
						public void onSuccess(List<SerializeHRDGeneralUserModeEntity> result) {
							if(result.get(0).getStatus() == "アンケートモード"){
								RootPanel.get().remove(1);
								RootPanel.get().remove(navbar);
								BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
								UiBGeneralUserFabricListSurveyView SurveyView = new UiBGeneralUserFabricListSurveyView();
								RootLayoutPanel.get().add(SurveyView);
								History.newItem("SurveyMode:");
							}else if(result.get(0).getStatus() == "標準モード"){
								RootPanel.get().remove(1);
								RootPanel.get().remove(navbar);
								//管理者がログインした場合は最初にユーザーアカウント一覧を表示する。
								BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
								UiBGeneralUserFabricListView generaluserview = new UiBGeneralUserFabricListView();
								RootLayoutPanel.get().add(generaluserview);
								History.newItem("StockList:");
							}
						}
					};
					FetchUserModeAsync.getStatusLabel("", usermodecallback);

				}

			}
		};
//		FetchBasicUserInfoAsync.getMatchUser(getTxtbox_Id(), getPasstxt_Password(), callback);
		FetchBasicUserInfoAsync.getMatchUser(getTxtbox_Id(), HashUtilMD5.encryptMD5(getPasstxt_Password()), callback);
	}
	@UiHandler("txtbox_Id")
	void onTxtbox_IdKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			passtxt_Password.setFocus(true);
         }
	}
	@UiHandler("passtxt_Password")
	void onPasstxt_PasswordKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			btn_Login.setFocus(true);
         }
	}
	@UiHandler("btn_Login")
	void onBtn_LoginFocus(FocusEvent event) {
//		helpblock01.setText("在庫情報を閲覧する" + "　" + "Press Enter key!!");
	}
	@UiHandler("passtxt_Password")
	void onPasstxt_PasswordFocus(FocusEvent event) {
//		helpBlock.setText("在庫情報を閲覧する");
	}
	@UiHandler("txtbox_Id")
	void onTxtbox_IdFocus(FocusEvent event) {
//		helpBlock.setText("在庫情報を閲覧する");
	}
	@UiHandler("btn_notlogin")
	void onBtn_notloginClick(ClickEvent event) {
		UiBModalAlertIE alerIE = new UiBModalAlertIE();
		alerIE.setPixelSize(600, 400);
		final Modal modal = new Modal(true);
		modal.setPixelSize(640, 400);
		modal.add(alerIE);
		modal.show();
	}

}
