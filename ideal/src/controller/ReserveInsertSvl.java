package controller;

import general.ReserveDate;
import general.StringToIntCast;

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
import model.Reserve;
import model.User;

/**
 * 予約情報を新規登録する画面へ遷移する為のサーブレットです。<br>
 * コース情報を Servlet implementation class ReserveInsertSvl
 */
@WebServlet("/controller/ReserveInsertSvl")
public class ReserveInsertSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveInsertSvl() {
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
		HttpSession session = request.getSession(false);
		User user = null;

		if (session == null
				|| (user = (User) session.getAttribute(loginVar.userInfo)) == null) {
			request.setAttribute("mode", "11");
			rd = request.getRequestDispatcher(jspName.userLogin);
			rd.forward(request, response);
			return;
		}

		Reserve res = new Reserve();
		res.setRsvYy(StringToIntCast.castInt(request, reserveVar.rsvYy));

		if (res.getRsvYy() == 0) {
			ArrayList<Integer> nowDate = ReserveDate
					.getDateIntArray(ReserveDate.getNow());
			res.setRsvYy(nowDate.get(0));
			res.setRsvMm(nowDate.get(1));
			res.setRsvDd(nowDate.get(2));
			res.setRsvHh(nowDate.get(3));
			res.setRsvMi(nowDate.get(4));
		}else{
			res.setRsvMm(StringToIntCast.castInt(request, reserveVar.rsvMm));
			res.setRsvDd(StringToIntCast.castInt(request, reserveVar.rsvDd));
			res.setRsvHh(StringToIntCast.castInt(request, reserveVar.rsvHh));
			res.setRsvMi(StringToIntCast.castInt(request, reserveVar.rsvMi));
		}
		res.setUsrId(user.getUsrId());
		res.setPerson(StringToIntCast.castInt(request, reserveVar.person));
		res.setCourseId(StringToIntCast.castInt(request, reserveVar.courseId));

		ArrayList<Course> crsList = null;

		try {
			crsList = Course.getOneCourseList();
			request.setAttribute(reserveVar.reserve, res);
			request.setAttribute(reserveVar.courseList, crsList);
			rd = request.getRequestDispatcher(jspName.reserveInsert);

		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			rd = request.getRequestDispatcher(jspName.reserveList);
		}

		rd.forward(request, response);

	}
}
