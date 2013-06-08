package com.krsw.InventoryManagement.client.UiBinder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionModel;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.client.UiBinder.Location.UiBLocationInfoEdit;
import com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric.UiBFabricInfo;
import com.krsw.InventoryManagement.shared.ButtonImageCell;

public class UiBVotedFabricList extends Composite implements HasText {

	private static UiBVotedFabricListUiBinder uiBinder = GWT.create(UiBVotedFabricListUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField(provided=true) DataGrid<SerializeHRDFabricInfoEntity> datagrid = new DataGrid<SerializeHRDFabricInfoEntity>(100, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField ResponsiveNavbar responsivenavBar;
	@UiField Nav nav;
	@UiField NavLink navLink_stockfabric;
	@UiField NavLink navlink_Dept;
	@UiField NavLink navlink_User;
	@UiField NavLink navLink_surveyresult;
	@UiField Nav navright;
	@UiField LayoutPanel layoutpanel;
	@UiField NavLink navLink_username;
	Long id = null;
	String username = "";
	String auth = "";
	String StatusLabelString = "一般ユーザービューモード設定";

	interface UiBVotedFabricListUiBinder extends UiBinder<Widget, UiBVotedFabricList> {
	}
	private final FetchHRDFabricInfoEntityServiceAsync FetchFabricInfoAsync = GWT.create(FetchHRDFabricInfoEntityService.class);
	AsyncDataProvider<SerializeHRDFabricInfoEntity> provider = new AsyncDataProvider<SerializeHRDFabricInfoEntity>() {
		@Override
		protected void onRangeChanged(HasData<SerializeHRDFabricInfoEntity> display) {
			//sort用
			final ColumnSortList sortList = datagrid.getColumnSortList();
			final Range range = display.getVisibleRange();
			final int start = range.getStart();
			final int end = start + range.getLength();
			int length = display.getVisibleRange().getLength();
			AsyncCallback<List<SerializeHRDFabricInfoEntity>> callback = new AsyncCallback<List<SerializeHRDFabricInfoEntity>>() {
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
				public void onSuccess(List<SerializeHRDFabricInfoEntity> result) {
					if(result.size() >= 100){
						Collections.sort(result, new Comparator<SerializeHRDFabricInfoEntity>() {
							public int compare(SerializeHRDFabricInfoEntity o1,SerializeHRDFabricInfoEntity o2) {
								if(o1 == o2){
									return 0;
								}
								int diff = -1;
								if (o1 != null) {
					                  diff = (o2 != null) ? Long.valueOf(o1.getControlNumber()).compareTo(Long.valueOf(o2.getControlNumber())) : 1;
					                }
					                return sortList.get(0).isAscending() ? diff : -diff;
					              }
						});
						updateRowData(start, result.subList(start, end));
						updateRowCount(result.size(), true);
//						pager.setDisplay(datagrid);
					}else{
						Collections.sort(result, new Comparator<SerializeHRDFabricInfoEntity>() {
							public int compare(SerializeHRDFabricInfoEntity o1,SerializeHRDFabricInfoEntity o2) {
								if(o1 == o2){
									return 0;
								}
								int diff = -1;
								if (o1 != null) {
					                  diff = (o2 != null) ? Long.valueOf(o1.getControlNumber()).compareTo(Long.valueOf(o2.getControlNumber())) : 1;
					                }
					                return sortList.get(0).isAscending() ? diff : -diff;
					              }
						});
						updateRowData(start, result);
						}
					}
			};
			FetchFabricInfoAsync.getAvailabilityRange("", callback);
		}
	};

	//項目設定
	public void initTableColumns(final SelectionModel<SerializeHRDFabricInfoEntity> selectionModel, AsyncHandler sortHandler){
		datagrid.setMinimumTableWidth(90, Unit.EM);
		datagrid.setWidth("100%");
		datagrid.setHeight("100%");

		/**
		 * checkbox Column
		 */
		Column<SerializeHRDFabricInfoEntity, Boolean> checkColumn = new Column<SerializeHRDFabricInfoEntity, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(SerializeHRDFabricInfoEntity object) {
				return selectionModel.isSelected(object);
			}
		};
		datagrid.addColumn(checkColumn, "選択");
		datagrid.setColumnWidth(checkColumn, 00.4, Unit.EM);
		checkColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		/**
		 *id Text Column 非表示項目
		 */
		final TextColumn<SerializeHRDFabricInfoEntity> IdColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
			@Override
			public String getValue(SerializeHRDFabricInfoEntity object) {
				String id = Long.toString(object.getId());
					return id;
				}
			};
//			datagrid.addColumn(IdColumn, "ID");
//			datagrid.setColumnWidth(IdColumn, 00.6, Unit.EM);
////			dataGrid.addColumnSortHandler(sortHandler);
//			datagrid.getColumnSortList().push(IdColumn);

			/**
			 *ControlNumber(int) Text Column
			 */
			final TextColumn<SerializeHRDFabricInfoEntity> ControlNumberColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
				@Override
				public String getValue(SerializeHRDFabricInfoEntity object) {
					String ControlNumber = String.valueOf(object.getControlNumber());
						return ControlNumber;
					}
				};
				datagrid.addColumn(ControlNumberColumn, "幕No.");
				datagrid.setColumnWidth(ControlNumberColumn, 00.4, Unit.EM);
				datagrid.addColumnSortHandler(sortHandler);
				datagrid.getColumnSortList().push(ControlNumberColumn);
				/**
				*imageUrl01(String) Column
				*/
				final Column<SerializeHRDFabricInfoEntity, String>ImageUrl01Column = new Column<SerializeHRDFabricInfoEntity, String>(new ButtonImageCell()) {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						Image image = new Image(object.getImageUrl01() + "=s80");
						if(object.getImageUrl01() == "No Image"){
							return "/img/NoImage_3232.png";
							}
							return image.getUrl();
						}
					};
					ImageUrl01Column.setFieldUpdater(new FieldUpdater<SerializeHRDFabricInfoEntity, String>() {
						public void update(int index,SerializeHRDFabricInfoEntity object,String value) {

							Image image = new Image(object.getImageUrl01());
							image.setUrl(object.getImageUrl01().toString() + "=s800");
							final PopupPanel imagePopup = new PopupPanel(true);
							imagePopup.setWidget(image);
							imagePopup.setAnimationEnabled(true);
						    imagePopup.setGlassEnabled(true);
						    imagePopup.setAutoHideEnabled(true);
						    image.addLoadHandler(new LoadHandler() {
								public void onLoad(LoadEvent event) {
									imagePopup.center();
								}
							});
						    imagePopup.center();
						}
					});
					datagrid.addColumn(ImageUrl01Column, "画像1");
					datagrid.setColumnWidth(ImageUrl01Column,0.4, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(ImageUrl01Column);


					/**
					*imageUrl02(String) Column
					*/
					final Column<SerializeHRDFabricInfoEntity, String>ImageUrl02Column = new Column<SerializeHRDFabricInfoEntity, String>(new ButtonImageCell()) {
						@Override
						public String getValue(SerializeHRDFabricInfoEntity object) {
							Image image = new Image(object.getImageUrl02() + "=s80");
							if(object.getImageUrl02() == "No Image"){
								return "/img/NoImage_3232.png";
								}
								return image.getUrl();
							}
						};
						ImageUrl02Column.setFieldUpdater(new FieldUpdater<SerializeHRDFabricInfoEntity, String>() {
							public void update(int index,SerializeHRDFabricInfoEntity object,String value) {

								Image image = new Image(object.getImageUrl02());
								image.setUrl(object.getImageUrl02().toString() + "=s800");
								final PopupPanel imagePopup = new PopupPanel(true);
								imagePopup.setWidget(image);
								imagePopup.setAnimationEnabled(true);
							    imagePopup.setGlassEnabled(true);
							    imagePopup.setAutoHideEnabled(true);
							    image.addLoadHandler(new LoadHandler() {
									public void onLoad(LoadEvent event) {
										imagePopup.center();
									}
								});
							    imagePopup.center();
							}
						});
						datagrid.addColumn(ImageUrl02Column, "画像2");
						datagrid.setColumnWidth(ImageUrl02Column,0.4, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						datagrid.getColumnSortList().push(ImageUrl02Column);

						/**
						*imageUrl03(String) Column
						*/
						final Column<SerializeHRDFabricInfoEntity, String>ImageUrl03Column = new Column<SerializeHRDFabricInfoEntity, String>(new ButtonImageCell()) {
							@Override
							public String getValue(SerializeHRDFabricInfoEntity object) {
								Image image = new Image(object.getImageUrl03() + "=s80");
								if(object.getImageUrl03() == "No Image"){
									return "/img/NoImage_3232.png";
									}
									return image.getUrl();
								}
							};
							ImageUrl03Column.setFieldUpdater(new FieldUpdater<SerializeHRDFabricInfoEntity, String>() {
								public void update(int index,SerializeHRDFabricInfoEntity object,String value) {

									Image image = new Image(object.getImageUrl03());
									image.setUrl(object.getImageUrl03().toString() + "=s800");
									final PopupPanel imagePopup = new PopupPanel(true);
									imagePopup.setWidget(image);
									imagePopup.setAnimationEnabled(true);
								    imagePopup.setGlassEnabled(true);
								    imagePopup.setAutoHideEnabled(true);
								    image.addLoadHandler(new LoadHandler() {
										public void onLoad(LoadEvent event) {
											imagePopup.center();
										}
									});
								    imagePopup.center();
								}
							});
							datagrid.addColumn(ImageUrl03Column, "画像3");
							datagrid.setColumnWidth(ImageUrl03Column,0.4, Unit.EM);
//							dataGrid.addColumnSortHandler(sortHandler);
							datagrid.getColumnSortList().push(ImageUrl03Column);

							/**
							*imageUrl04(String) Column
							*/
							final Column<SerializeHRDFabricInfoEntity, String>ImageUrl04Column = new Column<SerializeHRDFabricInfoEntity, String>(new ButtonImageCell()) {
								@Override
								public String getValue(SerializeHRDFabricInfoEntity object) {
									Image image = new Image(object.getImageUrl04() + "=s80");
									if(object.getImageUrl04() == "No Image"){
										return "/img/NoImage_3232.png";
										}
										return image.getUrl();
									}
								};
								ImageUrl04Column.setFieldUpdater(new FieldUpdater<SerializeHRDFabricInfoEntity, String>() {
									public void update(int index,SerializeHRDFabricInfoEntity object,String value) {

										Image image = new Image(object.getImageUrl04());
										image.setUrl(object.getImageUrl04().toString() + "=s800");
										final PopupPanel imagePopup = new PopupPanel(true);
										imagePopup.setWidget(image);
										imagePopup.setAnimationEnabled(true);
									    imagePopup.setGlassEnabled(true);
									    imagePopup.setAutoHideEnabled(true);
									    image.addLoadHandler(new LoadHandler() {
											public void onLoad(LoadEvent event) {
												imagePopup.center();
											}
										});
									    imagePopup.center();
									}
								});
								datagrid.addColumn(ImageUrl04Column, "画像4");
								datagrid.setColumnWidth(ImageUrl04Column,0.4, Unit.EM);
//								dataGrid.addColumnSortHandler(sortHandler);
								datagrid.getColumnSortList().push(ImageUrl04Column);
				/**
				 *Material(String) Text Column
				 */
				final TextColumn<SerializeHRDFabricInfoEntity> MaterialColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						String material = object.getMaterial();
							return material;
						}
					};
					datagrid.addColumn(MaterialColumn, "材質");
					datagrid.setColumnWidth(MaterialColumn, 01.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(MaterialColumn);

				/**
				 *Size(String) Text Column
				 */
				final TextColumn<SerializeHRDFabricInfoEntity> SizeColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						String size = object.getSize();
							return size;
						}
					};
					datagrid.addColumn(SizeColumn, "サイズ");
					datagrid.setColumnWidth(SizeColumn, 01.5, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(SizeColumn);
				/**
				*Remarks(String) Text Column
				*/
				final TextColumn<SerializeHRDFabricInfoEntity> RemarksColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						String remarks = object.getRemarks();
							return remarks;
						}
					};
					datagrid.addColumn(RemarksColumn, "備考");
					datagrid.setColumnWidth(RemarksColumn, 3.0, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(RemarksColumn);

					/**
					*VotersLocation(String) Text Column
				 */
				final TextColumn<SerializeHRDFabricInfoEntity> VotersColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						String voters = object.getReserveArea02_String();
						if(voters == ""){
							return "";
						}else{
							return voters;
						}

						}
					};

					datagrid.addColumn(VotersColumn, "投票者");
					datagrid.setColumnWidth(VotersColumn, 02.5, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(VotersColumn);

					/**
					* UseProperties(String) Text Column
					*/
					final TextColumn<SerializeHRDFabricInfoEntity> UsePropertiesColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
						@Override
						public String getValue(SerializeHRDFabricInfoEntity object) {
							String useproperties = object.getReserveArea01_String();
								return useproperties;
							}
						};
						datagrid.addColumn(UsePropertiesColumn, "営業/使用物件");
						datagrid.setColumnWidth(UsePropertiesColumn, 1.0, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						datagrid.getColumnSortList().push(UsePropertiesColumn);

	}

	public UiBVotedFabricList(final String LoginUserName, final String Authority) {
		initWidget(uiBinder.createAndBindUi(this));
		username = LoginUserName;
		auth = Authority;
		provider.addDataDisplay(datagrid);
		final MultiSelectionModel<SerializeHRDFabricInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDFabricInfoEntity>();
		datagrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDFabricInfoEntity>createCheckboxManager());
		datagrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		//sort用
		AsyncHandler columnSortHandler = new AsyncHandler(datagrid);
		datagrid.addColumnSortHandler(columnSortHandler);
		initTableColumns(selectionModel, columnSortHandler);
		//Navbar設定
		responsivenavBar.add(nav);
		responsivenavBar.add(navright);
		//NavBarに設定メニュー(ドロップダウン)追加
		com.github.gwtbootstrap.client.ui.Dropdown dropdown_setting = new com.github.gwtbootstrap.client.ui.Dropdown();
		dropdown_setting.setIcon(IconType.GROUP);
		dropdown_setting.setText("ユーザー");
		navlink_User.setIcon(IconType.COG);
		navlink_User.setText("ユーザー設定");
		navlink_User.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	            	RootLayoutPanel.get().remove(0);
	            	UiBBasicUserInfoView userview = new UiBBasicUserInfoView(LoginUserName, Authority);
	            	RootLayoutPanel.get().add(userview);
	                History.newItem("UserList:");
	            }
	        });
	        dropdown_setting.add(navlink_User);
	        nav.add(dropdown_setting);

		//NavBarに拠点メニュー(ドロップダウン)追加
        com.github.gwtbootstrap.client.ui.Dropdown dropdown_location = new com.github.gwtbootstrap.client.ui.Dropdown();
        navlink_Dept.setIcon(IconType.BUILDING);
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
//        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
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
        dropdown_survey.add(navLink_surveyresult02);
        dropdown_survey.add(navLink_surveyresult);
        nav.add(dropdown_survey);

      //NavBarにユーザーメニュー(ドロップダウン)追加
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
					modal.setPixelSize(480, 280);
					modal.add(UserMode);
					modal.show();
				}
			});
	        dropdown_logout.add(navLink_ViewMode);
	        navright.add(dropdown_logout);
	}

	public UiBVotedFabricList(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

}
