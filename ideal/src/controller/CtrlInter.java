package controller;

import general.ComminPath;
import ctrl.AdminVar;
import ctrl.CourseVar;
import ctrl.JspName;
import ctrl.LoginVar;
import ctrl.MenuVar;
import ctrl.ReserveVar;
import ctrl.SvlName;


/**
 * Controllerクラス群で使用するinterface<br>
 * jspでインナークラス内の定数を参照する事ができないので別途のinterfaceを整備しています。
 * @author Kamishiro
 *
 */
public interface CtrlInter {

	/** 文字コードの定数 */
	String UTF8 = "UTF-8";
	/** コンテンツタイプの定数 */
	String CONTENT_TYPE = "text/html; charset=utf-8";

	/** Exceptionクラスからの送信受け取り用 */
	String msg = "msg";

	/** サーブレットのクラス名を格納するクラス。 */
	static class svlNames implements SvlName {
	}

	/** JSPのアドレスを格納したクラス */
	static class jspName implements JspName {

	}

	/** userLogin系サーブレットで使用する変数名を格納するクラス */
	static class loginVar implements LoginVar {
	}

	/** Admin系サーブレットで使用する変数名を格納するクラス */
	static class adminVar implements AdminVar {
	}

	/** Menu系サーブレットで使用する変数名を格納するクラス */
	static class menuVar implements MenuVar{
	}

	// メニューと統合する予定。
	static class courseVar implements CourseVar{
	}

	/** Reserve系サーブレッドで使用する変数名を格納するクラス */
	static class reserveVar implements ReserveVar{
	}

	/** path形成用のクラス */
	static class path extends ComminPath{
	}
}
