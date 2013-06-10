package com.krsw.InventoryManagement.shared;

import java.util.ArrayList;
import java.util.List;

import com.github.gwtbootstrap.client.ui.ListBox;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 *
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 *
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}

	/**
	 * スクリーン設定(横幅)
	 */
	static int width;
	public static void setScreenWidth(int ScreenWidth){
		width = ScreenWidth * (int)0.9;
	}
	/**
	 * スクリーン設定(縦)
	 */
	static int height;
	public static void setScreenHeight(int ScreenHeight){
		height = ScreenHeight * (int)0.7;
	}
	/**
	 * 有効・無効設定
	 * @return
	 */
	public static List<String> getBoolSelection(){
		List<String> options = new ArrayList<String>();
		options.add("有効");
		options.add("無効");
		return options;
	}
	/**
	 * 部門名称設定
	 * @param cmbbox_Section
	 */
	public static void createSectionBox(ListBox cmbbox_Section){
		cmbbox_Section.addItem("--- ここから部門を選択してください ---");
		cmbbox_Section.addItem("602-");
		cmbbox_Section.addItem("605-");
		cmbbox_Section.addItem("801-");
		cmbbox_Section.addItem("821-");
		cmbbox_Section.addItem("788-");
		cmbbox_Section.addItem("803-");
		cmbbox_Section.addItem("872-");
		cmbbox_Section.addItem("603-");
		cmbbox_Section.addItem("604-");
		cmbbox_Section.addItem("611-");
		cmbbox_Section.addItem("651-");
		cmbbox_Section.addItem("632-");
		cmbbox_Section.addItem("661-");
		cmbbox_Section.addItem("635-");
		cmbbox_Section.addItem("802-");
		cmbbox_Section.addItem("811-");
		cmbbox_Section.addItem("633-");
		cmbbox_Section.addItem("634-");
		cmbbox_Section.addItem("642-");
		cmbbox_Section.addItem("643-");
		cmbbox_Section.addItem("644-");
		cmbbox_Section.addItem("645-");
		cmbbox_Section.addItem("646-");
		cmbbox_Section.addItem("751-");
		cmbbox_Section.addItem("871-");
		cmbbox_Section.addItem("782-");
		cmbbox_Section.addItem("783-");
		cmbbox_Section.addItem("784-");
		cmbbox_Section.addItem("785-");
		cmbbox_Section.addItem("786-");
		cmbbox_Section.addItem("787-");
		cmbbox_Section.addItem("781-");
		cmbbox_Section.addItem("790-");
		cmbbox_Section.addItem("752-");
		cmbbox_Section.addItem("761-");
		cmbbox_Section.addItem("883-");
		cmbbox_Section.addItem("774-");
		cmbbox_Section.addItem("773-");
		cmbbox_Section.addItem("621-");
		cmbbox_Section.addItem("93-");
		cmbbox_Section.addItem("94-");
		cmbbox_Section.addItem("999-その他");
	}
	/**
	 * 権限設定
	 * @param cmbbox_Authority
	 */
	public static void createAuthBox(ListBox cmbbox_Authority){
		cmbbox_Authority.addItem("管理者");
		cmbbox_Authority.addItem("一般");
	}

	/**
	 * 部門名称設定
	 * @param cmbbox_Section
	 */
	public static void createStorageLocationBox(ListBox cmbbox_StorageLocation){
		cmbbox_StorageLocation.addItem("");
		cmbbox_StorageLocation.addItem("");
		cmbbox_StorageLocation.addItem("");
		cmbbox_StorageLocation.addItem("");
		cmbbox_StorageLocation.addItem("");
	}

	//アンケートモードの投票完了お知らせ先メールアドレス
	public static String sendAddress1st;
	/**
	 * アンケートモードの投票完了お知らせ先メールアドレス設定
	 * @param address
	 */
	public static void setSendAddress1st(String address){
		sendAddress1st= address;
	}
	/**
	 * アンケートモードの投票完了お知らせ先メールアドレス取得
	 * @return
	 */
	public static String getSendAddress1st(){
		return sendAddress1st;
	}

	//アンケートモードの投票完了お知らせ先メールアドレス
	public static String sendAddress2nd;
	/**
	 * アンケートモードの投票完了お知らせ先メールアドレス設定
	 * @param address
	 */
	public static void setSendAddress2nd(String address){
		sendAddress2nd= address;
	}
	/**
	 * アンケートモードの投票完了お知らせ先メールアドレス取得
	 * @return
	 */
	public static String getSendAddress2nd(){
		return sendAddress2nd;
	}

}
