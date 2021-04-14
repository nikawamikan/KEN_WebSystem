package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.IdealException;

/**
 * 管理者ログインをする為のサーブレットです。<br>
 * Servlet implementation class AdminLoginSvl
 */
@WebServlet("/controller/AdminLoginSvl")
public class AdminLoginSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doPostにそのままスローします。
	 *
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * リクエストオブジェクトからadminオブジェクトを生成してフォアードします。
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding(UTF8);
		response.setContentType(CONTENT_TYPE);
		RequestDispatcher rd = null;
		String admName = request.getParameter(adminVar.admName);
		String password = request.getParameter(adminVar.password);

		try {
			Admin ad = Admin.login(admName, password);

			if (ad != null) {

				HttpSession session = request.getSession();
				session.setAttribute(adminVar.adminInfo, ad);
				response.sendRedirect(svlNames.MenuMaintenanceSvl);
				return;

			} else {
				throw new IdealException(IdealException.ERR_NO_ADMIN_EXCEPTION);
			}
		} catch (IdealException ie) {

			request.setAttribute(msg, ie.getMsg());
			rd = request.getRequestDispatcher(jspName.adminLogin);
			rd.forward(request, response);
		}
	}

}
