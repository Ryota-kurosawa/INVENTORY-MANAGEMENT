package com.krsw.InventoryManagement.client.UiBinder.Location;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
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
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.krsw.InventoryManagement.client.HRD.Accounts.SerializeHRDBasicUserInfoEntity;
import com.krsw.InventoryManagement.client.HRD.Location.AddHRDLocationInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Location.AddHRDLocationInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Location.FetchHRDLocationInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Location.FetchHRDLocationInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Location.SerializeHRDLocationInfoEntity;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.client.UiBinder.UiBBasicUserInfoView;
import com.krsw.InventoryManagement.client.UiBinder.UiBGeneralUserModeView;
import com.krsw.InventoryManagement.client.UiBinder.UiBModalDeleteVoteData;
import com.krsw.InventoryManagement.client.UiBinder.UiBSurveyVotersList;
import com.krsw.InventoryManagement.client.UiBinder.UiBVotedColumnChart;
import com.krsw.InventoryManagement.client.UiBinder.UiBVotedFabricList;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBFabricInfo;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionModel;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Nav;

public class UiBLocationInfoEdit extends Composite implements HasText {

	private static UiBLocationInfoEditUiBinder uiBinder = GWT.create(UiBLocationInfoEditUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField ResponsiveNavbar responsiveNavBar;
	@UiField(provided=true) DataGrid<SerializeHRDLocationInfoEntity> datagrid = new DataGrid<SerializeHRDLocationInfoEntity>(50, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField TextBox txtbox_address;
	@UiField TextBox txtbox_name;
	@UiField IntegerBox intbox_number;
	@UiField CheckBox checkbox_enabled;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_Register;
	@UiField Image image_Minispin;
	@UiField NavLink navLink_Stockfabric;
	@UiField NavLink navlink_dept;
	@UiField NavLink navlink_Surveyresult;
	@UiField NavLink navLink_Usersetting;
	@UiField NavLink navLink_Username;
	@UiField Nav Nav;
	@UiField Nav navRight;
	String registerDate = null;
	String updateDate = null;
	Long id = null;
	String username = "";
	String auth = "";
	String StatusLabelString = "一般ユーザービューモード設定";

	interface UiBLocationInfoEditUiBinder extends UiBinder<Widget, UiBLocationInfoEdit> {
	}

	private final FetchHRDLocationInfoEntityServiceAsync FetchLocationInfoAsync = GWT.create(FetchHRDLocationInfoEntityService.class);
	AsyncDataProvider<SerializeHRDLocationInfoEntity> provider = new AsyncDataProvider<SerializeHRDLocationInfoEntity>() {
		@Override
		protected void onRangeChanged( HasData<SerializeHRDLocationInfoEntity> display) {
			//sort用
			final ColumnSortList sortList = datagrid.getColumnSortList();
			final Range range = display.getVisibleRange();
			final int start = range.getStart();
			final int end = start + range.getLength();
			int length = display.getVisibleRange().getLength();
			AsyncCallback<List<SerializeHRDLocationInfoEntity>> callback = new AsyncCallback<List<SerializeHRDLocationInfoEntity>>() {
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
				public void onSuccess(List<SerializeHRDLocationInfoEntity> result) {
					if(result.size() >= 50){
						Collections.sort(result, new Comparator<SerializeHRDLocationInfoEntity>() {
							public int compare(SerializeHRDLocationInfoEntity o1,SerializeHRDLocationInfoEntity o2) {
								if(o1 == o2){
									return 0;
								}
								int diff = -1;
								if (o1 != null) {
					                  diff = (o2 != null) ? Long.valueOf(o1.getNumber()).compareTo(Long.valueOf(o2.getNumber())) : 1;
					                }
					                return sortList.get(0).isAscending() ? diff : -diff;
					              }
						});
						updateRowData(start, result.subList(start, end));
						updateRowCount(result.size(), true);
//						pager.setDisplay(datagrid);
					}else{
						Collections.sort(result, new Comparator<SerializeHRDLocationInfoEntity>() {
							public int compare(SerializeHRDLocationInfoEntity o1,SerializeHRDLocationInfoEntity o2) {
								if(o1 == o2){
									return 0;
								}
								int diff = -1;
								if (o1 != null) {
					                  diff = (o2 != null) ? Long.valueOf(o1.getNumber()).compareTo(Long.valueOf(o2.getNumber())) : 1;
					                }
					                return sortList.get(0).isAscending() ? diff : -diff;
					              }
						});
						updateRowData(start, result);
						}
					}
				};
				FetchLocationInfoAsync.getAvailabilityRange2("", callback);
			}
	};

	//項目設定
	public void initTableColumns(final SelectionModel<SerializeHRDLocationInfoEntity> selectionModel, AsyncHandler sortHandler){
		datagrid.setMinimumTableWidth(90, Unit.EM);
		datagrid.setWidth("100%");
		datagrid.setHeight("100%");
		/**
		 * checkbox Column
		 */
		Column<SerializeHRDLocationInfoEntity, Boolean> checkColumn = new Column<SerializeHRDLocationInfoEntity, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(SerializeHRDLocationInfoEntity object) {
				return selectionModel.isSelected(object);
			}
		};
		datagrid.addColumn(checkColumn, "選択");
		datagrid.setColumnWidth(checkColumn, 00.4, Unit.EM);
		checkColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		/**
		 * Button Column
		 */
		ButtonCell updateButton = new ButtonCell(IconType.PENCIL, ButtonType.SUCCESS, ButtonSize.SMALL);
		Column<SerializeHRDLocationInfoEntity, String> ButtonColumn = new Column<SerializeHRDLocationInfoEntity, String>(updateButton) {
			@Override
			public String getValue(SerializeHRDLocationInfoEntity object) {
				return "編集";
			}
		};
		ButtonColumn.setFieldUpdater(new FieldUpdater<SerializeHRDLocationInfoEntity, String>() {
			public void update(int index, SerializeHRDLocationInfoEntity object,String value) {
				id = object.getId();
				txtbox_name.setText(object.getName());
				txtbox_address.setText(object.getAddress());
				intbox_number.setValue(object.getNumber());
				checkbox_enabled.setValue(object.getEnable());
				txtbox_name.setEnabled(true);
				txtbox_address.setEnabled(true);
				intbox_number.setEnabled(true);
				checkbox_enabled.setEnabled(true);
				btn_Register.setText("更新");
				btn_Register.setType(ButtonType.SUCCESS);
				btn_Register.setIcon(IconType.PENCIL);

			}
		});
		datagrid.addColumn(ButtonColumn, "編集");
		datagrid.setColumnWidth(ButtonColumn, 00.7, Unit.EM);
//		ButtonColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		/**
		 *id Text Column 非表示項目
		 */
		final TextColumn<SerializeHRDLocationInfoEntity> IdColumn = new TextColumn<SerializeHRDLocationInfoEntity>() {
			@Override
			public String getValue(SerializeHRDLocationInfoEntity object) {
				String id = Long.toString(object.getId());
					return id;
				}
			};
//			datagrid.addColumn(IdColumn, "ID");
//			datagrid.setColumnWidth(IdColumn, 00.6, Unit.EM);
////			dataGrid.addColumnSortHandler(sortHandler);
//			datagrid.getColumnSortList().push(IdColumn);

			/**
			 *Number(int) Text Column
			 */
			final TextColumn<SerializeHRDLocationInfoEntity> ControlNumberColumn = new TextColumn<SerializeHRDLocationInfoEntity>() {
				@Override
				public String getValue(SerializeHRDLocationInfoEntity object) {
					String ControlNumber = String.valueOf(object.getNumber());
						return ControlNumber;
					}
				};
				datagrid.addColumn(ControlNumberColumn, "拠点No.");
				datagrid.setColumnWidth(ControlNumberColumn, 00.7, Unit.EM);
				datagrid.addColumnSortHandler(sortHandler);
				datagrid.getColumnSortList().push(ControlNumberColumn);

				/**
				 *Name(String) Text Column
				 */
				final TextColumn<SerializeHRDLocationInfoEntity> NameColumn = new TextColumn<SerializeHRDLocationInfoEntity>() {
					@Override
					public String getValue(SerializeHRDLocationInfoEntity object) {
						String name = object.getName();
							return name;
						}
					};
					datagrid.addColumn(NameColumn, "拠点名称");
					datagrid.setColumnWidth(NameColumn, 02.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(NameColumn);

					/**
					 *Address(String) Text Column
					 */
					final TextColumn<SerializeHRDLocationInfoEntity> AddressColumn = new TextColumn<SerializeHRDLocationInfoEntity>() {
						@Override
						public String getValue(SerializeHRDLocationInfoEntity object) {
							String address = object.getAddress();
								return address;
							}
						};
						datagrid.addColumn(AddressColumn, "拠点住所");
						datagrid.setColumnWidth(AddressColumn, 02.0, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						datagrid.getColumnSortList().push(AddressColumn);
						/**
						 *Address(String) Text Column
						 */
						final TextColumn<SerializeHRDLocationInfoEntity> EnabledColumn = new TextColumn<SerializeHRDLocationInfoEntity>() {
							@Override
							public String getValue(SerializeHRDLocationInfoEntity object) {
								if(object.getEnable() == true){
									return "有効";
								}else{
									return "無効";
								}
							}
						};
						datagrid.addColumn(EnabledColumn, "有効/無効");
						datagrid.setColumnWidth(EnabledColumn, 02.0, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						datagrid.getColumnSortList().push(EnabledColumn);

	}

	public UiBLocationInfoEdit(final String LoginUserName, final String Authority) {
		initWidget(uiBinder.createAndBindUi(this));
		username = LoginUserName;
		auth = Authority;
		image_Minispin.setVisible(false);
		provider.addDataDisplay(datagrid);
		final MultiSelectionModel<SerializeHRDLocationInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDLocationInfoEntity>();
		datagrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDLocationInfoEntity>createCheckboxManager());
		datagrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		//sort用
		AsyncHandler columnSortHandler = new AsyncHandler(datagrid);
		datagrid.addColumnSortHandler(columnSortHandler);
		initTableColumns(selectionModel, columnSortHandler);

		//Navbar設定
		responsiveNavBar.add(Nav);
		responsiveNavBar.add(navRight);
		//NavBarに設定メニュー(ドロップダウン)追加
		com.github.gwtbootstrap.client.ui.Dropdown dropdown_setting = new com.github.gwtbootstrap.client.ui.Dropdown();
		dropdown_setting.setIcon(IconType.GROUP);
		dropdown_setting.setText("ユーザー");
		navLink_Usersetting.setIcon(IconType.COG);
	        navLink_Usersetting.setText("ユーザー設定");
	        navLink_Usersetting.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	            	UiBBasicUserInfoView userview = new UiBBasicUserInfoView(LoginUserName, Authority);
	            	RootLayoutPanel.get().add(userview);
	                History.newItem("UserList:");
	            }
	        });
	        dropdown_setting.add(navLink_Usersetting);
	        Nav.add(dropdown_setting);

	      //アンケート状況設定
	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_survey = new com.github.gwtbootstrap.client.ui.Dropdown();
	        dropdown_survey.setIcon(IconType.COMMENTS);
	        dropdown_survey.setText("アンケート");
	        navlink_Surveyresult.setIcon(IconType.GROUP);
	        navlink_Surveyresult.setText("投票者一覧");
	        navlink_Surveyresult.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	        		UiBSurveyVotersList votelist = new UiBSurveyVotersList(username,auth);
	        		RootLayoutPanel.get().add(votelist);
	                History.newItem("Voters:");
	            }
	        });
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
	        dropdown_survey.add(navlink_Surveyresult);
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
		      //一般ユーザーレビューモード設定
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

		        //在庫幕設定
		        com.github.gwtbootstrap.client.ui.Dropdown dropdown_fabric = new com.github.gwtbootstrap.client.ui.Dropdown();
		        dropdown_fabric.setIcon(IconType.CLOUD);
		        dropdown_fabric.setText("在庫");
		        navLink_Stockfabric.setIcon(IconType.COG);
		        navLink_Stockfabric.setText("在庫幕設定");
		        navLink_Stockfabric.addClickHandler(new ClickHandler() {
		            public void onClick(ClickEvent event) {
		            	RootLayoutPanel.get().remove(0);
//		        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
		        		UiBFabricInfo fabricview = new UiBFabricInfo(LoginUserName, Authority);
		        		RootLayoutPanel.get().add(fabricview);
		                History.newItem("FabricList:");
		            }
		        });
		        dropdown_fabric.add(navLink_Stockfabric);
		        Nav.add(dropdown_fabric);
	}

	public UiBLocationInfoEdit(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	private final AddHRDLocationInfoEntityServiceAsync AddLocationInfoEntityAsync = GWT.create(AddHRDLocationInfoEntityService.class);

	@UiHandler("btn_Register")
	void onBtn_RegisterClick(ClickEvent event) {
		if(txtbox_name.getText() == ""){
			Window.alert("未入力項目があります。");
			return;
		}
		if(btn_Register.getType() == ButtonType.PRIMARY){
			if(Window.confirm("この情報を登録しますか?") == false){
				image_Minispin.setVisible(false);
				return;
			}
			image_Minispin.setVisible(true);
			final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
			Calendar now = Calendar.getInstance();
			int h = now.get(now.HOUR_OF_DAY);
			int m = now.get(now.MINUTE);
			int s = now.get(now.SECOND);
			registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			AddLocationInfoEntityAsync.AddHRDLocationInfoEntity(null, intbox_number.getValue(), txtbox_name.getText(),
					txtbox_address.getText(), checkbox_enabled.getValue(), registerDate, updateDate,
					"", "", "", "", "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("登録しました。");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}

			});
		}else if(btn_Register.getType() == ButtonType.SUCCESS){
			if(Window.confirm("この情報を更新しますか?") == false){
				return;
			}
			image_Minispin.setVisible(true);
			final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
			Calendar now = Calendar.getInstance();
			int h = now.get(now.HOUR_OF_DAY);
			int m = now.get(now.MINUTE);
			int s = now.get(now.SECOND);
			registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			Window.alert(txtbox_name.getText());
			AddLocationInfoEntityAsync.AddHRDLocationInfoEntity(id, intbox_number.getValue(), txtbox_name.getText(),
					txtbox_address.getText(), checkbox_enabled.getValue(), registerDate, updateDate,
					"", "", "", "", "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("更新しました。");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}
			});
		}else if(btn_Register.getType() == ButtonType.DANGER){
			if(Window.confirm("この情報を削除しますか?") == false){
				return;
			}
			if(Window.confirm("削除するとデータは復元できません\n本当に削除してもよろしいですか?") == false){
				return;
			}
			image_Minispin.setVisible(true);
			final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
			Calendar now = Calendar.getInstance();
			int h = now.get(now.HOUR_OF_DAY);
			int m = now.get(now.MINUTE);
			int s = now.get(now.SECOND);
			registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			AddLocationInfoEntityAsync.AddHRDLocationInfoEntity(id, intbox_number.getValue(), txtbox_name.getText(),
					txtbox_address.getText(), checkbox_enabled.getValue(), registerDate, updateDate,
					"Delete@" + registerDate, "", "", "", "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("削除しました。");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}
			});
		}
	}
	@UiHandler("btn_radio_regist")
	void onBtn_radio_registClick(ClickEvent event) {
		btn_Register.setType(ButtonType.PRIMARY);
		btn_Register.setIcon(IconType.PLUS_SIGN);
		btn_Register.setText("登録");
		txtbox_name.setText("");
		txtbox_address.setText("");
		intbox_number.setValue(null);
		txtbox_name.setEnabled(true);
		txtbox_address.setEnabled(true);
		intbox_number.setEnabled(true);
	}
	@UiHandler("btn_radio_delete")
	void onBtn_radio_deleteClick(ClickEvent event) {
		btn_Register.setType(ButtonType.DANGER);
		btn_Register.setIcon(IconType.REMOVE_SIGN);
		btn_Register.setText("削除");
		txtbox_name.setEnabled(false);
		txtbox_address.setEnabled(false);
		intbox_number.setEnabled(false);
	}
}
