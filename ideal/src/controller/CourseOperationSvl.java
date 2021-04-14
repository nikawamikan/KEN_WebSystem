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

/**
 * コースを登録、更新、削除を行う為のサーブレット。<br>
 *
 * Servlet implementation class CourseOperationSvl
 */
@WebServlet("/controller/CourseOperationSvl")
public class CourseOperationSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/** コース登録処理 */
	public static final int INSERT = 21;
	/** コース変更処理 */
	public static final int UPDATE = 22;
	/** コース削除処理 */
	public static final int DELETE = 23;

	/**
	 * コースメニュータイプID<br>
	 *
	 * @param 200 前菜0
	 * @param 210 スープ1
	 * @param 220 パスタ2
	 * @param 300 肉料理(メイン)3
	 * @param 310 魚料理(メイン)4
	 * @param 400 デザート5
	 *
	 */
	public static final int[] COURSE_MENU_TYPE_ID = { 200, 210, 220, 300, 310,
			400 };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseOperationSvl() {
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

		if (session == null || session.getAttribute(adminVar.adminInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		int mode = StringToIntCast.castInt(request, menuVar.mode, 100);
		String url = null;

		try {
			if (mode == INSERT) {

				Course course = insertCourseParam(request);
				Course.updateCourse(course, INSERT);

			} else if (mode == UPDATE) {

				Course course = insertCourseParam(request);
				course.setCourseId(StringToIntCast.castInt(request,
						courseVar.courseID));
				Course.updateCourse(course, UPDATE);

			} else if (mode == DELETE) {

				Course course = new Course();
				course.setCourseId(StringToIntCast.castInt(request,
						courseVar.courseID));
				Course.updateCourse(course, DELETE);

			} else {
				throw new IdealException(IdealException.ERR_NO_SERVER);

			}
		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
		}

		request.setAttribute(menuVar.typeID, 100);
		url = svlNames.MenuMaintenanceSvl;
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * リクエストオブジェクトからコースオブジェクトを取り出すメソッドです。<br>
	 * フォームに入力された値を取得して使用します。
	 *
	 * @param request
	 *            jspからフォアードされたフォームの内容を格納しているrequestオブジェクト
	 * @return Course フォームの入力値をCourseオブジェクトに入力したもの
	 */
	private static Course insertCourseParam(HttpServletRequest request) {
		Course course = new Course();
		course.setCourseName(request.getParameter(courseVar.courseName));
		course.setPrice(StringToIntCast.castInt(request, courseVar.price));
		course.setOrderFlg(StringToIntCast.castInt(request,courseVar.orderFlg));
		course.setDetail(request.getParameter(courseVar.detail));
		course.setMenuIds(StringToIntCast.castInt(request,courseVar.appetizerID));
		course.setMenuIds(StringToIntCast.castInt(request, courseVar.soupID));
		course.setMenuIds(StringToIntCast.castInt(request, courseVar.pastaID));
		course.setMenuIds(StringToIntCast.castInt(request, courseVar.meatID));
		course.setMenuIds(StringToIntCast.castInt(request, courseVar.fishID));
		course.setMenuIds(StringToIntCast.castInt(request, courseVar.dessertID));
		return course;
	}

}