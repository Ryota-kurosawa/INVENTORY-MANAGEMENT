package com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric;

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
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
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
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;

public class UiBGeneralUserFabricListView extends Composite implements HasText {

	private static UiBGeneralUserFabricListViewUiBinder uiBinder = GWT.create(UiBGeneralUserFabricListViewUiBinder.class);
	@UiField(provided=true) DataGrid<SerializeHRDFabricInfoEntity> dataGrid = new DataGrid<SerializeHRDFabricInfoEntity>(100, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField HTMLPanel datagrid;
	@UiField Nav navRight;
	@UiField NavLink navLink_Username;
	@UiField Nav Nav;
	@UiField ResponsiveNavbar responsiveNavBar;
	@UiField NavLink navLink_Stockfabric;
	@UiField NavLink navLink_refresh;

	interface UiBGeneralUserFabricListViewUiBinder extends
			UiBinder<Widget, UiBGeneralUserFabricListView> {
	}

	private final FetchHRDFabricInfoEntityServiceAsync FetchFabricInfoAsync = GWT.create(FetchHRDFabricInfoEntityService.class);
	AsyncDataProvider<SerializeHRDFabricInfoEntity> provider = new AsyncDataProvider<SerializeHRDFabricInfoEntity>() {
		@Override
		protected void onRangeChanged(HasData<SerializeHRDFabricInfoEntity> display) {
			//sort用
			final ColumnSortList sortList = dataGrid.getColumnSortList();
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
		dataGrid.setMinimumTableWidth(90, Unit.EM);
		dataGrid.setWidth("100%");
		dataGrid.setHeight("100%");

		/**
		 * checkbox Column
		 */
		Column<SerializeHRDFabricInfoEntity, Boolean> checkColumn = new Column<SerializeHRDFabricInfoEntity, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(SerializeHRDFabricInfoEntity object) {
				return selectionModel.isSelected(object);
			}
		};
		dataGrid.addColumn(checkColumn, "");
		dataGrid.setColumnWidth(checkColumn, 00.3, Unit.EM);
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
			 *ControlNumber(int) Text Column Sort対象項目
			 */
			final TextColumn<SerializeHRDFabricInfoEntity> ControlNumberColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
				@Override
				public String getValue(SerializeHRDFabricInfoEntity object) {
					String ControlNumber = String.valueOf(object.getControlNumber());
						return ControlNumber;
					}
				};
				dataGrid.addColumn(ControlNumberColumn, "幕No.");
				dataGrid.setColumnWidth(ControlNumberColumn, 00.3, Unit.EM);
				dataGrid.addColumnSortHandler(sortHandler);
				dataGrid.getColumnSortList().push(ControlNumberColumn);

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
					dataGrid.addColumn(ImageUrl01Column, "画像1");
					dataGrid.setColumnWidth(ImageUrl01Column,0.4, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(ImageUrl01Column);


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
						dataGrid.addColumn(ImageUrl02Column, "画像2");
						dataGrid.setColumnWidth(ImageUrl02Column,0.4, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						dataGrid.getColumnSortList().push(ImageUrl02Column);

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
							dataGrid.addColumn(ImageUrl03Column, "画像3");
							dataGrid.setColumnWidth(ImageUrl03Column,0.4, Unit.EM);
//							dataGrid.addColumnSortHandler(sortHandler);
							dataGrid.getColumnSortList().push(ImageUrl03Column);

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
								dataGrid.addColumn(ImageUrl04Column, "画像4");
								dataGrid.setColumnWidth(ImageUrl04Column,0.4, Unit.EM);
//								dataGrid.addColumnSortHandler(sortHandler);
								dataGrid.getColumnSortList().push(ImageUrl04Column);

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
					dataGrid.addColumn(MaterialColumn, "材質");
					dataGrid.setColumnWidth(MaterialColumn, 00.8, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(MaterialColumn);

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
					dataGrid.addColumn(SizeColumn, "サイズ");
					dataGrid.setColumnWidth(SizeColumn, 00.8, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					dataGrid.getColumnSortList().push(SizeColumn);

					/**
					*UseProperties(String) Text Column
					*/
					final TextColumn<SerializeHRDFabricInfoEntity> UsePropertiesColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
						@Override
						public String getValue(SerializeHRDFabricInfoEntity object) {
							String useproperties = object.getReserveArea01_String();
								return useproperties;
							}
						};
						dataGrid.addColumn(UsePropertiesColumn, "営業/使用物件");
						dataGrid.setColumnWidth(UsePropertiesColumn, 0.8, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						dataGrid.getColumnSortList().push(UsePropertiesColumn);

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
						dataGrid.addColumn(RemarksColumn, "備考");
						dataGrid.setColumnWidth(RemarksColumn, 3.0, Unit.EM);
//						dataGrid.addColumnSortHandler(sortHandler);
						dataGrid.getColumnSortList().push(RemarksColumn);
	}

	public UiBGeneralUserFabricListView() {
		initWidget(uiBinder.createAndBindUi(this));
		provider.addDataDisplay(dataGrid);
		final MultiSelectionModel<SerializeHRDFabricInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDFabricInfoEntity>();
		dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDFabricInfoEntity>createCheckboxManager());
		dataGrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		//sort用
		AsyncHandler columnSortHandler = new AsyncHandler(dataGrid);
		dataGrid.addColumnSortHandler(columnSortHandler);
		initTableColumns(selectionModel, columnSortHandler);

		//NavBarにユーザーメニュー(ドロップダウン)追加
//        com.github.gwtbootstrap.client.ui.Dropdown dropdown_logout = new com.github.gwtbootstrap.client.ui.Dropdown();
//        dropdown_logout.setIcon(IconType.USER);
//        dropdown_logout.setText("ゲスト");
		 //データリフレッシュ
//        NavLink navLink_DataRefresh = new NavLink();
        navLink_refresh.setIcon(IconType.REFRESH);
        navLink_refresh.setText("最新データ取得");
        navLink_refresh.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
					dataGrid.setVisibleRangeAndClearData(dataGrid.getVisibleRange(), true);
			}
		});
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
//        dropdown_logout.add(navLink_Username);
//        navRight.add(dropdown_logout);
        //データリフレッシュ
//        navLink_DataRefresh.setIcon(IconType.REFRESH);
//        navLink_DataRefresh.setText("最新データ取得");
//        navLink_DataRefresh.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//					dataGrid.setVisibleRangeAndClearData(dataGrid.getVisibleRange(), true);
//			}
//		});
//        dropdown_logout.add(navLink_DataRefresh);
//        navRight.add(dropdown_logout);
	}

	public UiBGeneralUserFabricListView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

}
