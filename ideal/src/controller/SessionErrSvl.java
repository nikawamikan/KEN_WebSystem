package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;

/**
 * セッション切れしている時にjspから呼び出す予定のサブレ
 */
@WebServlet("/controller/SessionErrSvl")
public class SessionErrSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionErrSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doPostに値を投げる
	 *
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		RequestDispatcher rd = null;
		if (session == null || session.getAttribute(adminVar.adminInfo) == null
				|| session.getAttribute(loginVar.userInfo) == null) {
			request.setAttribute(msg, new IdealException(
					IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}
		response.sendRedirect("/ideal/home.jsp");
	}

}
