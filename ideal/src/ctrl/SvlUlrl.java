package ctrl;

import general.ComminPath;

public interface SvlUlrl{

	/** アドミンログイン処理 */
	final static String AdminLoginSvl = ComminPath.svlUrl("AdminLoginSvl");
	/** アドミンログオフ処理 */
	final static String AdminLogoffSvl = ComminPath.svlUrl("AdminLogoffSvl");

	/** メニューメンテナンス画面表示処理 */
	final static String MenuMaintenanceSvl = ComminPath.svlUrl("MenuMaintenanceSvl");
	/** メニュー登録画面表示処理 */
	final static String MenuInsertSvl = ComminPath.svlUrl("MenuInsertSvl");
	/** メニュー変更画面表示処理 */
	final static String MenuUpdateSvl = ComminPath.svlUrl("MenuUpdateSvl");
	/** メニュー削除画面表示処理 */
	final static String MenuDeleteSvl = ComminPath.svlUrl("MenuDeleteSvl") ;
	/** メニュー更新処理 */
	final static String MenuOperationSvl = ComminPath.svlUrl("MenuOperationSvl");
	/** コース更新処理 */
	final static String CourseOperationSvl = ComminPath.svlUrl("CourseOperationSvl") ;
	/** メニュー紹介画面表示処理 */
	final static String ShowMenuSvl = ComminPath.svlUrl("ShowMenuSvl");

	/** 予約一覧表示処理 */
	final static String ReserveListSvl =ComminPath.svlUrl("ReserveListSvl") ;
	/** 予約登録画面表示処理 */
	final static String ReserveInsertSvl = ComminPath.svlUrl("ReserveInsertSvl");
	/** 予約変更画面表示処理 */
	final static String ReserveUpdateSvl = ComminPath.svlUrl("ReserveUpdateSvl");
	/** 予約削除画面表示処理 */
	final static String ReserveDeleteSvl = ComminPath.svlUrl("ReserveDeleteSvl");
	/** 予約情報更新処理 */
	final static String ReserveOperationSvl = ComminPath.svlUrl("ReserveOperationSvl");

	/** 顧客ログイン処理 */
	final static String UserLoginSvl = ComminPath.svlUrl("UserLoginSvl");
	/** 顧客ログオフ処理 */
	final static String UserLogoffSvl = ComminPath.svlUrl("UserLogoffSvl");
	/** 顧客情報変更画面表示処理 */
	final static String UserUpdateSvl = ComminPath.svlUrl("UserUpdateSvl");
	/** 顧客情報削除画面表示処理 */
	final static String UserDeleteSvl = ComminPath.svlUrl("UserDeleteSvl");
	/** 顧客情報更新処理 */
	final static String UserOperationSvl = ComminPath.svlUrl("UserOperationSvl");

}
