package controller;

import general.StringToIntCast;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IdealException;
import model.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * メールアドレスの判定を行うサーブレット。正規表現をチェックした後、データベースに接続し、重複したメールアドレスがないかをチェックします。<br>
 * その際DataをJSON形式でresponseします。<br>
 *
 * @param test 登録できる場合Trueを格納します。
 * @param message メールアドレスが登録可能かの文字列を格納しています。
 *
 *
 * Servlet implementation class MailadressCheckSvl
 */
@WebServlet("/controller/MailadressCheckSvl")
public class MailadressCheckSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailadressCheckSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(UTF8);
		response.setContentType("text/plain;charset=utf-8");
		int usrId = StringToIntCast.castInt(request, "usrId");
		String mail = request.getParameter("mail");
		JSONObject json = new JSONObject();
		final String MAIL_P = "^[\\w]+((\\.[\\w-_])*[\\w-_]*)*@[\\w]+((\\.[\\w-_])*[\\w-_]*)*[\\w]+$";
		Pattern p = Pattern.compile(MAIL_P);
		Matcher matcher = p.matcher(mail);
		try {
			if (matcher.find()) {

				json.put("test", User.checkmail(mail,usrId));

			} else {
				json.put("message", "メールアドレスの形式が正しくありません。");
				json.put("test", false);
			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (IdealException e) {
			try {
				json.put("message", e.getMsg());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
