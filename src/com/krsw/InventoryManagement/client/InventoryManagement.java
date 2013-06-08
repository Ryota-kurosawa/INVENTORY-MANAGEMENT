package com.krsw.InventoryManagement.client;

import com.krsw.InventoryManagement.client.UiBinder.UiBLogin;
import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class InventoryManagement implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ResourceInjector.injectResourceCssAsFile("bootstrap-ie7buttonfix.css");
//		final int clientWidth;
//		final int clientHeight;
//		FieldVerifier.setScreenWidth(clientWidth = Window.getClientWidth());
//		FieldVerifier.setScreenHeight(clientHeight = Window.getClientHeight());
//		// ルートパネル生成
//		final RootPanel BrowserRoot = RootPanel.get("LoginPNL");
//		BrowserRoot.setSize("100%", "100%");
//		// レイアウトパネル生成
//		final LayoutPanel layoutPNL= new LayoutPanel();
//		layoutPNL.setSize("100%", "100%");
//		BrowserRoot.add(layoutPNL);
//		// ログインパネル生成
//		UiBLogin login = new UiBLogin();
//		layoutPNL.add(login);
//		login.setSize("100%", "100%");
//		layoutPNL.setWidgetLeftWidth(login, clientWidth * 0.0, Unit.PX, 1000.0, Unit.PX);
//		layoutPNL.setWidgetTopHeight(login, clientHeight * 0.0, Unit.PX, 600.0, Unit.PX);
//		RootPanel.get().add(new UiBInventoryManagement());
		Window.addWindowClosingHandler(new Window.ClosingHandler() {
			public void onWindowClosing(ClosingEvent event) {
				Window.Location.reload();
			}
		});
		Window.addCloseHandler(new CloseHandler<Window>() {
			public void onClose(CloseEvent<Window> event) {
			}
		});
		RootPanel.get().add(new UiBLogin());
	}
}
