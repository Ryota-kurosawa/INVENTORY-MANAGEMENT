package com.krsw.InventoryManagement.client.UiBinder.Stock.Fabric;

import java.util.ArrayList;
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
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.AsyncHandler;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import com.github.gwtbootstrap.client.ui.Well;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.github.gwtbootstrap.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionModel;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.krsw.InventoryManagement.client.BLOB.Stock.Fabric.FabricImageService;
import com.krsw.InventoryManagement.client.BLOB.Stock.Fabric.FabricImageServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Location.FetchHRDLocationInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Location.FetchHRDLocationInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Location.SerializeHRDLocationInfoEntity;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.AddHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityService;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.FetchHRDFabricInfoEntityServiceAsync;
import com.krsw.InventoryManagement.client.HRD.Stock.Fabric.SerializeHRDFabricInfoEntity;
import com.krsw.InventoryManagement.client.UiBinder.UiBBasicUserInfoView;
import com.krsw.InventoryManagement.client.UiBinder.UiBGeneralUserModeView;
import com.krsw.InventoryManagement.client.UiBinder.UiBModalDeleteVoteData;
import com.krsw.InventoryManagement.client.UiBinder.UiBSurveyVotersList;
import com.krsw.InventoryManagement.client.UiBinder.UiBVotedColumnChart;
import com.krsw.InventoryManagement.client.UiBinder.UiBVotedFabricList;
import com.krsw.InventoryManagement.client.UiBinder.Location.UiBLocationInfoEdit;
import com.krsw.InventoryManagement.shared.ButtonImageCell;
import com.krsw.InventoryManagement.shared.FieldVerifier;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.ResponsiveNavbar;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.ButtonGroup;
import com.google.gwt.event.dom.client.KeyPressEvent;

public class UiBFabricInfo extends Composite implements HasText {

