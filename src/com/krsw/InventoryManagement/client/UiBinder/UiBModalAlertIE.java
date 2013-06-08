package com.krsw.InventoryManagement.client.UiBinder;

import com.github.gwtbootstrap.client.ui.Modal;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class UiBModalAlertIE extends Composite implements HasText {

	private static UiBModalAlertIEUiBinder uiBinder = GWT.create(UiBModalAlertIEUiBinder.class);

	interface UiBModalAlertIEUiBinder extends UiBinder<Widget, UiBModalAlertIE> {
	}

	public UiBModalAlertIE() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public UiBModalAlertIE(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

}
