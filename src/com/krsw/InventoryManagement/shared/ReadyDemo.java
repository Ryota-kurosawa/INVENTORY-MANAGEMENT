package com.krsw.InventoryManagement.shared;

import com.github.gwtbootstrap.client.ui.Label;
import com.google.gwt.visualization.client.events.ReadyHandler;

public class ReadyDemo extends ReadyHandler{
	private final Label label;

	  public ReadyDemo(Label label) {
	    this.label = label;
	  }

	  @Override
	  public void onReady(ReadyEvent event) {
	    label.setText("The visualization is ready");
	  }
}
