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

import model.Course;
import model.IdealException;
import model.Menu;
import model.MenuType;

/**
 * メニュー更新を行う画面へ遷移するためのサーブレットです。<br>
 * Servlet implementation class MenuUpdateSvl
 */
@WebServlet("/controller/MenuUpdateSvl")
public class MenuUpdateSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuUpdateSvl() {
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
		// クライアント側のフォームから送られてきた「typeIDデータ」をtypeIDにint型でセットする
		int typeID = Integer.parseInt(request.getParameter(menuVar.typeID));
		int menuID = Integer.parseInt(request.getParameter(menuVar.menuID));
		try {
			if (typeID == 100) {
				ArrayList<ArrayList<Menu>> typeMenuList = Menu.getAllMenu();
				request.setAttribute(menuVar.typeMenuList, typeMenuList);
				// 1件のデータしかないのでArrayListは使わない？仕様書では使うことになっている
				Course oneCourse = Course.getOneCourse(menuID);
				request.setAttribute(menuVar.oneCourse, oneCourse);
				rd = request.getRequestDispatcher(jspName.courseUpdate);
			} else {
				ArrayList<MenuType> mType = MenuType.getAllType();
				request.setAttribute("mType", mType);

				request.setAttribute("typeID", typeID);
				System.out.println(menuID);
				System.out.println(typeID);

				Menu oneMenu = Menu.getOneMenu(menuID, typeID);
				request.setAttribute("oneMenu", oneMenu);

				rd = request.getRequestDispatcher(jspName.menuUpdate);
			}
			rd.forward(request, response);
		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			// 遷移先URLにメニューメンテナンス画面表示処理(サーブレット)をセット
			rd = request.getRequestDispatcher(svlNames.MenuMaintenanceSvl);
			rd.forward(request, response);
		}
		// ×

	}

}
