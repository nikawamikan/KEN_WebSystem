package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.IdealException;
import model.Menu;
import model.Reserve;

/**
 * メニュー削除画面へ遷移するクラスです。<br>
 * 削除ができるかを判定して削除できる場合を実行します。<br>
 * Servlet implementation class MenuDeleteSvl
 */
@WebServlet("/controller/MenuDeleteSvl")
public class MenuDeleteSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuDeleteSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(UTF8);
		response.setContentType(CONTENT_TYPE);
		RequestDispatcher rd = null;

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(adminVar.adminInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		int typeID = Integer.parseInt(request.getParameter(menuVar.typeID));
		int menuID = Integer.parseInt(request.getParameter(menuVar.menuID));

		try {
			if (typeID == 100) {
				// 予約されているコースかを確認 Reserveクラスのメソッド利用
				// IdealExceptionエラーが起きたらcatchで処理
				Reserve.reservCourseChk(menuID);
				// コース構成分類ごとのメニュー一覧を取得、設定

				// t_idが100以外のt_idを取得し、リクエストオブジェクトに設定
				Course oneCourse = Course.getOneCourse(menuID);
				request.setAttribute(menuVar.oneCourse, oneCourse);

				// 上記２つをcourseDelete.jspに送る
				rd = request.getRequestDispatcher(jspName.courseDelete);
			} else {
				// コースに設定されているメニューかを確認 courseクラスのメソッド利用
				// IdealExceptionエラーが起きたらcatchで処理
				// ?
				// MenuクラスのgetOneMenuメソッドから、引数menuID、typeIDの「メニュー詳細」を取得 リクエストオブジェクトに設定
				Menu oneMenu = Menu.getOneMenu(menuID, typeID);
				request.setAttribute(menuVar.oneMenu, oneMenu);
				rd = request.getRequestDispatcher(jspName.menuDelete);
			}
			// サーブレットが持っていたサーブレットリクエストとサーブレットレスポンスを 引き継いでもらう
			rd.forward(request, response);
		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			rd = request.getRequestDispatcher(svlNames.MenuMaintenanceSvl);
			rd.forward(request, response);
		}
	}

}
