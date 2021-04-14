package ctrl;

import general.ComminPath;

public interface SvlName {

	/** アドミンログイン処理 */
	final static String AdminLoginSvl = ComminPath.svlPath("AdminLoginSvl");
	/** アドミンログオフ処理 */
	final static String AdminLogoffSvl = ComminPath.svlPath("AdminLogoffSvl");

	/** メニューメンテナンス画面表示処理 */
	final static String MenuMaintenanceSvl = ComminPath.svlPath("MenuMaintenanceSvl");
	/** メニュー登録画面表示処理 */
	final static String MenuInsertSvl = ComminPath.svlPath("MenuInsertSvl");
	/** メニュー変更画面表示処理 */
	final static String MenuUpdateSvl = ComminPath.svlPath("MenuUpdateSvl");
	/** メニュー削除画面表示処理 */
	final static String MenuDeleteSvl = ComminPath.svlPath("MenuDeleteSvl") ;
	/** メニュー更新処理 */
	final static String MenuOperationSvl = ComminPath.svlPath("MenuOperationSvl");
	/** コース更新処理 */
	final static String CourseOperationSvl = ComminPath.svlPath("CourseOperationSvl") ;
	/** メニュー紹介画面表示処理 */
	final static String ShowMenuSvl = ComminPath.svlPath("ShowMenuSvl");

	/** 予約一覧表示処理 */
	final static String ReserveListSvl =ComminPath.svlPath("ReserveListSvl") ;
	/** 予約登録画面表示処理 */
	final static String ReserveInsertSvl = ComminPath.svlPath("ReserveInsertSvl");
	/** 予約変更画面表示処理 */
	final static String ReserveUpdateSvl = ComminPath.svlPath("ReserveUpdateSvl");
	/** 予約削除画面表示処理 */
	final static String ReserveDeleteSvl = ComminPath.svlPath("ReserveDeleteSvl");
	/** 予約情報更新処理 */
	final static String ReserveOperationSvl = ComminPath.svlPath("ReserveOperationSvl");

	/** 顧客ログイン処理 */
	final static String UserLoginSvl = ComminPath.svlPath("UserLoginSvl");
	/** 顧客ログオフ処理 */
	final static String UserLogoffSvl = ComminPath.svlPath("UserLogoffSvl");
	/** 顧客情報変更画面表示処理 */
	final static String UserUpdateSvl = ComminPath.svlPath("UserUpdateSvl");
	/** 顧客情報削除画面表示処理 */
	final static String UserDeleteSvl = ComminPath.svlPath("UserDeleteSvl");
	/** 顧客情報更新処理 */
	final static String UserOperationSvl = ComminPath.svlPath("UserOperationSvl");

}