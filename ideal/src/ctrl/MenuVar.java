package ctrl;

public interface MenuVar {

	//reqestオブジェクトからAttributeを使用してやり取りする際に使用。

	/** Menuオブジェクトの受け渡し時に使用 */
	final static String menu = "menu";
	/**
	 *  Menuオブジェクトを格納したArrayListを受け渡しする。<br>
	 * 主にメニューメンテナンスのサーブレットで使用し、<br>
	 * メニュータイプのボタンを表示する等に使用。
	 *
	 */
	final static String typeMenuList = "typeMenuList";
	/**
	 * メニューの詳細のオブジェクトを受け渡す際に使用。<br>
	 * MenuクラスのgetOneMenuクラスから取得したものを主に使用する。
	 */
	final static String oneMenu = "oneMenu";

	/**
	 * コースの詳細のオブジェクトを受け渡す際に使用。
	 */
	final static String oneCourse = "oneCourse";

	final static String courseList = "courseList";
	final static String menuList = "menuList";
	final static String typeName = "typeName";



	//jspからformを使用して受け渡す際に使用

	/** TypeIDを受け渡し時に使用
	 */
	final static String typeID = "typeID";
	/** menuIDを受け渡し時に使用 */
	final static String menuID = "menuID";
	/** メニューの名前を受け渡し時使用 */
	final static String menuName = "menuName";
	/** コースIDを受け渡す際に使用 */
	final static String courseID = "courseID";
	/** コースの名前を受け渡す際に使用 */
	final static String courseName = "courseName";
	/** メニュー及びコースの値段を受け渡す際に使用。 */
	final static String price = "price";
	/** メニューのオーダーフラグを受け渡す際に使用。 */
	final static String orderFlg = "orderFlg";
	/** メニュー及びコースの概要を受け渡す際に使用 */
	final static String detail = "detail";
	/** コースの前菜IDを受け渡す際に使用 */
	final static String appetizerID = "appetizerID";
	/** コースのスープIDを受け渡す際に使用 */
	final static String soupID = "soupID";
	/** コースのパスタIDを受け渡す際に使用 */
	final static String pastaID = "pastaID";
	/** コースの肉料理IDを受け渡す際に使用 */
	final static String meatID = "meatID";
	/** コースの魚料理IDを受け渡す際に使用 */
	final static String fishID = "fishID";
	/** コースのデザートIDを受け渡す際に使用 */
	final static String dessertID = "dessertID";
	/** modeを受け渡す際に使用する(削除など） */
	final static String mode = "mode";
}