	private static UiBFabricInfoUiBinder uiBinder = GWT.create(UiBFabricInfoUiBinder.class);
	@UiField HTMLPanel htmlpanel;
	@UiField LayoutPanel layoutPanel;
	@UiField Well well;
	@UiField TextBox txtbox_material;
	@UiField TextBox txtbox_size;
	@UiField ListBox cmbbox_storagelocation;
	@UiField IntegerBox intbox_storagenumber;
	@UiField VerticalPanel verticalPanel;
	@UiField FormPanel uploadformPanel;
	@UiField FileUpload uploadField;
	@UiField Image image_uploadminispin;
	@UiField Image image_Minispin;
	@UiField(provided=true) DataGrid<SerializeHRDFabricInfoEntity> datagrid = new DataGrid<SerializeHRDFabricInfoEntity>(100, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));
	@UiField NavLink navlink_dept;
	@UiField NavLink navlink_Surveyresult;
	@UiField NavLink navLink_Usersetting;
	@UiField NavLink navLink_Username;
	@UiField ResponsiveNavbar responsiveNavBar;
	@UiField Nav navRight;
	@UiField Nav Nav;
	@UiField CheckBox checkbox_enabled;
	@UiField com.github.gwtbootstrap.client.ui.Button uploadFileButton;
	@UiField TextArea txtAria_remarks;
	@UiField NavLink navLink_Stockfabric;
	@UiField ButtonGroup btnroup_uploadimage;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_uploadimage1;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_uploadimage2;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_uploadimage3;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_uploadimage4;
	@UiField com.github.gwtbootstrap.client.ui.Button btn_Register;
	@UiField Image image_Current01;
	@UiField Image image_Current02;
	@UiField Image image_Current03;
	@UiField Image image_Current04;
	@UiField TextArea txtAria_UseProperties;
	String BlobURL = "";
	String registerDate = null;
	String updateDate = null;
	Long id = null;
	String imgurl1;
	String imgurl2;
	String imgurl3;
	String imgurl4;
	String UPregistdate;
	String username = "";
	String auth = "";
	String StatusLabelString = "一般ユーザービューモード設定";

	String reserveString01 = "";
	String reserveString02 = "";
	String reserveString03 = "";
	String reserveString04 = "";
	Boolean reserveBoolean01 = false;
	Boolean reserveBoolean02 = false;
	Boolean reserveBoolean03 = false;

	interface UiBFabricInfoUiBinder extends UiBinder<Widget, UiBFabricInfo> {
	}
	FabricImageServiceAsync goodsimageservice = GWT.create(FabricImageService.class);
	private final FetchHRDLocationInfoEntityServiceAsync FetchLocationAsync = GWT.create(FetchHRDLocationInfoEntityService.class);
	private final AddHRDFabricInfoEntityServiceAsync AddStorageInfoAsync = GWT.create(AddHRDFabricInfoEntityService.class);
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
		 * Button Column
		 */
		ButtonCell updateButton = new ButtonCell(IconType.PENCIL, ButtonType.SUCCESS, ButtonSize.SMALL);
		Column<SerializeHRDFabricInfoEntity, String> ButtonColumn = new Column<SerializeHRDFabricInfoEntity, String>(updateButton) {
			@Override
			public String getValue(SerializeHRDFabricInfoEntity object) {
				return "編集";
			}
		};
		ButtonColumn.setFieldUpdater(new FieldUpdater<SerializeHRDFabricInfoEntity, String>() {
			public void update(int index, SerializeHRDFabricInfoEntity object,String value) {
				id = object.getId();
				setIntbox_storagenumber(object.getControlNumber());
				setTxtbox_material(object.getMaterial());
				setTxtbox_size(object.getSize());
				setCmbbox_storagelocation(object.getStorageLocation());
				setCheckbox_enabled(object.getEnabled());
				setTxtAria_remarks(object.getRemarks());
				setTxtAria_UseProperties(object.getReserveArea01_String());
				imgurl1 = object.getImageUrl01();
				imgurl2 = object.getImageUrl02();
				imgurl3 = object.getImageUrl03();
				imgurl4 = object.getImageUrl04();
				UPregistdate = object.getCreateDate();
				btn_Register.setText("更新");
				btn_Register.setType(ButtonType.SUCCESS);
				btn_Register.setIcon(IconType.PENCIL);
				btn_uploadimage1.setActive(false);
				btn_uploadimage2.setActive(false);
				btn_uploadimage3.setActive(false);
				btn_uploadimage4.setActive(false);
				reserveString01 = object.getReserveArea01_String();
				reserveString02 = object.getReserveArea02_String();
				reserveString03 = object.getReserveArea03_String();
				reserveString04 = object.getReserveArea04_String();
				reserveBoolean01 = object.getReserveArea02_Boolean();
				reserveBoolean02 = object.getReserveArea02_Boolean();
				reserveBoolean03 = object.getReserveArea03_Boolean();
				if(object.getImageUrl01().equals("No Image")){
					image_Current01.setUrl("/img/NoImage_3232.png");
				}else{
					image_Current01.setUrl(imgurl1 + "=s50");
				}
				if(object.getImageUrl02().equals("No Image")){
					image_Current02.setUrl("/img/NoImage_3232.png");
				}else{
					image_Current02.setUrl(imgurl2 + "=s50");
				}
				if(object.getImageUrl03().equals("No Image")){
					image_Current03.setUrl("/img/NoImage_3232.png");
				}else{
					image_Current03.setUrl(imgurl3 + "=s50");
				}
				if(object.getImageUrl04().equals("No Image")){
					image_Current04.setUrl("/img/NoImage_3232.png");
				}else{
					image_Current04.setUrl(imgurl4 + "=s50");
				}

			}
		});
		datagrid.addColumn(ButtonColumn, "編集");
		datagrid.setColumnWidth(ButtonColumn, 00.7, Unit.EM);
