package controller;

import general.StringToIntCast;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.Menu;

/**
 * メニューの新規登録、変更、削除などを行うサーブレットです。<br>
 * 遷移時に受け取るmodo変数によって分岐します。<br>
 * Servlet implementation class MenuOperationSvl
 */
@WebServlet("/controller/MenuOperationSvl")
public class MenuOperationSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	// ファイナル変数の定義
	public final static int INSERT = 11;
	public final static int UPDATE = 12;
	public final static int DELETE = 13;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuOperationSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = null;
		int mode;
		int menuId;
		String menuName;
		String detail;
		int orderFlg;
		int price;
		int typeID;

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(adminVar.adminInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		mode = StringToIntCast.castInt(request, menuVar.mode);
		menuId =StringToIntCast.castInt(request, menuVar.menuID);
		menuName = request.getParameter(menuVar.menuName);
		detail = request.getParameter(menuVar.detail);
		orderFlg = StringToIntCast.castInt(request, menuVar.orderFlg);
		price = StringToIntCast.castInt(request, menuVar.price);
		typeID = StringToIntCast.castInt(request, menuVar.typeID);

		// JSPから受け取った情報よりメニューobjectをInstance生成
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setDetail(detail);
		menu.setOrderFlg(orderFlg);
		menu.setPrice(price);
		menu.setTypeId(typeID);

		// メニューオブジェクトとmodeでメニュー情報を更新

		String url = "";


		try {
			if (mode == INSERT) {
				url = svlNames.MenuInsertSvl;
				Menu.updateMenu(menu, mode);
			} else if (mode == UPDATE) {
				url = svlNames.MenuUpdateSvl;
				Menu.updateMenu(menu, mode);
			} else if (mode == DELETE) {
				url = svlNames.MenuDeleteSvl;
				Menu.updateMenu(menu, mode);
			}else{
				throw new IdealException(IdealException.ERR_NO_SERVER);
			}
		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			request.setAttribute(menuVar.oneMenu, menu);
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;
		}
		url = svlNames.MenuMaintenanceSvl;
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
