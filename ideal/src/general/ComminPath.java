package general;

import java.nio.file.Paths;

public class ComminPath {

	/** core */
	final static private String getPathCore(String first, String... more) {
		return Paths.get(first, more).toString();
	}

	/** 同一のファイル階層のディレクトリを参照 */
	final static public String getPath(String... more) {
		return getPathCore(".", more);
	}

	/**
	 * 一つ上のファイル階層のディレクトリを参照する,<br>
	 * 同クラス内のUPを第二引数以降に追加すると何回層でも登れる
	 *
	 * @deprecated
	 */

	final static public String upPath(String... more) {
		return getPathCore(UP, more);
	}

	/**
	 * サーブレットの名前からサーブレットで使用するパスを取得します。
	 *
	 * @param svlName サーブレットの名前
	 * @return サーブレットで仕様する形式のパス
	 */
	final static public String svlPath(String svlName) {
		return  svlName;
	}

	/**
	 * サーブレットの名前からJSPで使う絶対パスいを取得します。
	 *
	 * @param svlName サーブレットの名前
	 * @return サーブレットの絶対パス文字列
	 */
	final static public String svlUrl(String svlName) {
		return "/ideal/controller/" + svlName;
	}

	/** ファイル階層を一つ上に登る */

	final static public String UP = "";
	final static public String img = "img";
	final static public String css = "css";
	final static public String js = "js";
}
