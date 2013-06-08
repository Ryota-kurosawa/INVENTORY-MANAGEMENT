package com.krsw.InventoryManagement.client.UiBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.krsw.InventoryManagement.shared.FieldVerifier;
import com.github.gwtbootstrap.client.ui.NavLink;

public class UiBInventoryManagement extends Composite implements HasText {

	private static UiBInventoryManagementUiBinder uiBinder = GWT.create(UiBInventoryManagementUiBinder.class);
	@UiField HTMLPanel htmlpanel;
//	@UiField Navbar navbar;
//	@UiField NavLink navLink;


	interface UiBInventoryManagementUiBinder extends
			UiBinder<Widget, UiBInventoryManagement> {
	}

	public UiBInventoryManagement() {
		initWidget(uiBinder.createAndBindUi(this));
//		navbar.setShowOn(Device.DESKTOP);

	}

	public UiBInventoryManagement(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {

	}

	public String getText() {
		return null;
	}

//	@UiHandler("navLink")
//	void onNavLinkClick(ClickEvent event) {
//		UiBModalUserInfoEdit ModalUserEdit = new UiBModalUserInfoEdit("ユーザー情報登録");
//		ModalUserEdit.setPixelSize(490, 400);
//		final Modal modal = new Modal(true);
//		modal.setPixelSize(540, 360);
//		modal.add(ModalUserEdit);
//		modal.show();
//	}
}
