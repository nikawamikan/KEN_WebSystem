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

import ctrl.JspName;
import model.IdealException;
import model.Reserve;
import model.User;

/**
 * Servlet implementation class ReserveListSvl
 */
@WebServlet("/controller/ReserveListSvl")
public class ReserveListSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveListSvl() {
		super();
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
		User user = null;



		HttpSession session = request.getSession(false);
		if (session == null
				|| (user = (User) session.getAttribute(loginVar.userInfo)) == null) {
			request.setAttribute("mode","11");
			rd = request.getRequestDispatcher(JspName.userLogin);
			rd.forward(request, response);
			return;
		}

		try {
			ArrayList<Reserve> reserveList = Reserve.getReserveList(user.getUsrId(),true);
			request.setAttribute(reserveVar.reserveList, reserveList);
			rd = request.getRequestDispatcher(jspName.reserveList);

		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			rd = request.getRequestDispatcher(jspName.userIndex);
		}

		rd.forward(request, response);
		return;
	}
}
