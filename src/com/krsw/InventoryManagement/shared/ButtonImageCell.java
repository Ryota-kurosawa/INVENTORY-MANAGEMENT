package com.krsw.InventoryManagement.shared;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class ButtonImageCell extends com.github.gwtbootstrap.client.ui.ButtonCell{
	@Override
    public void render(com.google.gwt.cell.client.Cell.Context context,
            String value, SafeHtmlBuilder sb) {
        SafeHtml html = SafeHtmlUtils.fromTrustedString(new com.github.gwtbootstrap.client.ui.Image(value).toString());
        sb.append(html);
    }
}
