package com.krsw.InventoryManagement.client.UiBinder;

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart;
import com.google.gwt.visualization.client.visualizations.corechart.PieChart.PieOptions;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.FetchHRDFabricTotalizationService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.FetchHRDFabricTotalizationServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.Totalization.SerializeHRDFabricTotalizationEntity;
import com.krsw.InventoryManagement.client.UiBinder.Location.UiBLocationInfoEdit;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBFabricInfo;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.constants.IconType;

public class UiBVotedColumnChart extends Composite implements HasText {

	private static UiBVotedColumnChartUiBinder uiBinder = GWT.create(UiBVotedColumnChartUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField LayoutPanel layoutpanel;
	@UiField CaptionPanel caption_pnl;
	@UiField ResponsiveNavbar responsiveNavBar;
	@UiField Nav Nav;
	@UiField NavLink navLink_Stockfabric;
	@UiField NavLink navlink_dept;
	@UiField NavLink navlink_section;
	@UiField NavLink navLink_Surveyresult;
	@UiField Nav navRight;
	@UiField NavLink navLink_Username;
	String StatusLabelString = "一般ユーザービューモード設定";
	List<Integer> controlNumberList = new ArrayList<Integer>();
	interface UiBVotedColumnChartUiBinder extends UiBinder<Widget, UiBVotedColumnChart> {
	}

	private final FetchHRDFabricTotalizationServiceAsync FetchFabricTotalizationAsync = GWT.create(FetchHRDFabricTotalizationService.class);

	public UiBVotedColumnChart(final String LoginUserName, final String Authority) {
		initWidget(uiBinder.createAndBindUi(this));
//		Runnable onLoadCallback = new Runnable() {
//			public void run() {
//				PieChart pie = new PieChart(createPieTable(), createPieOptions());
//				pie.draw(createPieTable(), createPieOptions());
//				pie.addSelectHandler(createPieSelectHandler(pie));
//				caption_pnl.add(pie);
//			}
//	    };
//	    VisualizationUtils.loadVisualizationApi(onLoadCallback, PieChart.PACKAGE);

		 //在庫幕設定
        com.github.gwtbootstrap.client.ui.Dropdown dropdown_fabric = new com.github.gwtbootstrap.client.ui.Dropdown();
        dropdown_fabric.setIcon(IconType.CLOUD);
        dropdown_fabric.setText("在庫");
        navLink_Stockfabric.setIcon(IconType.COG);
        navLink_Stockfabric.setText("在庫幕設定");
        navLink_Stockfabric.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	RootLayoutPanel.get().remove(0);
        		//管理者がログインした場合は最初にユーザーアカウント一覧を表示する。
//        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
        		UiBFabricInfo fabricview = new UiBFabricInfo(LoginUserName,Authority);
        		RootLayoutPanel.get().add(fabricview);
                History.newItem("FabricList:");
            }
        });
        dropdown_fabric.add(navLink_Stockfabric);
        Nav.add(dropdown_fabric);

        //アンケート状況設定
        com.github.gwtbootstrap.client.ui.Dropdown dropdown_survey = new com.github.gwtbootstrap.client.ui.Dropdown();
        dropdown_survey.setIcon(IconType.COMMENTS);
        dropdown_survey.setText("アンケート");
        navLink_Surveyresult.setIcon(IconType.GROUP);
        navLink_Surveyresult.setText("投票者一覧");
        navLink_Surveyresult.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	RootLayoutPanel.get().remove(0);
//        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
        		UiBSurveyVotersList votelist = new UiBSurveyVotersList(LoginUserName,Authority);
        		RootLayoutPanel.get().add(votelist);
                History.newItem("Voters:");
            }
        });

        NavLink navLink_surveyresult03 = new NavLink();
        navLink_surveyresult03.setIcon(IconType.STAR);
        navLink_surveyresult03.setText("幕に対する投票者情報");
        navLink_surveyresult03.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootLayoutPanel.get().remove(0);
