package com.krsw.InventoryManagement.client.UiBinder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionModel;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Accounts.SerializeHRDBasicUserInfoEntity;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.FetchHRDFabricCountingResultService;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.FetchHRDFabricCountingResultServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Vote.Fabric.VotingResults.SerializeHRDFabricCountingResultEntity;
import com.krsw.InventoryManagement.client.UiBinder.Location.UiBLocationInfoEdit;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBFabricInfo;

public class UiBSurveyVotersList extends Composite implements HasText {

	private static UiBSurveyVotersListUiBinder uiBinder = GWT.create(UiBSurveyVotersListUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField(provided=true) DataGrid<SerializeHRDFabricCountingResultEntity> datagrid = new DataGrid<SerializeHRDFabricCountingResultEntity>(100, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField ResponsiveNavbar responsiveNavBar;
	@UiField Nav Nav;
	@UiField NavLink navLink_Stockfabric;
	@UiField NavLink navlink_dept;
	@UiField NavLink navlink_user;
	@UiField NavLink navLink_Surveyresult;
	@UiField Nav navRight;
	@UiField LayoutPanel layoutpanel;
	@UiField NavLink navLink_Username;
	String registerDate = null;
	String updateDate = null;
	Long id = null;
	String username = "";
	String auth = "";
	String StatusLabelString = "一般ユーザービューモード設定";

	interface UiBSurveyVotersListUiBinder extends UiBinder<Widget, UiBSurveyVotersList> {
	}

	private final FetchHRDFabricCountingResultServiceAsync FetchFabricCountingResultAsync = GWT.create(FetchHRDFabricCountingResultService.class);
	AsyncDataProvider<SerializeHRDFabricCountingResultEntity> provider = new AsyncDataProvider<SerializeHRDFabricCountingResultEntity>() {
		@Override
		protected void onRangeChanged(HasData<SerializeHRDFabricCountingResultEntity> display) {
			//sort用
			final ColumnSortList sortList = datagrid.getColumnSortList();
			final Range range = display.getVisibleRange();
			final int start = range.getStart();
			final int end = start + range.getLength();
			int length = display.getVisibleRange().getLength();
			AsyncCallback<List<SerializeHRDFabricCountingResultEntity>> callback = new AsyncCallback<List<SerializeHRDFabricCountingResultEntity>>() {
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
				public void onSuccess(List<SerializeHRDFabricCountingResultEntity> result) {
					if(result.size() >= 100){
						Collections.sort(result, new Comparator<SerializeHRDFabricCountingResultEntity>() {
							public int compare(SerializeHRDFabricCountingResultEntity o1,SerializeHRDFabricCountingResultEntity o2) {
								if(o1 == o2){
									return 0;
								}
								int diff = -1;
								if (o1 != null) {
					                  diff = (o2 != null) ? o1.getId().compareTo(o2.getId()) : 1;
					                }
					                return sortList.get(0).isAscending() ? diff : -diff;
					              }
						});
						updateRowData(start, result.subList(start, end));
						updateRowCount(result.size(), true);
//						pager.setDisplay(datagrid);
					}else{
						Collections.sort(result, new Comparator<SerializeHRDFabricCountingResultEntity>() {
							public int compare(SerializeHRDFabricCountingResultEntity o1,SerializeHRDFabricCountingResultEntity o2) {
								if(o1 == o2){
									return 0;
								}
								int diff = -1;
								if (o1 != null) {
					                  diff = (o2 != null) ? o1.getId().compareTo(o2.getId()) : 1;
					                }
					                return sortList.get(0).isAscending() ? diff : -diff;
					              }
						});
						updateRowData(start, result);
						}
					}
			};
			FetchFabricCountingResultAsync.getRange(0,0,callback);
		}
	};
	//項目設定
	public void initTableColumns(final SelectionModel<SerializeHRDFabricCountingResultEntity> selectionModel){
		datagrid.setMinimumTableWidth(90, Unit.EM);
		datagrid.setWidth("100%");
		datagrid.setHeight("100%");
		/**
		 * checkbox Column
		 */
		Column<SerializeHRDFabricCountingResultEntity, Boolean> checkColumn = new Column<SerializeHRDFabricCountingResultEntity, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(SerializeHRDFabricCountingResultEntity object) {
				return selectionModel.isSelected(object);
			}
		};
		datagrid.addColumn(checkColumn, "選択");
		datagrid.setColumnWidth(checkColumn, 00.4, Unit.EM);
		checkColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		/**
		 *Name Text Column
		 */
		final TextColumn<SerializeHRDFabricCountingResultEntity> NameColumn = new TextColumn<SerializeHRDFabricCountingResultEntity>() {
			@Override
			public String getValue(SerializeHRDFabricCountingResultEntity object) {
				String name = object.getName();
					return name;
				}
			};
			datagrid.addColumn(NameColumn, "名前");
			datagrid.setColumnWidth(NameColumn, 02.0, Unit.EM);
//			dataGrid.addColumnSortHandler(sortHandler);
			datagrid.getColumnSortList().push(NameColumn);

		/**
		*Section Text Column
		*/
		final TextColumn<SerializeHRDFabricCountingResultEntity> SectioneColumn = new TextColumn<SerializeHRDFabricCountingResultEntity>() {
			@Override
			public String getValue(SerializeHRDFabricCountingResultEntity object) {
				String section = object.getSection();
					return section;
				}
			};
			datagrid.addColumn(SectioneColumn, "部門");
			datagrid.setColumnWidth(SectioneColumn, 02.0, Unit.EM);
//			dataGrid.addColumnSortHandler(sortHandler);
			datagrid.getColumnSortList().push(SectioneColumn);
		/**
		*Date Text Column
		*/
		final TextColumn<SerializeHRDFabricCountingResultEntity> DateColumn = new TextColumn<SerializeHRDFabricCountingResultEntity>() {
			@Override
			public String getValue(SerializeHRDFabricCountingResultEntity object) {
				String date = object.getInputdate();
					return date;
				}
			};
			datagrid.addColumn(DateColumn, "投票日");
			datagrid.setColumnWidth(DateColumn, 01.8, Unit.EM);
//			dataGrid.addColumnSortHandler(sortHandler);
			datagrid.getColumnSortList().push(DateColumn);
		/**
		*Voted Text Column
		*/
		final TextColumn<SerializeHRDFabricCountingResultEntity>VotedColumn = new TextColumn<SerializeHRDFabricCountingResultEntity>() {
			@Override
			public String getValue(SerializeHRDFabricCountingResultEntity object) {
				String voted = object.getVoted();
					return voted;
				}
			};
			datagrid.addColumn(VotedColumn, "幕番号");
			datagrid.setColumnWidth(VotedColumn, 04.0, Unit.EM);
//			dataGrid.addColumnSortHandler(sortHandler);
			datagrid.getColumnSortList().push(VotedColumn);
	}

	public UiBSurveyVotersList() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public UiBSurveyVotersList(final String LoginUserName, final String Authority) {
		initWidget(uiBinder.createAndBindUi(this));
		username = LoginUserName;
		auth = Authority;
		provider.addDataDisplay(datagrid);
		final MultiSelectionModel<SerializeHRDFabricCountingResultEntity> selectionModel = new MultiSelectionModel<SerializeHRDFabricCountingResultEntity>();
		datagrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDFabricCountingResultEntity>createCheckboxManager());
		datagrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		//sort用
//		AsyncHandler columnSortHandler = new AsyncHandler(dataGrid);
//		dataGrid.addColumnSortHandler(columnSortHandler);
		initTableColumns(selectionModel);

		//Navbar設定
		responsiveNavBar.add(Nav);
		responsiveNavBar.add(navRight);
		//NavBarに設定メニュー(ドロップダウン)追加
		com.github.gwtbootstrap.client.ui.Dropdown dropdown_setting = new com.github.gwtbootstrap.client.ui.Dropdown();
		dropdown_setting.setIcon(IconType.GROUP);
		dropdown_setting.setText("ユーザー");
		navlink_user.setIcon(IconType.COG);
		navlink_user.setText("ユーザー設定");
		navlink_user.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	            	UiBBasicUserInfoView userview = new UiBBasicUserInfoView(LoginUserName, Authority);
	            	RootLayoutPanel.get().add(userview);
	                History.newItem("UserList:");
	            }
	        });
	        dropdown_setting.add(navlink_user);
	        Nav.add(dropdown_setting);

		//NavBarに拠点メニュー(ドロップダウン)追加
        com.github.gwtbootstrap.client.ui.Dropdown dropdown_location = new com.github.gwtbootstrap.client.ui.Dropdown();
        navlink_dept.setIcon(IconType.BUILDING);
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
        		UiBFabricInfo fabricview = new UiBFabricInfo(username,auth);
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
//        navLink_Surveyresult.setIcon(IconType.GROUP);
//        navLink_Surveyresult.setText("投票者一覧");
//        navLink_Surveyresult.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//            	RootLayoutPanel.get().remove(0);
//        		UiBSurveyVotersList votelist = new UiBSurveyVotersList(username,auth);
//        		RootLayoutPanel.get().add(votelist);
//                History.newItem("Voters:");
//            }
//        });
        NavLink navLink_surveyresult02 = new NavLink();
        navLink_surveyresult02.setIcon(IconType.BAR_CHART);
        navLink_surveyresult02.setText("投票数ランキング");
        navLink_surveyresult02.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootLayoutPanel.get().remove(0);
        		UiBVotedColumnChart chart = new UiBVotedColumnChart(LoginUserName, Authority);
        		RootLayoutPanel.get().add(chart);
        		History.newItem("charts:");
			}
		});
        NavLink navLink_surveyresult03 = new NavLink();
        navLink_surveyresult03.setIcon(IconType.STAR);
        navLink_surveyresult03.setText("幕に対する投票者情報");
        navLink_surveyresult03.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootLayoutPanel.get().remove(0);
        		UiBVotedFabricList votedfabric = new UiBVotedFabricList(username, auth);
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
        dropdown_survey.add(navLink_surveyresult02);
//        dropdown_survey.add(navLink_Surveyresult);
        Nav.add(dropdown_survey);

      //NavBarにユーザーメニュー(ドロップダウン)追加
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

        NavLink navLink_DataRefresh = new NavLink();
        navLink_DataRefresh.setIcon(IconType.REFRESH);
	      //データリフレッシュ
	        navLink_DataRefresh.setText("最新データ取得");
	        navLink_DataRefresh.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
						datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
				}
			});
	        dropdown_logout.add(navLink_DataRefresh);
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
					modal.setPixelSize(480, 280);
					modal.add(UserMode);
					modal.show();
				}
			});
	        dropdown_logout.add(navLink_ViewMode);
	        navRight.add(dropdown_logout);
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

}