//		ButtonColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

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
					datagrid.setColumnWidth(MaterialColumn, 01.4, Unit.EM);
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
					*StorageLocation(String) Text Column
				 */
				final TextColumn<SerializeHRDFabricInfoEntity> StorageLocationColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						String storagelocation = object.getStorageLocation();
							return storagelocation;
						}
					};
					datagrid.addColumn(StorageLocationColumn, "保管場所");
					datagrid.setColumnWidth(StorageLocationColumn, 00.9, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(StorageLocationColumn);

				/**
				*Enabled(Boolean→String) Text Column
				 */
				final TextColumn<SerializeHRDFabricInfoEntity> EnabledColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
					@Override
					public String getValue(SerializeHRDFabricInfoEntity object) {
						if(object.getEnabled() == true){
								return "有効";
							}else{
								return "無効";
							}
						}
					};
					datagrid.addColumn(EnabledColumn, "有効/無効");
					datagrid.setColumnWidth(EnabledColumn, 0.7, Unit.EM);
//					dataGrid.addColumnSortHandler(sortHandler);
					datagrid.getColumnSortList().push(EnabledColumn);

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

//				/**
//				*CreateDate(String) Text Column
//				*/
//				final TextColumn<SerializeHRDFabricInfoEntity> CreateDateColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
//					@Override
//					public String getValue(SerializeHRDFabricInfoEntity object) {
//						String createdate = object.getCreateDate();
//							return createdate;
//						}
//					};
//					datagrid.addColumn(CreateDateColumn, "登録日時");
//					datagrid.setColumnWidth(CreateDateColumn, 01.0, Unit.EM);
////					dataGrid.addColumnSortHandler(sortHandler);
//					datagrid.getColumnSortList().push(CreateDateColumn);
//
//				/**
//				*UpdateDate(String) Text Column
//				*/
//				final TextColumn<SerializeHRDFabricInfoEntity> UpdateDateColumn = new TextColumn<SerializeHRDFabricInfoEntity>() {
//					@Override
//					public String getValue(SerializeHRDFabricInfoEntity object) {
//						String updatedate = object.getUpdateDate();
//							return updatedate;
//						}
//					};
//					datagrid.addColumn(UpdateDateColumn, "更新日時");
//					datagrid.setColumnWidth(UpdateDateColumn, 01.0, Unit.EM);
////					dataGrid.addColumnSortHandler(sortHandler);
//					datagrid.getColumnSortList().push(UpdateDateColumn);

	}

	public UiBFabricInfo(final String LoginUserName, final String Authority) {
		initWidget(uiBinder.createAndBindUi(this));
		username = LoginUserName;
		auth = Authority;
		setTabIndex();
		final AsyncCallback<List<SerializeHRDLocationInfoEntity>> callback = new AsyncCallback<List<SerializeHRDLocationInfoEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getLocalizedMessage() + this.getClass());
			}
			public void onSuccess(List<SerializeHRDLocationInfoEntity> result) {
				List<String> options = new ArrayList<String>();
				cmbbox_storagelocation.clear();
				options.clear();
				for(SerializeHRDLocationInfoEntity serial : result){
					options.add(serial.getNumber() + "." + serial.getName());
					Collections.sort(options);
				}
				for (int i = 0; i <= options.size(); i++) {
					cmbbox_storagelocation.addItem(options.get(i));
				}
			}
		};
		FetchLocationAsync.getAvailabilityRange("", callback);

		image_Minispin.setVisible(false);
		image_uploadminispin.setVisible(false);
		if(Authority.equals("管理者")){
			provider.addDataDisplay(datagrid);
			final MultiSelectionModel<SerializeHRDFabricInfoEntity> selectionModel = new MultiSelectionModel<SerializeHRDFabricInfoEntity>();
			datagrid.setSelectionModel(selectionModel, DefaultSelectionEventManager.<SerializeHRDFabricInfoEntity>createCheckboxManager());
			datagrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
			//sort用
			AsyncHandler columnSortHandler = new AsyncHandler(datagrid);
			datagrid.addColumnSortHandler(columnSortHandler);
			initTableColumns(selectionModel, columnSortHandler);
//			setFormPartsDisabled();
		}
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

