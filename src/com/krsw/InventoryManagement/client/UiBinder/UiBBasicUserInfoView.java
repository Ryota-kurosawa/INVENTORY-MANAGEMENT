package com.krsw.InventoryManagement.client.UiBinder;

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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionModel;
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;
import com.krsw.InventoryManagement.client.HRD.Accounts.AddHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.AddHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Accounts.FetchHRDBasicUserInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Accounts.SerializeHRDBasicUserInfoEntity;
import com.krsw.InventoryManagement.client.HRD.ViewMode.AddHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.AddHRDGeneralUserModeEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityService;
import com.krsw.InventoryManagement.client.HRD.ViewMode.FetchHRDGeneralUserModeEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.ViewMode.SerializeHRDGeneralUserModeEntity;
import com.krsw.InventoryManagement.client.UiBinder.Location.UiBLocationInfoEdit;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBFabricInfo;
import com.krsw.InventoryManagement.shared.FieldVerifier;
import com.krsw.InventoryManagement.shared.HashUtilMD5;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.RowHoverEvent;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.Nav;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.github.gwtbootstrap.client.ui.Well;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.WellForm;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.FormLabel;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Image;

public class UiBBasicUserInfoView extends Composite implements HasText {

	private static UiBBasicUserInfoViewUiBinder uiBinder = GWT.create(UiBBasicUserInfoViewUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField(provided=true) DataGrid<SerializeHRDBasicUserInfoEntity> dataGrid = new DataGrid<SerializeHRDBasicUserInfoEntity>(100, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField NavLink navLink_username;
	@UiField NavLink navLink_surveyresult;
	@UiField ResponsiveNavbar ResponsiveNavBar;
	@UiField Nav nav;
	@UiField Nav navright;
	@UiField NavLink navlink_Section;
	@UiField NavLink navlink_Dept;
	@UiField NavLink navLink_stockfabric;
//	@UiField Well well;
	@UiField Button btn_register;
	@UiField WellForm wellform;
	@UiField LayoutPanel layoutpanel;
	@UiField ListBox cmbbox_Authority;
	@UiField TextBox txtbox_lastname;
	@UiField TextBox txtbox_firstname;
//	@UiField FormLabel formLabel;
	@UiField ListBox cmbbox_Section;
	@UiField TextBox txtbox_loginid;
	@UiField PasswordTextBox txtbox_password;
	@UiField TextBox txtbox_Email;
	@UiField CheckBox checkbox_Enabled;
	@UiField Button btn_radio_regist;
//	@UiField Button btn_radio_update;
	@UiField Button btn_radio_delete;
//	@UiField Button buttontoggle_enabled;
	@UiField Image image_minispin;
	String registerDate = null;
	String updateDate = null;
	Long id = null;
	String username = "";
	String auth = "";
	String StatusLabelString = "一般ユーザービューモード設定";
	final RootPanel BrowserRoot_UserBasicInfoView = RootPanel.get("StockFabricViewPNL");


	interface UiBBasicUserInfoViewUiBinder extends UiBinder<Widget, UiBBasicUserInfoView> {
	}

	private final FetchHRDBasicUserInfoEntityServiceAsync FetchBasicUserInfoAsync = GWT.create(FetchHRDBasicUserInfoEntityService.class);
	AsyncDataProvider<SerializeHRDBasicUserInfoEntity> provider = new AsyncDataProvider<SerializeHRDBasicUserInfoEntity>() {
		@Override
		protected void onRangeChanged(HasData<SerializeHRDBasicUserInfoEntity> display) {
			//sort用
			final ColumnSortList sortList = dataGrid.getColumnSortList();
			final Range range = display.getVisibleRange();
			final int start = range.getStart();
			final int end = start + range.getLength();
			int length = display.getVisibleRange().getLength();
			AsyncCallback<List<SerializeHRDBasicUserInfoEntity>> callback = new AsyncCallback<List<SerializeHRDBasicUserInfoEntity>>() {
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
				public void onSuccess(List<SerializeHRDBasicUserInfoEntity> result) {
					if(result.size() >= 100){
						Collections.sort(result, new Comparator<SerializeHRDBasicUserInfoEntity>() {
							public int compare(SerializeHRDBasicUserInfoEntity o1,SerializeHRDBasicUserInfoEntity o2) {
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
						Collections.sort(result, new Comparator<SerializeHRDBasicUserInfoEntity>() {
							public int compare(SerializeHRDBasicUserInfoEntity o1,SerializeHRDBasicUserInfoEntity o2) {
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
			FetchBasicUserInfoAsync.getAvailabilityUser("", callback);
		}
	};
	//項目設定
	public void initTableColumns(final SelectionModel<SerializeHRDBasicUserInfoEntity> selectionModel){
		dataGrid.setMinimumTableWidth(90, Unit.EM);
		dataGrid.setWidth("100%");
		dataGrid.setHeight("100%");

		/**
		 * checkbox Column
		 */
		Column<SerializeHRDBasicUserInfoEntity, Boolean> checkColumn = new Column<SerializeHRDBasicUserInfoEntity, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(SerializeHRDBasicUserInfoEntity object) {
				return selectionModel.isSelected(object);
			}
		};
		dataGrid.addColumn(checkColumn, "選択");
		dataGrid.setColumnWidth(checkColumn, 00.4, Unit.EM);
		checkColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		/**
		 * Button Column
		 */
		ButtonCell updateButton = new ButtonCell(IconType.PENCIL, ButtonType.SUCCESS, ButtonSize.SMALL);
		Column<SerializeHRDBasicUserInfoEntity, String> ButtonColumn = new Column<SerializeHRDBasicUserInfoEntity, String>(updateButton) {
			@Override
			public String getValue(SerializeHRDBasicUserInfoEntity object) {
				return "編集";
			}
		};
		ButtonColumn.setFieldUpdater(new FieldUpdater<SerializeHRDBasicUserInfoEntity, String>() {
			public void update(int index, SerializeHRDBasicUserInfoEntity object,String value) {
				id = object.getId();
				txtbox_lastname.setText(object.getLastName());
				txtbox_firstname.setText(object.getFirstName());
				cmbbox_Section.setSelectedValue(object.getSection());
				cmbbox_Authority.setSelectedValue(object.getAuthority());
				txtbox_loginid.setText(object.getLoginId());
				txtbox_password.setText(object.getLoginPassword());
				txtbox_password.setEnabled(false);
				txtbox_Email.setText(object.getEmail());
				btn_register.setType(ButtonType.SUCCESS);
				btn_register.setIcon(IconType.PENCIL);
				btn_register.setText("更新");
				setFormPartsEnabled();
				if(object.getEnable() == true){
//					buttontoggle_enabled.setToggle(object.getEnable());
					checkbox_Enabled.setText("アカウント有効");
					checkbox_Enabled.setValue(true);
//					buttontoggle_enabled.setIcon(IconType.CHECK);
//					buttontoggle_enabled.setType(ButtonType.INFO);
				}else if(object.getEnable() == false){
//					buttontoggle_enabled.setToggle(object.getEnable());
					checkbox_Enabled.setText("アカウント無効");
					checkbox_Enabled.setValue(false);
//					buttontoggle_enabled.setIcon(IconType.CHECK_EMPTY);
//					buttontoggle_enabled.setType(ButtonType.INVERSE);
				}
			}
		});
		dataGrid.addColumn(ButtonColumn, "編集");
		dataGrid.setColumnWidth(ButtonColumn, 00.7, Unit.EM);
//		ButtonColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		/**
		 *id Text Column 非表示項目
		 */
		final TextColumn<SerializeHRDBasicUserInfoEntity> IdColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
			@Override
			public String getValue(SerializeHRDBasicUserInfoEntity object) {
				String id = Long.toString(object.getId());
					return id;
				}
			};
//			dataGrid.addColumn(IdColumn, "ID");
//			dataGrid.setColumnWidth(IdColumn, 00.5, Unit.EM);
////			dataGrid.addColumnSortHandler(sortHandler);
//			dataGrid.getColumnSortList().push(IdColumn);

			/**
			 *Name Text Column
			 */
			final TextColumn<SerializeHRDBasicUserInfoEntity> NameColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
				@Override
				public String getValue(SerializeHRDBasicUserInfoEntity object) {
					String name = object.getLastName() + object.getFirstName();
						return name;
					}
				};
				dataGrid.addColumn(NameColumn, "名前");
				dataGrid.setColumnWidth(NameColumn, 01.0, Unit.EM);
//				dataGrid.addColumnSortHandler(sortHandler);
				dataGrid.getColumnSortList().push(NameColumn);

				/**
				 *Section Text Column
				 */
				final TextColumn<SerializeHRDBasicUserInfoEntity> SectionColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String section = object.getSection();
							return section;
						}
					};
					dataGrid.addColumn(SectionColumn, "所属部門");
					dataGrid.setColumnWidth(SectionColumn, 02.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(SectionColumn);

				/**
				 *Authority Text Column
				 */
				final TextColumn<SerializeHRDBasicUserInfoEntity> AuthorityColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String authority = object.getAuthority();
							return authority;
						}
					};
					dataGrid.addColumn(AuthorityColumn, "権限");
					dataGrid.setColumnWidth(AuthorityColumn, 0.5, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(AuthorityColumn);

				/**
					*LoginId Text Column
				 */
				final TextColumn<SerializeHRDBasicUserInfoEntity> LoginIdColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String loginid = String.valueOf(object.getLoginId());
							return loginid;
						}
					};
					dataGrid.addColumn(LoginIdColumn, "ログインID");
					dataGrid.setColumnWidth(LoginIdColumn, 00.8, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(LoginIdColumn);

				/**
				*LoginPassword Text Column
				 */
				final TextColumn<SerializeHRDBasicUserInfoEntity> LoginPasswordColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String loginpassword = object.getLoginPassword();
							return loginpassword;
						}
					};
					dataGrid.addColumn(LoginPasswordColumn, "ログインPASS");
					dataGrid.setColumnWidth(LoginPasswordColumn, 2.3, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(LoginPasswordColumn);

				/**
				*Email Text Column
				*/
				final TextColumn<SerializeHRDBasicUserInfoEntity> EmailColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String email = object.getEmail();
							return email;
						}
					};
					dataGrid.addColumn(EmailColumn, "Mail");
					dataGrid.setColumnWidth(EmailColumn, 1.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(EmailColumn);

				/**
				*Enable Column
				*/
				final TextColumn<SerializeHRDBasicUserInfoEntity> EnableColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						if(object.getEnable() == true){
							return "有効";
							}else{
							return "無効";
							}
						}
					};
					dataGrid.addColumn(EnableColumn, "状態");
					dataGrid.setColumnWidth(EnableColumn,0.4, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(EnableColumn);

				/**
				*CreateDate Text Column
				*/
				final TextColumn<SerializeHRDBasicUserInfoEntity> CreateDateColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String createdate = object.getCreateDate();
							return createdate;
						}
					};
					dataGrid.addColumn(CreateDateColumn, "登録日時");
					dataGrid.setColumnWidth(CreateDateColumn, 01.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(CreateDateColumn);

				/**
				*UpdateDate Text Column
				*/
				final TextColumn<SerializeHRDBasicUserInfoEntity> UpdateDateColumn = new TextColumn<SerializeHRDBasicUserInfoEntity>() {
					@Override
					public String getValue(SerializeHRDBasicUserInfoEntity object) {
						String updatedate = object.getUpdateDate();
							return updatedate;
						}
					};
					dataGrid.addColumn(UpdateDateColumn, "更新日時");
					dataGrid.setColumnWidth(UpdateDateColumn, 01.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(UpdateDateColumn);
	}

	/**
	 * コンストラクタ
	 */
	public UiBBasicUserInfoView() {
		initWidget(uiBinder.createAndBindUi(this));
		ResourceInjector.injectResourceCssAsFile("bootstrap-ie7buttonfix.css");
		setTabIndex();
		image_minispin.setVisible(false);
		provider.addDataDisplay(dataGrid);
		final MultiSelectionModel<SerializeHRDBasicUserInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDBasicUserInfoEntity>();
		dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDBasicUserInfoEntity>createCheckboxManager());
		dataGrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		//sort用
//		AsyncHandler columnSortHandler = new AsyncHandler(dataGrid);
//		dataGrid.addColumnSortHandler(columnSortHandler);
		initTableColumns(selectionModel);
		setFormPartsDisabled();
		Window.addWindowClosingHandler(new Window.ClosingHandler() {
	        public void onWindowClosing(final ClosingEvent event) {
	           if(Window.confirm("ログアウトしてもよろしいですか?") == true){
	        	   History.newItem("");
           			Window.Location.reload();
	           }else{
	        	   return;
	           }
	        }
	    });
	}



	/**
	 * コンストラクタ
	 * @param LoginUserName
	 * @param Authority
	 */
	public UiBBasicUserInfoView(final String LoginUserName, final String Authority) {
		initWidget(uiBinder.createAndBindUi(this));
		Window.addWindowClosingHandler(new Window.ClosingHandler() {
	        public void onWindowClosing(final ClosingEvent event) {
	           if(Window.confirm("ログアウトしてもよろしいですか?") == true){
	        	   History.newItem("");
           			Window.Location.reload();
	           }else{
	        	   return;
	           }
	        }
	    });
		ResourceInjector.injectResourceCssAsFile("bootstrap-ie7buttonfix.css");
//		Window.alert(History.getToken());
		setTabIndex();
		username = LoginUserName;
		auth = Authority;
		image_minispin.setVisible(false);
		FieldVerifier.createSectionBox(cmbbox_Section);
		FieldVerifier.createAuthBox(cmbbox_Authority);
//		if(Authority.equals("管理者")){
			provider.addDataDisplay(dataGrid);
			final MultiSelectionModel<SerializeHRDBasicUserInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDBasicUserInfoEntity>();
			dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDBasicUserInfoEntity>createCheckboxManager());
			dataGrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
			//sort用
//			AsyncHandler columnSortHandler = new AsyncHandler(dataGrid);
//			dataGrid.addColumnSortHandler(columnSortHandler);
			initTableColumns(selectionModel);
			setFormPartsDisabled();

	        //在庫幕設定
	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_fabric = new com.github.gwtbootstrap.client.ui.Dropdown();
	        dropdown_fabric.setIcon(IconType.CLOUD);
	        dropdown_fabric.setText("在庫");
	        navLink_stockfabric.setIcon(IconType.COG);
	        navLink_stockfabric.setText("在庫幕設定");
	        navLink_stockfabric.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	        		//管理者がログインした場合は最初にユーザーアカウント一覧を表示する。
	        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
	        		UiBFabricInfo fabricview = new UiBFabricInfo(username,auth);
	        		RootLayoutPanel.get().add(fabricview);
	                History.newItem("FabricList:");
	            }
	        });
	        dropdown_fabric.add(navLink_stockfabric);
	        nav.add(dropdown_fabric);

	        //アンケート状況設定
	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_survey = new com.github.gwtbootstrap.client.ui.Dropdown();
	        dropdown_survey.setIcon(IconType.COMMENTS);
	        dropdown_survey.setText("アンケート");
	        navLink_surveyresult.setIcon(IconType.GROUP);
	        navLink_surveyresult.setText("投票者一覧");
	        navLink_surveyresult.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
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
	        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
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
	        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
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
	        dropdown_survey.add(navLink_surveyresult);
	        nav.add(dropdown_survey);



	        //NavBarにユーザーメニュー(ドロップダウン)追加
	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_location = new com.github.gwtbootstrap.client.ui.Dropdown();
	        dropdown_location.setIcon(IconType.BUILDING);
	        dropdown_location.setText("拠点");
	        navlink_Dept.setIcon(IconType.COG);
	        navlink_Dept.setText("拠点設定");
	        navlink_Dept.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	            	UiBLocationInfoEdit locedit = new UiBLocationInfoEdit(LoginUserName, Authority);
	            	RootLayoutPanel.get().add(locedit);
	            	History.newItem("Location:");
	            }
	        });
	        dropdown_location.add(navlink_Dept);
	        nav.add(dropdown_location);

	      //NavBarにユーザーメニュー(ドロップダウン)追加
	        navLink_username.setIcon(IconType.OFF);
	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_logout = new com.github.gwtbootstrap.client.ui.Dropdown();
	        dropdown_logout.setIcon(IconType.USER);
	        dropdown_logout.setText(LoginUserName);
	        navLink_username.setIcon(IconType.OFF);
	        navLink_username.setText("ログアウト");
	        navLink_username.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	if(Window.confirm("ログアウトしますか?") == true){
	            		History.newItem("");
	            		Window.Location.reload();
	            	}else{
	            		return;
	            	}
	            }
	        });
	        dropdown_logout.add(navLink_username);
	        navright.add(dropdown_logout);

	        //データリフレッシュ
	        NavLink navLink_DataRefresh = new NavLink();
	        navLink_DataRefresh.setIcon(IconType.REFRESH);
	        navLink_DataRefresh.setText("最新データ取得");
	        navLink_DataRefresh.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
						dataGrid.setVisibleRangeAndClearData(dataGrid.getVisibleRange(), true);
				}
			});
	        dropdown_logout.add(navLink_DataRefresh);
	        navright.add(dropdown_logout);

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
	        navright.add(dropdown_logout);
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	@UiHandler("dataGrid")
	void onDataGridRowHover(RowHoverEvent event) {
//		Window.alert("onRowHover" + event.getHoveringRow().getSectionRowIndex());
	}
	@UiHandler("navlink_Section")
	void onNavlink_SectionClick(ClickEvent event) {
		History.newItem("SectionEdit");
	}
	@UiHandler("navlink_Dept")
	void onNavlink_DeptClick(ClickEvent event) {
		History.newItem("DeptEdit");
	}
	@UiHandler("htmlpanel")
	void onHtmlpanelAttachOrDetach(AttachEvent event) {

	}
	@UiHandler("btn_radio_regist")
	void onBtn_radio_registClick(ClickEvent event) {
		btn_register.setType(ButtonType.PRIMARY);
		btn_register.setIcon(IconType.PLUS_SIGN);
		btn_register.setText("登録");
		txtbox_password.setEnabled(true);
		setFormPartsEnabled();
		setFormPartsClear();
	}
