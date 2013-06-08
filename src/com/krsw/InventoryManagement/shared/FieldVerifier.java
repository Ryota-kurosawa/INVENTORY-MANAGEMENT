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
		cmbbox_Section.addItem("602-舞台営業部/東京ドーム営業課");
		cmbbox_Section.addItem("605-舞台営業部/営業三課");
		cmbbox_Section.addItem("801-サイン・テキスタイル部(営業)");
		cmbbox_Section.addItem("821-生産管理部");
		cmbbox_Section.addItem("788-千葉スタジオ/出力");
		cmbbox_Section.addItem("803-サイン・テキスタイル部");
		cmbbox_Section.addItem("872-大阪支店/生産");
		cmbbox_Section.addItem("603-舞台営業部/営業一課");
		cmbbox_Section.addItem("604-舞台営業部/営業二課");
		cmbbox_Section.addItem("611-メディア営業部");
		cmbbox_Section.addItem("651-東京国際フォーラム営業部");
		cmbbox_Section.addItem("632-スポーツ・コンベンション営業部/スポーツ一課");
		cmbbox_Section.addItem("661-プロデュース部/プロデュース課");
		cmbbox_Section.addItem("635-スポーツ・コンベンション営業部/多摩営業所");
		cmbbox_Section.addItem("802-サイン・テキスタイル部(生産)");
		cmbbox_Section.addItem("811-レンタル事業部");
		cmbbox_Section.addItem("633-スポーツ・コンベンション営業部/スポーツ二課");
		cmbbox_Section.addItem("634-スポーツ・コンベンション営業部/コンベンション一課");
		cmbbox_Section.addItem("642-EVスペース開発部/営業第一課");
		cmbbox_Section.addItem("643-EVスペース開発部/営業第二課");
		cmbbox_Section.addItem("644-EVスペース開発部/海外事業課");
		cmbbox_Section.addItem("645-EVスペース開発部/美術制作課");
		cmbbox_Section.addItem("646-EVスペース開発部/デザイン課");
		cmbbox_Section.addItem("751-技術部/安全指導課");
		cmbbox_Section.addItem("871-大阪支店/制作部");
		cmbbox_Section.addItem("782-千葉スタジオ/機構");
		cmbbox_Section.addItem("783-千葉営業/オクトホール");
		cmbbox_Section.addItem("784-千葉スタジオ/物流");
		cmbbox_Section.addItem("785-千葉スタジオ/資材・SSR");
		cmbbox_Section.addItem("786-千葉スタジオ/美工");
		cmbbox_Section.addItem("787-千葉スタジオ/製作");
		cmbbox_Section.addItem("781-千葉スタジオ/管理課");
		cmbbox_Section.addItem("790-かずさアカデミーパーク");
		cmbbox_Section.addItem("752-技術部/技術課");
		cmbbox_Section.addItem("761-デザイン部");
		cmbbox_Section.addItem("883-東北復興支援プロジェクト");
		cmbbox_Section.addItem("774-美術制作部/美術制作課");
		cmbbox_Section.addItem("773-美術制作部/リギング");
		cmbbox_Section.addItem("621-ビジュアル部");
		cmbbox_Section.addItem("93-横浜シミズ/営業");
		cmbbox_Section.addItem("94-西日本シミズ");
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
		cmbbox_StorageLocation.addItem("千葉スタジオ");
		cmbbox_StorageLocation.addItem("下落合スタジオ");
		cmbbox_StorageLocation.addItem("日通倉庫");
		cmbbox_StorageLocation.addItem("木更津倉庫");
		cmbbox_StorageLocation.addItem("金田倉庫");
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