//	      //アンケート状況設定
//	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_survey = new com.github.gwtbootstrap.client.ui.Dropdown();
//	        dropdown_survey.setIcon(IconType.COMMENTS);
//	        dropdown_survey.setText("アンケート");
//	        navlink_Surveyresult.setIcon(IconType.GROUP);
//	        navlink_Surveyresult.setText("アンケート:投票者状況");
//	        navlink_Surveyresult.addClickHandler(new ClickHandler() {
//	            public void onClick(ClickEvent event) {
//	            	RootLayoutPanel.get().remove(0);
//	        		//管理者がログインした場合は最初にユーザーアカウント一覧を表示する。
////	        		BrowserRoot_UserBasicInfoView.setSize("100%", "100%");
//	        		UiBSurveyVotersList votelist = new UiBSurveyVotersList(LoginUserName, Authority);
//	        		RootLayoutPanel.get().add(votelist);
//	                History.newItem("Voters:");
//	            }
//	        });
//	        dropdown_survey.add(navlink_Surveyresult);
//	        Nav.add(dropdown_survey);

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

//	      //在庫幕設定
//	        com.github.gwtbootstrap.client.ui.Dropdown dropdown_fabric = new com.github.gwtbootstrap.client.ui.Dropdown();
//	        dropdown_fabric.setText("在庫");
//	        navLink_Stockfabric.setText("在庫幕設定");
//	        navLink_Stockfabric.addClickHandler(new ClickHandler() {
//	            public void onClick(ClickEvent event) {
//	            	RootLayoutPanel.get().remove(0);
//	        		//管理者がログインした場合は最初にユーザーアカウント一覧を表示する。
//	        		UiBFabricInfo fabricview = new UiBFabricInfo(username,auth);
//	        		RootLayoutPanel.get().add(fabricview);
//	                History.newItem("FabricSetting;");
//	            }
//	        });
//	        dropdown_fabric.add(navLink_Stockfabric);
//	        Nav.add(dropdown_fabric);



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

//	        FieldVerifier.createStorageLocationBox(cmbbox_storagelocation);
			//blobstore uploading setting
			//URLにPOSTすることになるまでボタンを無効にする。
//			UploadFileButton.setPixelSize(230, 32);
			uploadFileButton.setText("Loading...");
			uploadformPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
			uploadformPanel.setMethod(FormPanel.METHOD_POST);
			image_uploadminispin.setVisible(false);
			uploadFileButton.setEnabled(false);
			uploadField.setName("image");
			//GWT-RPCを使用してURLを取得する
			startNewBlobstoreSession();
			uploadformPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
				public void onSubmitComplete(SubmitCompleteEvent event) {
					uploadformPanel.reset();
					startNewBlobstoreSession();
					//アップロードファイル表示
					String imageUrl = event.getResults();
					Image image = new Image();
					image.setUrl(imageUrl);
					final PopupPanel imagePopup = new PopupPanel(true);
					    imagePopup.setWidget(image);
					    imagePopup.setAnimationEnabled(true);
					    imagePopup.setGlassEnabled(true);
					    imagePopup.setAutoHideEnabled(true);
					    imagePopup.center();
					    image_uploadminispin.setVisible(false);
					  //DataStore登録用BlobURLをセット
//					    FieldVerifier.setImageUrlString(imageUrl);
					    BlobURL = imageUrl;
				}
			});
	}

	public UiBFabricInfo(){
		initWidget(uiBinder.createAndBindUi(this));
		setTabIndex();
		final AsyncCallback<List<SerializeHRDLocationInfoEntity>> callback = new AsyncCallback<List<SerializeHRDLocationInfoEntity>>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getLocalizedMessage() + this.getClass());
			}
			public void onSuccess(List<SerializeHRDLocationInfoEntity> result) {
				List<String> options = new ArrayList<String>();
				cmbbox_storagelocation.clear();
				options.clear();
				for(SerializeHRDLocationInfoEntity serial : result){
					options.add(serial.getNumber() + "." + serial.getName());
					Collections.sort(options);
				}
				for (int i = 0; i <= options.size(); i++) {
					cmbbox_storagelocation.addItem(options.get(i));
				}
				cmbbox_storagelocation.addItem("----- 保管場所を選択してください -----");
			}
		};
		FetchLocationAsync.getRange(0, 0, callback);
