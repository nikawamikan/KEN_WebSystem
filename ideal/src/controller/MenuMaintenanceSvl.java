package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.Menu;
import model.MenuType;
import ctrl.JspName;

/**
 * メニューメンテナンス画面へ遷移する時にメニュー情報をもったオブジェクトをリクエストにセットして遷移するサーブレットです<br>
 * Servlet implementation class MenuMaintenanceSvl
 */
@WebServlet("/controller/MenuMaintenanceSvl")
public class MenuMaintenanceSvl extends HttpServlet implements CtrlInter{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuMaintenanceSvl() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = null;

		int typeID;
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(adminVar.adminInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		/**
		 * リクエストパラメーター"typeID"を受け取る。 typeIDがnullなら100をセット
		 */
		try {
			typeID = Integer.parseInt(request.getParameter("typeID"));
		} catch (NumberFormatException e) {
			typeID = 100;
		}
		/**
		 * mTypeに分類一覧(ArrayList<MenuType>)をセット
		 */
		try {
			request.setAttribute("typeID", typeID);

			ArrayList<MenuType> mType = MenuType.getAllType();
			request.setAttribute("mType", mType);

			// menuにtypeIDに該当する分類毎メニュー一覧(ArrayList<Menu>)をセット。
			ArrayList<Menu> menu = Menu.getMenu(typeID);
			request.setAttribute("menu", menu);
			rd = request.getRequestDispatcher(JspName.menuMaintenance);

			rd.forward(request, response);

		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());
			rd = request.getRequestDispatcher(JspName.menuMaintenance);
			rd.forward(request, response);
		}

	}

}
