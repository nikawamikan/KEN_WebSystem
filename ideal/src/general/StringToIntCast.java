package general;

import javax.servlet.http.HttpServletRequest;

public class StringToIntCast {

	public static int castInt(HttpServletRequest request, String var) {
		return castInt(request, var, 0);
	}

	public static int castInt(HttpServletRequest request, String var, int reNum) {
		try {
			return Integer.parseInt(request.getParameter(var));
		} catch (NumberFormatException e) {
			// デバックメッセージ
//			System.out.println("StringToIntCastで数字以外をキャストしようとした可能性あり。(デバック)");
			return reNum;
		} catch (Exception e) {
			// デバックメッセージ
			System.out.println("StringToIntCastで何かしらのエラー(Exception総受け取り)");
			return reNum;
		}
	}
}