//		FieldVerifier.createStorageLocationBox(cmbbox_storagelocation);
		//blobstore uploading setting
		//URLにPOSTすることになるまでボタンを無効にする。
//		UploadFileButton.setPixelSize(230, 32);
		uploadFileButton.setText("Loading...");
		uploadformPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		uploadformPanel.setMethod(FormPanel.METHOD_POST);
		image_uploadminispin.setVisible(false);
		uploadFileButton.setEnabled(false);
		uploadField.setName("image");
		//GWT-RPCを使用してURLを取得する
		startNewBlobstoreSession();
		uploadformPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			public void onSubmitComplete(SubmitCompleteEvent event) {
				uploadformPanel.reset();
				startNewBlobstoreSession();
				//アップロードファイル表示
				String imageUrl = event.getResults();
				Image image = new Image();
				image.setUrl(imageUrl);
				final PopupPanel imagePopup = new PopupPanel(true);
				    imagePopup.setWidget(image);
				    imagePopup.setAnimationEnabled(true);
				    imagePopup.setGlassEnabled(true);
				    imagePopup.setAutoHideEnabled(true);
				    imagePopup.center();
				    image_uploadminispin.setVisible(false);
				  //DataStore登録用BlobURLをセット
//				    FieldVerifier.setImageUrlString(imageUrl);
				    BlobURL = imageUrl;
			}
		});
	}

	public UiBFabricInfo(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public void setText(String text) {
	}

	public String getText() {
		return null;
	}

	private void startNewBlobstoreSession(){
		goodsimageservice.getBlobstoreUploadUrl(new AsyncCallback(){public void onFailure(Throwable caught) {
				Window.alert(caught.toString());
			}
			public void onSuccess(Object result) {
				uploadformPanel.setAction((String) result);
				uploadFileButton.setText("アップロード");
				uploadFileButton.setEnabled(true);
			}
		});
	}

	@UiHandler("uploadFileButton")
	void onUploadFileButtonClick(ClickEvent event) {
		if(uploadField.getFilename().equals("") || uploadField.getFilename().equals(null)){
			Window.alert("アップロードする画像ファイルを選択してください.");
			return;
		}
		if(btn_Register.getType() == ButtonType.SUCCESS){
			if(btn_uploadimage1.isToggled() == false && btn_uploadimage2.isToggled() == false && btn_uploadimage3.isToggled() == false && btn_uploadimage4.isToggled() == false){
				Window.alert("変更する画像番号を選択してください。");
				return;
			}
		}
		image_uploadminispin.setVisible(true);
		uploadformPanel.submit();
	}

	@UiHandler("btn_Register")
	void onBtn_RegisterClick(ClickEvent event) {
		if(intbox_storagenumber.getValue() == null){
			Window.alert("未入力項目があります。");
			return;
		}
		if(btn_Register.getType() == ButtonType.SUCCESS){
			if(Window.confirm("このデータを更新しますか?") == false){
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
//			String UrlString01 = FieldVerifier.getImageUrlString();
			if(btn_uploadimage1.isActive() == true){
				imgurl1 = BlobURL;
				if(imgurl1 == "" || imgurl1 == null){
					imgurl1 = "No Image";
				}
				AddStorageInfoAsync.AddFabricInfo(id, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
						getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), imgurl1, imgurl2,
						imgurl3, imgurl4, UPregistdate, updateDate, txtAria_UseProperties.getText(), reserveString02, reserveString03, reserveString04, reserveBoolean01, reserveBoolean02, reserveBoolean03, new AsyncCallback(){
							public void onFailure(Throwable caught) {
								Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
							}
							public void onSuccess(Object result) {
								image_Minispin.setVisible(false);
								Window.alert("更新しました");
								BlobURL = "";
								datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
							}
				});
			}else if(btn_uploadimage2.isActive() == true){
				imgurl2 = BlobURL;
				if(imgurl2 == "" || imgurl2 == null){
					imgurl2 = "No Image";
				}
				AddStorageInfoAsync.AddFabricInfo(id, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
						getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), imgurl1, imgurl2,
						imgurl3, imgurl4, UPregistdate, updateDate, txtAria_UseProperties.getText(), reserveString02, reserveString03, reserveString04, reserveBoolean01, reserveBoolean02, reserveBoolean03, new AsyncCallback(){
							public void onFailure(Throwable caught) {
								Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
							}
							public void onSuccess(Object result) {
								image_Minispin.setVisible(false);
								Window.alert("更新しました");
								BlobURL = "";
								datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
								return;
							}
				});
			}else if(btn_uploadimage3.isActive() == true){
				imgurl3 = BlobURL;
				if(imgurl3 == "" || imgurl3 == null){
					imgurl3 = "No Image";
				}
				AddStorageInfoAsync.AddFabricInfo(id, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
						getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), imgurl1, imgurl2,
						imgurl3, imgurl4, UPregistdate, updateDate, txtAria_UseProperties.getText(), reserveString02, reserveString03, reserveString04, reserveBoolean01, reserveBoolean02, reserveBoolean03, new AsyncCallback(){
							public void onFailure(Throwable caught) {
								Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
							}
							public void onSuccess(Object result) {
								image_Minispin.setVisible(false);
								Window.alert("更新しました");
								BlobURL = "";
								datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
								return;
							}
				});
			}else if(btn_uploadimage4.isActive() == true){
				imgurl4 = BlobURL;
				if(imgurl4 == "" || imgurl4 == null){
					imgurl4 = "No Image";
				}
				AddStorageInfoAsync.AddFabricInfo(id, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
						getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), imgurl1, imgurl2,
						imgurl3, imgurl4, UPregistdate, updateDate, txtAria_UseProperties.getText(), reserveString02, reserveString03, reserveString04, reserveBoolean01, reserveBoolean02, reserveBoolean03, new AsyncCallback(){
							public void onFailure(Throwable caught) {
								Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
							}
							public void onSuccess(Object result) {
								image_Minispin.setVisible(false);
								Window.alert("更新しました");
								BlobURL = "";
								datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
								return;
							}
				});
			}else{
				AddStorageInfoAsync.AddFabricInfo(id, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
						getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), imgurl1, imgurl2,
						imgurl3, imgurl4, UPregistdate, updateDate, txtAria_UseProperties.getText(), reserveString02, reserveString03, reserveString04, reserveBoolean01, reserveBoolean02, reserveBoolean03, new AsyncCallback(){
							public void onFailure(Throwable caught) {
								Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
							}
							public void onSuccess(Object result) {
								image_Minispin.setVisible(false);
								Window.alert("更新しました");
								datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
								return;
							}
				});
			}
		}else if(btn_Register.getType() == ButtonType.DANGER){
			if(Window.confirm("このデータを削除しますか?") == false){
				return;
			}
			if(Window.confirm("削除すると二度と復元できません。それでも削除しますか?") == false){
				return;
			}
			final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日");
			Calendar now = Calendar.getInstance();
			int h = now.get(now.HOUR_OF_DAY);
			int m = now.get(now.MINUTE);
			int s = now.get(now.SECOND);
			registerDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			updateDate = formati18.format(new Date()) + " " + h + "時" + m + "分" + s + "秒";
			AddStorageInfoAsync.AddFabricInfo(id, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
					getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), imgurl1, imgurl2,
					imgurl3, imgurl4, UPregistdate, updateDate, txtAria_UseProperties.getText(), "", "", "Delete@" + registerDate, false, false, false, new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("削除しました");
							BlobURL = "";
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
							return;
						}
			});
			return;
		}else if(btn_Register.getType() == ButtonType.PRIMARY){
			if(Window.confirm("このデータを登録しますか?") == false){
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
//		String UrlString01 = FieldVerifier.getImageUrlString();
		if(btn_uploadimage1.isToggled() == true){
			String UrlString01 = BlobURL;
			String UrlString02 = "No Image";
			String UrlString03 = "No Image";
			String UrlString04 = "No Image";
			Long id = null;
			if(UrlString01 == "" || UrlString01 == null){
				UrlString01 = "No Image";
			}
			AddStorageInfoAsync.AddFabricInfo(null, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
					getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), UrlString01, UrlString02,
					UrlString03, UrlString04, registerDate, updateDate, txtAria_UseProperties.getText(), "", "", "", false, false, false, new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("登録しました");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}
			});
		}else if(btn_uploadimage2.isToggled() == true){
			String UrlString01 = "No Image";
			String UrlString02 = BlobURL;
			String UrlString03 = "No Image";
			String UrlString04 = "No Image";
			Long id = null;
			if(UrlString02 == "" || UrlString02 == null){
				UrlString02 = "No Image";
			}
			AddStorageInfoAsync.AddFabricInfo(null, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
					getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), UrlString01, UrlString02,
					UrlString03, UrlString04, registerDate, updateDate, txtAria_UseProperties.getText(), "", "", "", false, false, false, new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("登録しました");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}
			});
		}else if(btn_uploadimage3.isToggled() == true){
			String UrlString01 = "No Image";
			String UrlString02 = "No Image";
			String UrlString03 = BlobURL;
			String UrlString04 = "No Image";
			Long id = null;
			if(UrlString03 == "" || UrlString03 == null){
				UrlString03 = "No Image";
			}
			AddStorageInfoAsync.AddFabricInfo(null, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
					getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), UrlString01, UrlString02,
					UrlString03, UrlString04, registerDate, updateDate, txtAria_UseProperties.getText(), "", "", "", false, false, false, new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("登録しました");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}
			});
		}else if(btn_uploadimage4.isToggled() == true){
			String UrlString01 = "No Image";
			String UrlString02 = "No Image";
			String UrlString03 = "No Image";
			String UrlString04 = BlobURL;
			Long id = null;
			if(UrlString04 == "" || UrlString04 == null){
				UrlString04 = "No Image";
			}
			AddStorageInfoAsync.AddFabricInfo(null, getIntbox_storagenumber(), getTxtbox_material(), getTxtbox_size(),
					getCmbbox_storagelocation(), getCheckbox_enabled(), getTxtAria_remarks(), UrlString01, UrlString02,
					UrlString03, UrlString04, registerDate, updateDate, txtAria_UseProperties.getText(), "", "", "", false, false, false, new AsyncCallback(){
						public void onFailure(Throwable caught) {
							Window.alert(caught.getLocalizedMessage() + this.getClass() + "AddStorageInfoAsync.AddFabricInfo()");
						}
						public void onSuccess(Object result) {
							image_Minispin.setVisible(false);
							Window.alert("登録しました");
							datagrid.setVisibleRangeAndClearData(datagrid.getVisibleRange(), true);
						}
			});
		}
	  }
	}

	public String getTxtbox_material() {
		return txtbox_material.getText();
	}

	public void setTxtbox_material(String txtbox_material) {
		this.txtbox_material.setText(txtbox_material);
	}

	public String getTxtbox_size() {
		return txtbox_size.getText();
	}

	public void setTxtbox_size(String txtbox_size) {
		this.txtbox_size.setText(txtbox_size);
	}

	public String getCmbbox_storagelocation() {
		return cmbbox_storagelocation.getValue(cmbbox_storagelocation.getSelectedIndex());
	}

	public void setCmbbox_storagelocation(String cmbbox_storagelocation) {
		this.cmbbox_storagelocation.setSelectedValue(cmbbox_storagelocation);
	}

	public Integer getIntbox_storagenumber() {
		return intbox_storagenumber.getValue();
	}

	public void setIntbox_storagenumber(Integer intbox_storagenumber) {
		this.intbox_storagenumber.setValue(intbox_storagenumber);
	}

	public Boolean getCheckbox_enabled() {
		return checkbox_enabled.getValue();
	}

	public void setCheckbox_enabled(Boolean checkbox_enabled) {
		this.checkbox_enabled.setValue(checkbox_enabled);
	}

	public String getTxtAria_remarks() {
		return txtAria_remarks.getText();
	}

	public void setTxtAria_remarks(String txtAria_remarks) {
		this.txtAria_remarks.setText(txtAria_remarks);
	}

	public String getTxtAria_UseProperties() {
		return txtAria_UseProperties.getText();
	}

	public void setTxtAria_UseProperties(String txtAria_UseProperties) {
		this.txtAria_UseProperties.setText(txtAria_UseProperties);
	}

	@UiHandler("intbox_storagenumber")
	void onIntbox_storagenumberKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtbox_material.setFocus(true);
         }
	}
	@UiHandler("txtbox_material")
	void onTxtbox_materialKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtbox_size.setFocus(true);
         }
	}
	@UiHandler("txtbox_size")
	void onTxtbox_sizeKeyPress(KeyPressEvent event) {

	}
	@UiHandler("cmbbox_storagelocation")
	void onCmbbox_storagelocationKeyPress(KeyPressEvent event) {
		if(((int)event.getCharCode()) == 13) {  // User hit "Enter" key
			txtAria_remarks.setFocus(true);
         }
	}


	@UiHandler("btn_radio_regist")
	void onBtn_radio_registClick(ClickEvent event) {
		btn_Register.setType(ButtonType.PRIMARY);
		btn_Register.setIcon(IconType.OK_SIGN);
		btn_Register.setText("登録");
	    setIntbox_storagenumber(null);
	    setTxtbox_material("");
	    setTxtbox_size("");
	    setCmbbox_storagelocation("千葉スタジオ");
	    setCheckbox_enabled(true);
	    setTxtAria_remarks("");
	    BlobURL = "";
	    intbox_storagenumber.setEnabled(true);
		txtbox_material.setEnabled(true);
		txtbox_size.setEnabled(true);
		cmbbox_storagelocation.setEnabled(true);
		checkbox_enabled.setEnabled(true);
		txtAria_remarks.setEnabled(true);
		uploadField.setEnabled(true);
		uploadFileButton.setEnabled(true);
		image_Current01.setUrl("/img/NoImage_3232.png");
		image_Current02.setUrl("/img/NoImage_3232.png");
		image_Current03.setUrl("/img/NoImage_3232.png");
		image_Current04.setUrl("/img/NoImage_3232.png");
	}
	@UiHandler("btn_radio_delete")
	void onBtn_radio_deleteClick(ClickEvent event) {
		btn_Register.setType(ButtonType.DANGER);
		btn_Register.setIcon(IconType.REMOVE_SIGN);
		btn_Register.setText("削除");
		intbox_storagenumber.setEnabled(false);
		txtbox_material.setEnabled(false);
		txtbox_size.setEnabled(false);
		cmbbox_storagelocation.setEnabled(false);
		checkbox_enabled.setEnabled(false);
		txtAria_remarks.setEnabled(false);
		uploadField.setEnabled(false);
		uploadFileButton.setEnabled(false);
	}

	private void setTabIndex(){
		intbox_storagenumber.setTabIndex(1);
		txtbox_material.setTabIndex(2);
		txtbox_size.setTabIndex(3);
		cmbbox_storagelocation.setTabIndex(4);
		checkbox_enabled.setTabIndex(5);
		txtAria_remarks.setTabIndex(6);
		txtAria_UseProperties.setTabIndex(7);
		uploadFileButton.setTabIndex(8);
		btn_Register.setTabIndex(9);
	}


}
