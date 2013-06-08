package com.krsw.InventoryManagement.client.UiBinder;

import java.util.Calendar;
import java.util.Date;

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
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.github.gwtbootstrap.client.ui.Badge;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.constants.BadgeType;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.krsw.InventoryManagement.client.HRD.Accounts.AddHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.AddHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Accounts.DeleteHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.DeleteHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.shared.FieldVerifier;
import com.krsw.InventoryManagement.shared.HashUtilMD5;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.KeyPressEvent;

public class UiBModalUserInfoEdit extends Composite implements HasText {

	private static UiBModalUserInfoEditUiBinder uiBinder = GWT.create(UiBModalUserInfoEditUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField LayoutPanel layoutpanel;
	@UiField Badge badge_firstname;
	@UiField Badge badge_section;
	@UiField Badge badge_authority;
	@UiField Badge badge_loginid;
	@UiField Badge badge_password;
	@UiField Badge badge_email;
	@UiField Badge badge_enabled;
	@UiField TextBox txtbox_Lastname;
	@UiField TextBox txtbox_Firstname;
	@UiField ListBox cmbbox_Section;
	@UiField ListBox cmbbox_Authority;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_update;
	@UiField TextBox txtbox_Loginid;
	@UiField PasswordTextBox txtbox_password;
	@UiField TextBox txtbox_email;
	@UiField CheckBox chk_enabled;
	@UiField Label label_head;
	@UiField Image image_minispin;
	@UiField CheckBox checkbox_delete;
	@UiField Badge badge_lastname;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_close;
//	int ConstructorNotification = 0;
	String registerDate = null;
	String updateDate = null;
	Long id = null;
//	private final DeleteHRDBasicUserInfoEntityServiceAsync DeleteStorageInfoEntityAsync = GWT.create(DeleteHRDBasicUserInfoEntityService.class);
	private final AddHRDBasicUserInfoEntityServiceAsync AddStorageInfoEntityAsync = GWT.create(AddHRDBasicUserInfoEntityService.class);

	interface UiBModalUserInfoEditUiBinder extends
			UiBinder<Widget, UiBModalUserInfoEdit> {
	}

	public UiBModalUserInfoEdit() {
		initWidget(uiBinder.createAndBindUi(this));
//		ConstructorNotification = 0;
		setTabIndex();
		FieldVerifier.createSectionBox(cmbbox_Section);
		FieldVerifier.createAuthBox(cmbbox_Authority);
		image_minispin.setVisible(false);
		checkbox_delete.setVisible(false);
	}

	public UiBModalUserInfoEdit(String LabelText, Long Id, String LastName, String FirstName, String Section, String Authority,
			String LoginId, String LoginPassword, String Email, Boolean Enabled) {
		initWidget(uiBinder.createAndBindUi(this));
//		ConstructorNotification = 1;
		setTabIndex();
		image_minispin.setVisible(false);
		label_head.setText(LabelText);
		FieldVerifier.createSectionBox(cmbbox_Section);
		FieldVerifier.createAuthBox(cmbbox_Authority);
		id = Id;
		setTxtbox_Lastname(LastName);
		setTxtbox_Firstname(FirstName);
		setCmbbox_Section(Section);
		setCmbbox_Authority(Authority);
		setTxtbox_Loginid(LoginId);
		setTxtbox_password(LoginPassword);
		setTxtbox_email(Email);
		setChk_enabled(Enabled);
		checkbox_delete.setVisible(true);
		}

	public UiBModalUserInfoEdit(String LabelText){
		initWidget(uiBinder.createAndBindUi(this));
//		ConstructorNotification = 2;
		setTabIndex();
		label_head.setText(LabelText);
		FieldVerifier.createSectionBox(cmbbox_Section);
		FieldVerifier.createAuthBox(cmbbox_Authority);
		image_minispin.setVisible(false);
		checkbox_delete.setVisible(false);
	}

	public void setTabIndex(){
		this.txtbox_Lastname.setTabIndex(1);
		this.txtbox_Firstname.setTabIndex(2);
		this.cmbbox_Section.setTabIndex(3);
		this.cmbbox_Authority.setTabIndex(4);
		this.txtbox_Loginid.setTabIndex(5);
		this.txtbox_password.setTabIndex(6);
		this.txtbox_email.setTabIndex(7);
		this.chk_enabled.setTabIndex(8);
		this.btn_update.setTabIndex(9);
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	/**
	 * 更新ボタンクリック
	 * @param event
	 */
	@UiHandler("btn_update")
	void onBtn_updateClick(ClickEvent event) {
		if(getCheckbox_delete() == false){
			if(Window.confirm("ユーザー情報を更新してもよろしいですか?") == false){
				return;
			}
			image_minispin.setVisible(true);
			final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
			Calendar now = Calendar.getInstance();
			int h = now.get(now.HOUR_OF_DAY);
			int m = now.get(now.MINUTE);
			int s = now.get(now.SECOND);
			registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			AddStorageInfoEntityAsync.AddHRDBasicUserInfoEntity(id, getTxtbox_Firstname(), getTxtbox_Lastname(), getCmbbox_Section(), getCmbbox_Authority(),
					getTxtbox_Loginid(), HashUtilMD5.encryptMD5(getTxtbox_password()), getTxtbox_email(), getChk_enabled(), registerDate, updateDate, "", "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							Window.alert("登録しました。");
							image_minispin.setVisible(false);
						}
			});
		}else{
			if(Window.confirm("このユーザー情報を削除してもよろしいですか?") == false){
				return;
			}
			if(Window.confirm("削除するとデータは復元できません\n本当に削除してもよろしいですか?") == false){
				return;
			}
			image_minispin.setVisible(true);
			Window.alert(id + "");
			AddStorageInfoEntityAsync.AddHRDBasicUserInfoEntity(id, getTxtbox_Firstname(), getTxtbox_Lastname(), getCmbbox_Section(), getCmbbox_Authority(),
					getTxtbox_Loginid(), HashUtilMD5.encryptMD5(getTxtbox_password()), getTxtbox_email(), getChk_enabled(), registerDate, updateDate, "Delete@" + registerDate, "", new AsyncCallback(){
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage() + this.getClass() + "DeleteStorageInfoEntityAsync.DeleteHRDBasicUserInfoEntity");
				}
				public void onSuccess(Object result) {
					Window.alert("削除しました。");
					image_minispin.setVisible(false);
				}
			});
		}
	}



	public String getTxtbox_Lastname() {
		return txtbox_Lastname.getText();
	}

	public void setTxtbox_Lastname(String txtbox_Lastname) {
		this.txtbox_Lastname.setText(txtbox_Lastname);
	}

	public String getTxtbox_Firstname() {
		return txtbox_Firstname.getText();
	}

	public void setTxtbox_Firstname(String txtbox_Firstname) {
		this.txtbox_Firstname.setText(txtbox_Firstname);
	}

	public String getCmbbox_Section() {
		return cmbbox_Section.getItemText(cmbbox_Section.getSelectedIndex());
	}

	public void setCmbbox_Section(String cmbbox_Section) {
		this.cmbbox_Section.setSelectedValue(cmbbox_Section);
	}

	public String getCmbbox_Authority() {
		return cmbbox_Authority.getItemText(cmbbox_Authority.getSelectedIndex());
	}

	public void setCmbbox_Authority(String cmbbox_Authority) {
		this.cmbbox_Authority.setSelectedValue(cmbbox_Authority);
	}

	public String getTxtbox_Loginid() {
		return txtbox_Loginid.getText();
	}

	public void setTxtbox_Loginid(String txtbox_Loginid) {
		this.txtbox_Loginid.setText(txtbox_Loginid);
	}

	public String getTxtbox_password() {
		return txtbox_password.getText();
	}

	public void setTxtbox_password(String txtbox_password) {
		this.txtbox_password.setText(txtbox_password);
	}

	public String getTxtbox_email() {
		return txtbox_email.getText();
	}

	public void setTxtbox_email(String txtbox_email) {
		this.txtbox_email.setText(txtbox_email);
	}

	public Boolean getChk_enabled() {
		return chk_enabled.getValue();
	}

	public void setChk_enabled(Boolean chk_enabled) {
		this.chk_enabled.setValue(chk_enabled);
	}

	public Boolean getCheckbox_delete() {
		return checkbox_delete.getValue();
	}

	public void setCheckbox_delete(Boolean checkbox_delete) {
		this.checkbox_delete.setValue(checkbox_delete);
	}

	@UiHandler("htmlpanel")
	void onHtmlpanelAttachOrDetach(AttachEvent event) {
		if(event.isAttached() == true){
			Window.alert("Attache");
		}
	}
	@UiHandler("txtbox_Lastname")
	void onTxtbox_LastnameKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtbox_Firstname.setFocus(true);
         }
	}
	@UiHandler("txtbox_Firstname")
	void onTxtbox_FirstnameKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			cmbbox_Section.setFocus(true);
         }
	}
	@UiHandler("cmbbox_Section")
	void onCmbbox_SectionKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			cmbbox_Authority.setFocus(true);
         }
	}
	@UiHandler("cmbbox_Authority")
	void onCmbbox_AuthorityKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtbox_Loginid.setFocus(true);
         }
	}
	@UiHandler("txtbox_Loginid")
	void onTxtbox_LoginidKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtbox_password.setFocus(true);
         }
	}
	@UiHandler("txtbox_password")
	void onTxtbox_passwordKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtbox_email.setFocus(true);
         }
	}
	@UiHandler("txtbox_email")
	void onTxtbox_emailKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			chk_enabled.setFocus(true);
         }
	}
	@UiHandler("chk_enabled")
	void onChk_enabledKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			btn_update.setFocus(true);
         }
	}
	@UiHandler("checkbox_delete")
	void onCheckbox_deleteClick(ClickEvent event) {
		if(getCheckbox_delete() == true){
			btn_update.setText("削除");
			btn_update.setType(ButtonType.DANGER);
			btn_update.setIcon(IconType.REMOVE);
			setFormPartsDesable();
//			setFormBadgeChangeDisabled();
			checkbox_delete.setText("ユーザーを更新");
		}else{
			btn_update.setText("更新");
			btn_update.setType(ButtonType.PRIMARY);
			btn_update.setIcon(IconType.USER_MD);
			setFormPartsEnable();
//			setFormBadgeChangeEnabled();
			checkbox_delete.setText("ユーザーを削除");
		}
	}

	private void setFormPartsDesable(){
		txtbox_Lastname.setEnabled(false);
		txtbox_Firstname.setEnabled(false);
		cmbbox_Section.setEnabled(false);
		cmbbox_Authority.setEnabled(false);
		txtbox_Loginid.setEnabled(false);
		txtbox_password.setEnabled(false);
		txtbox_email.setEnabled(false);
		chk_enabled.setEnabled(false);
		return;
	}

	private void setFormPartsEnable(){
		txtbox_Lastname.setEnabled(true);
		txtbox_Firstname.setEnabled(true);
		cmbbox_Section.setEnabled(true);
		cmbbox_Authority.setEnabled(true);
		txtbox_Loginid.setEnabled(true);
		txtbox_password.setEnabled(true);
		txtbox_email.setEnabled(true);
		chk_enabled.setEnabled(true);
		return;
	}

	private void setFormBadgeChangeDisabled(){
		badge_lastname.setType(BadgeType.INVERSE);
		badge_firstname.setType(BadgeType.INVERSE);
		badge_section.setType(BadgeType.INVERSE);
		badge_authority.setType(BadgeType.INVERSE);
		badge_loginid.setType(BadgeType.INVERSE);
		badge_password.setType(BadgeType.INVERSE);
		badge_email.setType(BadgeType.INVERSE);
		badge_enabled.setType(BadgeType.INVERSE);
		return;
	}

	private void setFormBadgeChangeEnabled(){
		badge_lastname.setType(BadgeType.WARNING);
		badge_firstname.setType(BadgeType.INFO);
		badge_section.setType(BadgeType.INFO);
		badge_authority.setType(BadgeType.INFO);
		badge_loginid.setType(BadgeType.INFO);
		badge_password.setType(BadgeType.INFO);
		badge_email.setType(BadgeType.INFO);
		badge_enabled.setType(BadgeType.INFO);
		return;
	}
	@UiHandler("btn_close")
	void onBtn_closeClick(ClickEvent event) {

	}
}