//	@UiHandler("btn_radio_update")
//	void onBtn_radio_updateClick(ClickEvent event) {
//		btn_register.setType(ButtonType.SUCCESS);
//		btn_register.setIcon(IconType.PENCIL);
//		btn_register.setText("更新");
//		setFormPartsDisabled();
//	}
	@UiHandler("btn_radio_delete")
	void onBtn_radio_deleteClick(ClickEvent event) {
		btn_register.setType(ButtonType.DANGER);
		btn_register.setIcon(IconType.REMOVE_SIGN);
		btn_register.setText("削除");
		setFormPartsDisabled();
		btn_register.setEnabled(true);
	}

	private void setFormPartsDisabled(){
		txtbox_lastname.setEnabled(false);
		txtbox_firstname.setEnabled(false);
		cmbbox_Section.setEnabled(false);
		cmbbox_Authority.setEnabled(false);
		txtbox_loginid.setEnabled(false);
		txtbox_password.setEnabled(false);
		txtbox_Email.setEnabled(false);
		checkbox_Enabled.setEnabled(false);
		checkbox_Enabled.setText("アカウント無効");
		btn_register.setEnabled(false);
//		buttontoggle_enabled.setEnabled(false);
	}

	private void setFormPartsEnabled(){
		txtbox_lastname.setEnabled(true);
		txtbox_firstname.setEnabled(true);
		cmbbox_Section.setEnabled(true);
		cmbbox_Authority.setEnabled(true);
		txtbox_loginid.setEnabled(true);
//		txtbox_password.setEnabled(true);
		txtbox_Email.setEnabled(true);
		checkbox_Enabled.setEnabled(true);
		checkbox_Enabled.setText("アカウント有効");
		btn_register.setEnabled(true);
//		buttontoggle_enabled.setEnabled(true);
	}

	private void setFormPartsClear(){
		txtbox_lastname.setText("");
		txtbox_firstname.setText("");
		cmbbox_Section.setSelectedIndex(0);
		cmbbox_Authority.setSelectedIndex(0);
		txtbox_loginid.setText("");
		txtbox_password.setText("");
		txtbox_Email.setText("");
		checkbox_Enabled.setValue(false);
		btn_register.setEnabled(true);

	}

	@UiHandler("checkbox_Enabled")
	void onCheckbox_EnabledClick(ClickEvent event) {
		if(getCheckbox_Enabled() == true){
			checkbox_Enabled.setText("アカウント有効");

		}else{
			checkbox_Enabled.setText("アカウント無効");
		}
	}
