package com.krsw.InventoryManagement.shared;

import com.github.gwtbootstrap.client.ui.Label;
import com.google.gwt.visualization.client.events.OnMouseOutHandler;

public class OnMouseOutDemo extends OnMouseOutHandler{
	private final Label label;

	  public OnMouseOutDemo(Label label) {
	    this.label = label;
	  }

	  @Override
	  public void onMouseOutEvent(OnMouseOutEvent event) {
	    StringBuffer b = new StringBuffer();
	    b.append(" row: ");
	    b.append(event.getRow());
	    b.append(", column: ");
	    b.append(event.getColumn());
	    label.setText("Mouse out of " + b.toString());
	  }
}
