package general;

/**
 * nullを空文字列に変換する jspのtextarea等で使用
 * @author 伊東
 *
 */
public class FormReplacer {
	/**
	 * nullを空文字列に変換する jspのtextarea等で使用
	 * @param getMethod 引数：nullになる可能性がある文字列、メソッド(ゲッターなど)
	 * @return 引数がnullなら空白文字列を返す
	 */
	public static String fmtNull(String getMethod){
		if(getMethod==null || getMethod.equals("")){
		getMethod="";
		}
		getMethod.replace("<br/>", System.lineSeparator().replace("<", "&lt;").replace(">", "gt;"));
		return getMethod;
		}
	/**
	 * `チェックされる番号かを検証し、検証の結果チェックされる場合はcheckedを返す。
	 * @param num
	 * @return
	 */
	public static String checkeder(int num,int base){

		if(num==base){
			return "checked";
		}
		return "";
	}
}