//	@UiHandler("buttontoggle_enabled")
//	void onButtontoggle_enabledClick(ClickEvent event) {
//		if(buttontoggle_enabled.isToggled() == true){
//			buttontoggle_enabled.setText("アカウント無効");
//			buttontoggle_enabled.setIcon(IconType.CHECK_EMPTY);
//			buttontoggle_enabled.setType(ButtonType.INVERSE);
//			buttontoggle_enabled.setToggle(false);
//			Window.alert("isToggled() == true アカウント無効");
//		}else if(buttontoggle_enabled.isToggled() == false){
//			buttontoggle_enabled.setText("アカウント有効");
//			buttontoggle_enabled.setIcon(IconType.CHECK);
//			buttontoggle_enabled.setType(ButtonType.INFO);
//			buttontoggle_enabled.setToggle(true);
//			Window.alert("isToggled() == false アカウント有効");
//		}
//	}



	public String getCmbbox_Authority() {
		return cmbbox_Authority.getItemText(cmbbox_Authority.getSelectedIndex());
	}

	public void setCmbbox_Authority(String cmbbox_Authority) {
		this.cmbbox_Authority.setSelectedValue(cmbbox_Authority);
	}

	public String getCmbbox_Section() {
		return cmbbox_Section.getItemText(cmbbox_Section.getSelectedIndex());
	}

	public void setCmbbox_Section(String cmbbox_Section) {
		this.cmbbox_Section.setSelectedValue(cmbbox_Section);
	}

	public Boolean getCheckbox_Enabled() {
		return checkbox_Enabled.getValue();
	}

	public void setCheckbox_Enabled(Boolean checkbox_Enabled) {
		this.checkbox_Enabled.setValue(checkbox_Enabled);
	}


	private final AddHRDBasicUserInfoEntityServiceAsync AddStorageInfoEntityAsync = GWT.create(AddHRDBasicUserInfoEntityService.class);

	@UiHandler("btn_register")
	void onBtn_registerClick(ClickEvent event) {
		if(txtbox_lastname.getText() == "" || txtbox_firstname.getText() == ""){
			Window.alert("未入力項目があります。");
			return;
		}
		if(btn_register.getType() == ButtonType.PRIMARY){
			if(Window.confirm("このユーザーを登録しますか?") == false){
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
			AddStorageInfoEntityAsync.AddHRDBasicUserInfoEntity(null, txtbox_lastname.getText(), txtbox_firstname.getText(), getCmbbox_Section(), getCmbbox_Authority(),
					txtbox_loginid.getText(), HashUtilMD5.encryptMD5(txtbox_password.getText()), txtbox_Email.getText(), getCheckbox_Enabled(), registerDate, updateDate, "", "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							Window.alert("登録しました。");
							image_minispin.setVisible(false);
							dataGrid.setVisibleRangeAndClearData(dataGrid.getVisibleRange(), true);
						}
			});
		}else if(btn_register.getType() == ButtonType.SUCCESS){
			if(Window.confirm("このユーザーを更新しますか?") == false){
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
			AddStorageInfoEntityAsync.AddHRDBasicUserInfoEntity(id, txtbox_lastname.getText(), txtbox_firstname.getText(), getCmbbox_Section(), getCmbbox_Authority(),
					txtbox_loginid.getText(), txtbox_password.getText(), txtbox_Email.getText(), getCheckbox_Enabled(), registerDate, updateDate, "", "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							Window.alert("更新しました。");
							image_minispin.setVisible(false);
							dataGrid.setVisibleRangeAndClearData(dataGrid.getVisibleRange(), true);
						}
			});
		}else if(btn_register.getType() == ButtonType.DANGER){
			if(Window.confirm("このユーザーを削除しますか?") == false){
				return;
			}
			if(Window.confirm("削除するとデータは復元できません\n本当に削除してもよろしいですか?") == false){
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
			AddStorageInfoEntityAsync.AddHRDBasicUserInfoEntity(id, txtbox_lastname.getText(), txtbox_firstname.getText(), getCmbbox_Section(), getCmbbox_Authority(),
					txtbox_loginid.getText(), HashUtilMD5.encryptMD5(txtbox_password.getText()), txtbox_Email.getText(), getCheckbox_Enabled(), registerDate, updateDate, "Delete@" + registerDate + username, "", new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage() + this.getClass());
						}
						public void onSuccess(Object result) {
							Window.alert("削除しました。");
							image_minispin.setVisible(false);
							setFormPartsClear();
							dataGrid.setVisibleRangeAndClearData(dataGrid.getVisibleRange(), true);
						}
			});
		}
	}
	private void setTabIndex(){
		txtbox_lastname.setTabIndex(1);
		txtbox_firstname.setTabIndex(2);
		cmbbox_Section.setTabIndex(3);
		cmbbox_Authority.setTabIndex(4);
		txtbox_loginid.setTabIndex(5);
		txtbox_password.setTabIndex(6);
		txtbox_Email.setTabIndex(7);
		checkbox_Enabled.setTabIndex(8);
		btn_register.setTabIndex(9);
	}

	@UiHandler("navLink_surveyresult")
	void onNavLink_surveyresultClick(ClickEvent event) {

	}
}
