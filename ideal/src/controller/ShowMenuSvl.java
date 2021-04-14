package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.IdealException;
import model.Menu;
import model.MenuType;

/**
 * Servlet implementation class ShowMenuSvl
 */
@WebServlet("/controller/ShowMenuSvl")
public class ShowMenuSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuSvl() {
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

		String url = "";
		try {

			ArrayList<Course> courseList = Course.getOneCourseList();
			ArrayList<ArrayList<Menu>> menuList = Menu.getAllMenu();
Map<Integer, String> typeName=MenuType.getAllTypeMap();
			request.setAttribute(menuVar.courseList, courseList);
			request.setAttribute(menuVar.menuList, menuList);
			request.setAttribute(menuVar.typeName, typeName);


			url = "/showMenu2.jsp";

		} catch (IdealException e) {

			request.setAttribute(msg, e.getMsg());

				url = jspName.home;

		}

		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