//        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
        		UiBVotedFabricList votedfabric = new UiBVotedFabricList(LoginUserName,Authority);
        		RootLayoutPanel.get().add(votedfabric);
        		History.newItem("VoterInFabric:");
			}
		});
        NavLink navLink_surveyresult04 = new NavLink();
        navLink_surveyresult04.setIcon(IconType.REMOVE);
        navLink_surveyresult04.setText("アンケートデータ全削除");
        navLink_surveyresult04.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				UiBModalDeleteVoteData delete = new UiBModalDeleteVoteData();
				delete.setPixelSize(300, 270);
				final Modal modal = new Modal(true);
				modal.setPixelSize(480, 300);
				modal.add(delete);
				modal.show();
			}
		});
        dropdown_survey.add(navLink_surveyresult04);
        dropdown_survey.add(navLink_surveyresult03);
        dropdown_survey.add(navLink_Surveyresult);
        Nav.add(dropdown_survey);


      //NavBarに設定メニュー(ドロップダウン)追加
		com.github.gwtbootstrap.client.ui.Dropdown dropdown_setting = new com.github.gwtbootstrap.client.ui.Dropdown();
		dropdown_setting.setIcon(IconType.GROUP);
		dropdown_setting.setText("ユーザー");
		navlink_section.setIcon(IconType.COG);
		navlink_section.setText("ユーザー設定");
		navlink_section.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	            	UiBBasicUserInfoView userview = new UiBBasicUserInfoView(LoginUserName, Authority);
	            	RootLayoutPanel.get().add(userview);
	                History.newItem("UserList:");
	            }
	        });
	        dropdown_setting.add(navlink_section);
	        Nav.add(dropdown_setting);

        //NavBarにユーザーメニュー(ドロップダウン)追加
        com.github.gwtbootstrap.client.ui.Dropdown dropdown_location = new com.github.gwtbootstrap.client.ui.Dropdown();
        dropdown_location.setIcon(IconType.BUILDING);
        dropdown_location.setText("拠点");
        navlink_dept.setIcon(IconType.COG);
        navlink_dept.setText("拠点設定");
        navlink_dept.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	RootLayoutPanel.get().remove(0);
            	UiBLocationInfoEdit locedit = new UiBLocationInfoEdit(LoginUserName, Authority);
            	RootLayoutPanel.get().add(locedit);
            	History.newItem("Location:");
            }
        });
        dropdown_location.add(navlink_dept);
        Nav.add(dropdown_location);

      //NavBarにユーザーメニュー(ドロップダウン)追加
        navLink_Username.setIcon(IconType.OFF);
        com.github.gwtbootstrap.client.ui.Dropdown dropdown_logout = new com.github.gwtbootstrap.client.ui.Dropdown();
        dropdown_logout.setIcon(IconType.USER);
        dropdown_logout.setText(LoginUserName);
        navLink_Username.setIcon(IconType.OFF);
        navLink_Username.setText("ログアウト");
        navLink_Username.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	if(Window.confirm("ログアウトしますか?") == true){
            		History.newItem("");
            		Window.Location.reload();
            	}else{
            		return;
            	}
            }
        });
        dropdown_logout.add(navLink_Username);
        navRight.add(dropdown_logout);

        //一般ユーザービューモード設定
        final NavLink navLink_ViewMode = new NavLink();
        navLink_ViewMode.setIcon(IconType.COG);
        navLink_ViewMode.setText(StatusLabelString);
        navLink_ViewMode.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				UiBGeneralUserModeView UserMode = new UiBGeneralUserModeView(LoginUserName);
				UserMode.setPixelSize(300, 270);
				final Modal modal = new Modal(true);
				modal.setPixelSize(480, 300);
				modal.add(UserMode);
				modal.show();
			}
		});
        dropdown_logout.add(navLink_ViewMode);
        navRight.add(dropdown_logout);
	}

	private SelectHandler createPieSelectHandler(final PieChart chart) {
	    return new SelectHandler() {
	      @Override
	      public void onSelect(SelectEvent event) {
	        String message = "";
	        JsArray<Selection> selections = chart.getSelections();
	        for (int i = 0; i < selections.length(); i++) {
	          message += i == 0 ? "" : "\n";
	          Selection selection = selections.get(i);
	          if (selection.isCell()) {
	            int row = selection.getRow();
	            int column = selection.getColumn();
	            message += "cell " + row + ":" + column + " selected";
	          } else if (selection.isRow()) {
	            int row = selection.getRow();
	            message += "row " + row + " selected";
	          } else {
	            message += "Pie chart selections should be either row selections or cell selections.";
	            message += "  Other visualizations support column selections as well.";
	          }
	        }
	      }
	    };
	  }

	private PieOptions createPieOptions() {
		PieOptions options = PieOptions.create();
	    options.setWidth(caption_pnl.getOffsetWidth());
	    options.setHeight(caption_pnl.getOffsetHeight());
	    options.set3D(false);
	    options.setLegend("left");
	    return options;
	  }

	private AbstractDataTable createPieTable() {
		final DataTable data = DataTable.create();
		Window.alert(controlNumberList.get(0) + "no1");
		 data.addColumn(ColumnType.STRING, "Name");
		 data.addColumn(ColumnType.NUMBER, "幕番号");
		 data.addRows(6);
		 data.setValue(0, 0, "No.1"); data.setValue(0, 1, controlNumberList.get(0));
		 data.setValue(1, 0, "No.2"); data.setValue(1, 1, controlNumberList.get(1));
		    data.setValue(2, 0, "No.3"); data.setValue(2, 1, controlNumberList.get(2));
		    data.setValue(3, 0, "No.4"); data.setValue(3, 1, controlNumberList.get(3));
		    data.setValue(4, 0, "No.5"); data.setValue(4, 1, controlNumberList.get(4));
		    data.setValue(5, 0, "No.6"); data.setValue(5, 1, controlNumberList.get(5));
//		    data.setValue(6, 0, "No.7"); data.setValue(6, 1, controlNumberList.getNo7());
//		    data.setValue(7, 0, "No.8"); data.setValue(7, 1, controlNumberList.getNo8());
//		    data.setValue(8, 0, "No.9"); data.setValue(8, 1, controlNumberList.getNo9());
//		    data.setValue(9, 0, "No.10"); data.setValue(9, 1, controlNumberList.getNo10());
//		    data.setValue(10, 0, "No.11"); data.setValue(10, 1, controlNumberList.getNo11());
//		    data.setValue(11, 0, "No.12"); data.setValue(11, 1, controlNumberList.getNo12());
//		    data.setValue(12, 0, "No.13"); data.setValue(12, 1, controlNumberList.getNo13());
//		    data.setValue(13, 0, "No.14"); data.setValue(13, 1, controlNumberList.getNo14());
//		    data.setValue(14, 0, "No.15"); data.setValue(14, 1, controlNumberList.getNo15());
//		    data.setValue(15, 0, "No.16"); data.setValue(15, 1, controlNumberList.getNo16());
//		    data.setValue(16, 0, "No.17"); data.setValue(16, 1, controlNumberList.getNo17());
//		    data.setValue(17, 0, "No.18"); data.setValue(17, 1, controlNumberList.getNo18());
//		    data.setValue(18, 0, "No.19"); data.setValue(18, 1, controlNumberList.getNo19());
//		    data.setValue(19, 0, "No.20"); data.setValue(19, 1, controlNumberList.getNo20());
//		    data.setValue(20, 0, "No.21"); data.setValue(20, 1, controlNumberList.getNo21());
//		    data.setValue(21, 0, "No.22"); data.setValue(21, 1, controlNumberList.getNo22());
//		    data.setValue(22, 0, "No.23"); data.setValue(22, 1, controlNumberList.getNo23());
//		    data.setValue(23, 0, "No.24"); data.setValue(23, 1, controlNumberList.getNo24());
//		    data.setValue(24, 0, "No.25"); data.setValue(24, 1, controlNumberList.getNo25());
//		    data.setValue(25, 0, "No.26"); data.setValue(25, 1, controlNumberList.getNo26());
//		    data.setValue(26, 0, "No.27"); data.setValue(26, 1, controlNumberList.getNo27());
//		    data.setValue(27, 0, "No.28"); data.setValue(27, 1, controlNumberList.getNo28());
//		    data.setValue(28, 0, "No.29"); data.setValue(28, 1, controlNumberList.getNo29());
//		    data.setValue(29, 0, "No.30"); data.setValue(29, 1, controlNumberList.getNo30());
//		    data.setValue(30, 0, "No.31"); data.setValue(30, 1, controlNumberList.getNo31());
//		    data.setValue(31, 0, "No.32"); data.setValue(31, 1, controlNumberList.getNo32());
//		    data.setValue(32, 0, "No.33"); data.setValue(32, 1, controlNumberList.getNo33());
//		    data.setValue(33, 0, "No.34"); data.setValue(33, 1, controlNumberList.getNo34());
//		    data.setValue(34, 0, "No.35"); data.setValue(34, 1, controlNumberList.getNo35());
//		    data.setValue(35, 0, "No.36"); data.setValue(35, 1, controlNumberList.getNo36());
//		    data.setValue(36, 0, "No.37"); data.setValue(36, 1, controlNumberList.getNo37());
//		    data.setValue(37, 0, "No.38"); data.setValue(37, 1, controlNumberList.getNo38());
//		    data.setValue(38, 0, "No.39"); data.setValue(38, 1, controlNumberList.getNo39());
//		    data.setValue(39, 0, "No.40"); data.setValue(39, 1, controlNumberList.getNo40());
//		    data.setValue(40, 0, "No.41"); data.setValue(40, 1, controlNumberList.getNo41());
//		    data.setValue(41, 0, "No.42"); data.setValue(41, 1, controlNumberList.getNo42());
//		    data.setValue(42, 0, "No.43"); data.setValue(42, 1, controlNumberList.getNo43());
//		    data.setValue(43, 0, "No.44"); data.setValue(43, 1, controlNumberList.getNo44());
//		    data.setValue(44, 0, "No.45"); data.setValue(44, 1, controlNumberList.getNo45());
//		    data.setValue(45, 0, "No.46"); data.setValue(45, 1, controlNumberList.getNo46());
//		    data.setValue(46, 0, "No.47"); data.setValue(46, 1, controlNumberList.getNo47());
//		    data.setValue(47, 0, "No.48"); data.setValue(47, 1, controlNumberList.getNo48());
//		    data.setValue(48, 0, "No.49"); data.setValue(48, 1, controlNumberList.getNo49());
//		    data.setValue(49, 0, "No.50"); data.setValue(49, 1, controlNumberList.getNo50());
//		    data.setValue(50, 0, "No.51"); data.setValue(50, 1, controlNumberList.getNo51());
//		    data.setValue(51, 0, "No.52"); data.setValue(51, 1, controlNumberList.getNo52());
//		    data.setValue(52, 0, "No.53"); data.setValue(52, 1, controlNumberList.getNo53());
//		    data.setValue(53, 0, "No.54"); data.setValue(53, 1, controlNumberList.getNo54());
//		    data.setValue(54, 0, "No.55"); data.setValue(54, 1, controlNumberList.getNo55());
//		    data.setValue(55, 0, "No.56"); data.setValue(55, 1, controlNumberList.getNo56());
//		    data.setValue(56, 0, "No.57"); data.setValue(56, 1, controlNumberList.getNo57());
//		    data.setValue(57, 0, "No.58"); data.setValue(57, 1, controlNumberList.getNo58());
//		    data.setValue(58, 0, "No.59"); data.setValue(58, 1, controlNumberList.getNo59());
//		    data.setValue(59, 0, "No.60"); data.setValue(59, 1, controlNumberList.getNo60());
//		    data.setValue(60, 0, "No.61"); data.setValue(60, 1, controlNumberList.getNo61());
//		    data.setValue(61, 0, "No.62"); data.setValue(61, 1, controlNumberList.getNo62());
//		    data.setValue(62, 0, "No.63"); data.setValue(62, 1, controlNumberList.getNo63());
//		    data.setValue(63, 0, "No.64"); data.setValue(63, 1, controlNumberList.getNo64());
//		    data.setValue(64, 0, "No.65"); data.setValue(64, 1, controlNumberList.getNo65());
//		    data.setValue(65, 0, "No.66"); data.setValue(65, 1, controlNumberList.getNo66());
//		    data.setValue(66, 0, "No.67"); data.setValue(66, 1, controlNumberList.getNo67());
//		    data.setValue(67, 0, "No.68"); data.setValue(67, 1, controlNumberList.getNo68());
//		    data.setValue(68, 0, "No.69"); data.setValue(68, 1, controlNumberList.getNo69());
//		    data.setValue(69, 0, "No.70"); data.setValue(69, 1, controlNumberList.getNo70());
//		    data.setValue(70, 0, "No.71"); data.setValue(70, 1, controlNumberList.getNo71());
//		    data.setValue(71, 0, "No.72"); data.setValue(71, 1, controlNumberList.getNo72());
//		    data.setValue(72, 0, "No.73"); data.setValue(72, 1, controlNumberList.getNo73());
//		    data.setValue(73, 0, "No.74"); data.setValue(73, 1, controlNumberList.getNo74());
//		    data.setValue(74, 0, "No.75"); data.setValue(74, 1, controlNumberList.getNo75());
//		    data.setValue(75, 0, "No.76"); data.setValue(75, 1, controlNumberList.getNo76());
//		    data.setValue(76, 0, "No.77"); data.setValue(76, 1, controlNumberList.getNo77());
//		    data.setValue(77, 0, "No.78"); data.setValue(77, 1, controlNumberList.getNo78());
//		    data.setValue(78, 0, "No.79"); data.setValue(78, 1, controlNumberList.getNo79());
//		    data.setValue(79, 0, "No.80"); data.setValue(79, 1, controlNumberList.getNo80());
//		    data.setValue(80, 0, "No.81"); data.setValue(80, 1, controlNumberList.getNo81());
//		    data.setValue(81, 0, "No.82"); data.setValue(81, 1, controlNumberList.getNo82());
//		    data.setValue(82, 0, "No.83"); data.setValue(82, 1, controlNumberList.getNo83());
//		    data.setValue(83, 0, "No.84"); data.setValue(83, 1, controlNumberList.getNo84());
//		    data.setValue(84, 0, "No.85"); data.setValue(84, 1, controlNumberList.getNo85());
//		    data.setValue(85, 0, "No.86"); data.setValue(85, 1, controlNumberList.getNo86());
//		    data.setValue(86, 0, "No.87"); data.setValue(86, 1, controlNumberList.getNo87());
//		    data.setValue(87, 0, "No.88"); data.setValue(87, 1, controlNumberList.getNo88());
//		    data.setValue(88, 0, "No.89"); data.setValue(88, 1, controlNumberList.getNo89());
//		    data.setValue(89, 0, "No.90"); data.setValue(89, 1, controlNumberList.getNo90());
//		    data.setValue(90, 0, "No.91"); data.setValue(90, 1, controlNumberList.getNo91());
//		    data.setValue(91, 0, "No.92"); data.setValue(91, 1, controlNumberList.getNo92());
//		    data.setValue(92, 0, "No.93"); data.setValue(92, 1, controlNumberList.getNo93());
//		    data.setValue(93, 0, "No.94"); data.setValue(93, 1, controlNumberList.getNo94());
//		    data.setValue(94, 0, "No.95"); data.setValue(94, 1, controlNumberList.getNo95());
//		    data.setValue(95, 0, "No.96"); data.setValue(95, 1, controlNumberList.getNo96());
//		    data.setValue(96, 0, "No.97"); data.setValue(96, 1, controlNumberList.getNo97());
//		    data.setValue(97, 0, "No.98"); data.setValue(97, 1, controlNumberList.getNo98());
//		    data.setValue(98, 0, "No.99"); data.setValue(98, 1, controlNumberList.getNo99());
//		    data.setValue(99, 0, "No.100"); data.setValue(99, 1, controlNumberList.getNo100());
	    return data;
	  }

	public UiBVotedColumnChart(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	private void getFabricData(){
		final AsyncCallback<List<SerializeHRDFabricTotalizationEntity>> callback = new AsyncCallback<List<SerializeHRDFabricTotalizationEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
			public void onSuccess(List<SerializeHRDFabricTotalizationEntity> result) {
				for(SerializeHRDFabricTotalizationEntity serial : result){
					controlNumberList.add(serial.getNo1());
					controlNumberList.add(serial.getNo2());
					controlNumberList.add(serial.getNo3());
					controlNumberList.add(serial.getNo4());
					controlNumberList.add(serial.getNo5());
					controlNumberList.add(serial.getNo6());
					controlNumberList.add(serial.getNo7());
					controlNumberList.add(serial.getNo8());
					controlNumberList.add(serial.getNo9());
					controlNumberList.add(serial.getNo10());
					controlNumberList.add(serial.getNo11());
					controlNumberList.add(serial.getNo12());
					controlNumberList.add(serial.getNo13());
					controlNumberList.add(serial.getNo14());
					controlNumberList.add(serial.getNo15());
					controlNumberList.add(serial.getNo16());
					controlNumberList.add(serial.getNo17());
					controlNumberList.add(serial.getNo18());
					controlNumberList.add(serial.getNo19());
					controlNumberList.add(serial.getNo20());
					controlNumberList.add(serial.getNo21());
					controlNumberList.add(serial.getNo22());
					controlNumberList.add(serial.getNo23());
					controlNumberList.add(serial.getNo24());
					controlNumberList.add(serial.getNo25());
					controlNumberList.add(serial.getNo26());
					controlNumberList.add(serial.getNo27());
					controlNumberList.add(serial.getNo28());
					controlNumberList.add(serial.getNo29());
					controlNumberList.add(serial.getNo30());
					controlNumberList.add(serial.getNo31());
					controlNumberList.add(serial.getNo32());
					controlNumberList.add(serial.getNo33());
					controlNumberList.add(serial.getNo34());
					controlNumberList.add(serial.getNo35());
					controlNumberList.add(serial.getNo36());
					controlNumberList.add(serial.getNo37());
					controlNumberList.add(serial.getNo38());
					controlNumberList.add(serial.getNo39());
					controlNumberList.add(serial.getNo40());
					controlNumberList.add(serial.getNo41());
					controlNumberList.add(serial.getNo42());
					controlNumberList.add(serial.getNo43());
					controlNumberList.add(serial.getNo44());
					controlNumberList.add(serial.getNo45());
					controlNumberList.add(serial.getNo46());
					controlNumberList.add(serial.getNo47());
					controlNumberList.add(serial.getNo48());
					controlNumberList.add(serial.getNo49());
					controlNumberList.add(serial.getNo50());
					controlNumberList.add(serial.getNo51());
					controlNumberList.add(serial.getNo52());
					controlNumberList.add(serial.getNo53());
					controlNumberList.add(serial.getNo54());
					controlNumberList.add(serial.getNo55());
					controlNumberList.add(serial.getNo56());
					controlNumberList.add(serial.getNo57());
					controlNumberList.add(serial.getNo58());
					controlNumberList.add(serial.getNo59());
					controlNumberList.add(serial.getNo60());
					controlNumberList.add(serial.getNo61());
					controlNumberList.add(serial.getNo62());
					controlNumberList.add(serial.getNo63());
					controlNumberList.add(serial.getNo64());
					controlNumberList.add(serial.getNo65());
					controlNumberList.add(serial.getNo66());
					controlNumberList.add(serial.getNo67());
					controlNumberList.add(serial.getNo68());
					controlNumberList.add(serial.getNo69());
					controlNumberList.add(serial.getNo70());
					controlNumberList.add(serial.getNo71());
					controlNumberList.add(serial.getNo72());
					controlNumberList.add(serial.getNo73());
					controlNumberList.add(serial.getNo74());
					controlNumberList.add(serial.getNo75());
					controlNumberList.add(serial.getNo76());
					controlNumberList.add(serial.getNo77());
					controlNumberList.add(serial.getNo78());
					controlNumberList.add(serial.getNo79());
					controlNumberList.add(serial.getNo80());
					controlNumberList.add(serial.getNo81());
					controlNumberList.add(serial.getNo82());
					controlNumberList.add(serial.getNo83());
					controlNumberList.add(serial.getNo84());
					controlNumberList.add(serial.getNo85());
					controlNumberList.add(serial.getNo86());
					controlNumberList.add(serial.getNo87());
					controlNumberList.add(serial.getNo88());
					controlNumberList.add(serial.getNo89());
					controlNumberList.add(serial.getNo90());
					controlNumberList.add(serial.getNo91());
					controlNumberList.add(serial.getNo92());
					controlNumberList.add(serial.getNo93());
					controlNumberList.add(serial.getNo94());
					controlNumberList.add(serial.getNo95());
					controlNumberList.add(serial.getNo96());
					controlNumberList.add(serial.getNo97());
					controlNumberList.add(serial.getNo98());
					controlNumberList.add(serial.getNo99());
					controlNumberList.add(serial.getNo100());
				}
			}
		};
		FetchFabricTotalizationAsync.getRange(0, 0, callback);

	}

	private AbstractDataTable createPieTable2() {
		final DataTable data = DataTable.create();
		 data.addColumn(ColumnType.STRING, "Name");
		 data.addColumn(ColumnType.NUMBER, "幕番号");
		 data.addRows(100);
		 data.setValue(0, 0, "No.1"); data.setValue(0, 1, 25);
		 data.setValue(1, 0, "No.2"); data.setValue(1, 1, 12);
		 data.setValue(2, 0, "No.3"); data.setValue(2, 1, 6);
		 data.setValue(3, 0, "No.4"); data.setValue(3, 1, 33);
		 data.setValue(4, 0, "No.5"); data.setValue(4, 1, 2);
		 data.setValue(5, 0, "No.6"); data.setValue(5, 1, 7);
	    return data;
	  }

	@UiHandler("htmlpanel")
	void onHtmlpanelAttachOrDetach(AttachEvent event) {
		if(event.isAttached() == true){
			//visualization APIのコールバックを生成
		    Runnable onLoadCallback = new Runnable() {
				public void run() {
					getFabricData();
					PieChart pie = new PieChart(createPieTable2(), createPieOptions());
					pie.draw(createPieTable2(), createPieOptions());
					pie.addSelectHandler(createPieSelectHandler(pie));
					caption_pnl.add(pie);
				}
		    };
		    // visualization apiのロード、onLoadCallbackを渡す
		    VisualizationUtils.loadVisualizationApi(onLoadCallback, PieChart.PACKAGE);
		}
	}
}
