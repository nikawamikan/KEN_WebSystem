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
import model.User;

/**
 * Servlet implementation class UserUpdateSvl
 * 顧客情報変更画面処理
 */
@WebServlet("/controller/UserUpdateSvl")
public class UserUpdateSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(UTF8);
		response.setContentType(CONTENT_TYPE);
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		//セッション情報がnullならばホームページに遷移
		if (session == null || session.getAttribute(loginVar.userInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}
		User us = (User) session.getAttribute(loginVar.userInfo);
		try {
			request.setAttribute(loginVar.userInfo, User.getUser(us.getUsrId()));
			rd = request.getRequestDispatcher(jspName.userUpdate);
		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			rd = request.getRequestDispatcher(jspName.userIndex);
		}

		rd.forward(request, response);

	}

}
