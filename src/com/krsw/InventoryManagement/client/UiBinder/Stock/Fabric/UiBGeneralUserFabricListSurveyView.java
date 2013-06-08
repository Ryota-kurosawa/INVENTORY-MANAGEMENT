package com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric;

import java.util.ArrayList;
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
import com.google.gwt.user.client.ui.Widget;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionModel;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.shared.ButtonImageCell;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.constants.IconType;

public class UiBGeneralUserFabricListSurveyView extends Composite implements
		HasText {

	private static UiBGeneralUserFabricListSurveyViewUiBinder uiBinder = GWT.create(UiBGeneralUserFabricListSurveyViewUiBinder.class);
	@UiField(provided=true) DataGrid<SerializeHRDFabricInfoEntity> datagrid = new DataGrid<SerializeHRDFabricInfoEntity>(100, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField ResponsiveNavbar ResponsiveNavBar;
	@UiField HTMLPanel htmlpanel;
	@UiField NavLink navLink_stockfabric;
	@UiField NavLink navLink_usersetting;
	@UiField Nav nav;
	@UiField Nav navright;
	@UiField NavLink navLink_username;
	@UiField NavLink navLink_refresh;
	List<Integer> controlNumberList = new ArrayList<Integer>();

	interface UiBGeneralUserFabricListSurveyViewUiBinder extends
			UiBinder<Widget, UiBGeneralUserFabricListSurveyView> {
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
//						pager.setDisplay(dataGrid);
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
			FetchFabricInfoAsync.getAvailabilityRange2("", callback);
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
		datagrid.addColumn(checkColumn, "");
		datagrid.setColumnWidth(checkColumn, 00.3, Unit.EM);
		checkColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		checkColumn.setFieldUpdater(new FieldUpdater<SerializeHRDFabricInfoEntity, Boolean>() {
			public void update(int index, SerializeHRDFabricInfoEntity object, Boolean value) {
				if(object.getReserveArea01_Boolean() == true){
					object.setReserveArea01_Boolean(false);
					int i = 0;
					for (; i <= controlNumberList.size();){
						if(object.getControlNumber() == controlNumberList.get(i)){
							controlNumberList.remove(i);
						}
						i++;
					}
				}else{
					object.setReserveArea01_Boolean(true);
					controlNumberList.add(object.getControlNumber());
				}
			}
		});



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
////			datagrid.addColumnSortHandler(sortHandler);
//			datagrid.getColumnSortList().push(IdColumn);

			/**
			 *ControlNumber(int) Text Column Sort対象項目
			 */
			final TextColumn<SerializeHRDFabricInfoEntity> ControlNumberColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
				@Override
				public String getValue(SerializeHRDFabricInfoEntity object) {
					String ControlNumber = String.valueOf(object.getControlNumber());
						return ControlNumber;
					}
				};
				datagrid.addColumn(ControlNumberColumn, "幕No.");
				datagrid.setColumnWidth(ControlNumberColumn, 00.5, Unit.EM);
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
//					datagrid.addColumnSortHandler(sortHandler);
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
//						datagrid.addColumnSortHandler(sortHandler);
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
//							datagrid.addColumnSortHandler(sortHandler);
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
//								datagrid.addColumnSortHandler(sortHandler);
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
//					datagrid.addColumnSortHandler(sortHandler);
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
					datagrid.setColumnWidth(SizeColumn, 00.8, Unit.EM);
//					datagrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(SizeColumn);

					/**
					*UseProperty(String) Text Column
					*/
					final TextColumn<SerializeHRDFabricInfoEntity> UsePropertyColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
						@Override
						public String getValue(SerializeHRDFabricInfoEntity object) {
							String useproperty = object.getReserveArea01_String();
								return useproperty;
							}
						};
						datagrid.addColumn(UsePropertyColumn, "営業/使用物件");
						datagrid.setColumnWidth(UsePropertyColumn, 0.8, Unit.EM);
//						datagrid.addColumnSortHandler(sortHandler);
						datagrid.getColumnSortList().push(UsePropertyColumn);

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
//					datagrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(RemarksColumn);
	}

	public UiBGeneralUserFabricListSurveyView() {
		initWidget(uiBinder.createAndBindUi(this));
		UiBSurveyDescription description = new UiBSurveyDescription();
		description.setPixelSize(600, 340);
		final Modal modal = new Modal(true);
		modal.setPixelSize(640, 390);
		modal.add(description);
		modal.show();
		provider.addDataDisplay(datagrid);
		final MultiSelectionModel<SerializeHRDFabricInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDFabricInfoEntity>();
		datagrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDFabricInfoEntity>createCheckboxManager());
		datagrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		//sort用
		AsyncHandler columnSortHandler = new AsyncHandler(datagrid);
		datagrid.addColumnSortHandler(columnSortHandler);
		initTableColumns(selectionModel, columnSortHandler);

//		//NavBarにユーザーメニュー(ドロップダウン)追加
//        com.github.gwtbootstrap.client.ui.Dropdown dropdown_logout = new com.github.gwtbootstrap.client.ui.Dropdown();
//        dropdown_logout.setIcon(IconType.USER);
//        NavLink navLink_DataRefresh = new NavLink();
//        navLink_DataRefresh.setIcon(IconType.REFRESH);
//        dropdown_logout.setText("ゲスト");
//        navLink_username.setText("ログアウト");
//        navLink_username.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//            	if(Window.confirm("ログアウトしますか?") == true){
//            		History.newItem("");
//            		Window.Location.reload();
//            	}else{
//            		return;
//            	}
//            }
//        });
//        dropdown_logout.add(navLink_username);
//        navright.add(dropdown_logout);
//        //データリフレッシュ
//        navLink_DataRefresh.setText("最新データ取得");
//        navLink_DataRefresh.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//					datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
//			}
//		});
//        dropdown_logout.add(navLink_DataRefresh);
//        navright.add(dropdown_logout);
		navLink_refresh.setIcon(IconType.REFRESH);
        navLink_refresh.setText("最新データ取得");
        navLink_refresh.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
					datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
			}
		});
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
	}

	public UiBGeneralUserFabricListSurveyView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	@UiHandler("navLink_usersetting")
	void onNavLink_usersettingClick(ClickEvent event) {
//		Window.alert(controlNumberList.size() + "件選択");
		UiBModalSurveySubmit surveysubmit = new UiBModalSurveySubmit(controlNumberList);
		surveysubmit.setPixelSize(300, 270);
		final Modal modal = new Modal(true);
		modal.setPixelSize(480, 320);
		modal.add(surveysubmit);
		modal.show();
	}
	@UiHandler("navLink_stockfabric")
	void onNavLink_stockfabricClick(ClickEvent event) {
		UiBSurveyDescription description = new UiBSurveyDescription();
		description.setPixelSize(600, 340);
		final Modal modal = new Modal(true);
		modal.setPixelSize(640, 390);
		modal.add(description);
		modal.show();
	}
}
