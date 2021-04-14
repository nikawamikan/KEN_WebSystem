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
import model.Reserve;

/**
 * メニューを削除する画面へ遷移する為のサーブレットです。<br>
 * Servlet implementation class ReserveDeleteSvl
 */
@WebServlet("/controller/ReserveDeleteSvl")
public class ReserveDeleteSvl extends HttpServlet implements CtrlInter{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveDeleteSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(UTF8);
		response.setContentType(CONTENT_TYPE);
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);

		if (session == null
				||  session.getAttribute(loginVar.userInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		int rsvId = StringToIntCast.castInt(request, reserveVar.rsvId);
		Reserve res;

		try {
			res = Reserve.getReserve(rsvId);
			request.setAttribute(reserveVar.reserve, res);
			rd = request.getRequestDispatcher(jspName.reserveDelete);

		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			rd = request.getRequestDispatcher(jspName.reserveList);
		}

		rd.forward(request, response);
	}

}
