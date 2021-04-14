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

import model.Course;
import model.IdealException;
import model.Reserve;
import model.User;

/**
 * Servlet implementation class ReserveOperationSvl
 */
@WebServlet("/controller/ReserveOperationSvl")
public class ReserveOperationSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	public static int INSERT = 11;
	public static int UPDATE = 12;
	public static int DELETE = 13;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveOperationSvl() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(UTF8);
		response.setContentType(CONTENT_TYPE);
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		User user = null;

		int mode = StringToIntCast.castInt(request, reserveVar.mode);
		System.out.println(mode);
		if (session == null || (user = (User) session.getAttribute(loginVar.userInfo)) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		Reserve res = new Reserve();

		res.setRsvId(StringToIntCast.castInt(request, reserveVar.rsvId));
		res.setRsvYy(StringToIntCast.castInt(request, reserveVar.rsvYy));
		res.setRsvMm(StringToIntCast.castInt(request, reserveVar.rsvMm));
		res.setRsvDd(StringToIntCast.castInt(request, reserveVar.rsvDd));
		res.setRsvHh(StringToIntCast.castInt(request, reserveVar.rsvHh));
		res.setRsvMi(StringToIntCast.castInt(request, reserveVar.rsvMi));
		res.setUsrId(user.getUsrId());
		res.setPerson(StringToIntCast.castInt(request, reserveVar.person));
		res.setCourseId(StringToIntCast.castInt(request, reserveVar.courseId));
		res.setTableId(StringToIntCast.castInt(request, reserveVar.tableId));

		Reserve resChk = null;
		String url = null;
		try {
			if (mode == INSERT) {
				url = jspName.reserveInsert;
				resChk = Reserve.insert(res);
				if (resChk == null) {
					throw new IdealException(IdealException.ERR_NO_NOT_VACANCY);
				}
				request.setAttribute(reserveVar.reserve, resChk);
				url = jspName.reserveCompletion;
			} else if (mode == UPDATE) {
				url = jspName.reserveUpdate;
				resChk = Reserve.update(res);
				if (resChk == null) {
					throw new IdealException(IdealException.ERR_NO_NOT_VACANCY);
				}
				url = svlNames.ReserveListSvl;
				response.sendRedirect(url);
				return;
			} else if (mode == DELETE) {
				url = svlNames.ReserveListSvl;
				Reserve.delete(res);
				response.sendRedirect(url);
				return;
			} else {
				// 到達しないはずの領域
				System.err.println("mode数値が適正範囲外です");
				url = svlNames.ReserveListSvl;
				throw new IdealException(IdealException.ERR_NO_SERVER);
			}
		} catch (IdealException e) {
			request.setAttribute(reserveVar.reserve, res);
			try {
				request.setAttribute(reserveVar.courseList, Course.getOneCourseList());
			} catch (IdealException e1) {
			}
			request.setAttribute(msg, e.getMsg());
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
