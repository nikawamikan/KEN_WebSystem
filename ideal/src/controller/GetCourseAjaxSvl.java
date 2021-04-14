package controller;

import general.FormReplacer;
import general.StringToIntCast;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.MenuBase;
import model.MenuType;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class GetCourseAjaxSvl
 */
@WebServlet("/controller/GetCourseAjaxSvl")
public class GetCourseAjaxSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCourseAjaxSvl() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(UTF8);
		response.setContentType("text/plain;charset=utf-8");
		int courseId = 0;
		courseId = StringToIntCast.castInt(request, "courseId");
		try {
			Course co = Course.getOneCourse(courseId);
			HashMap<Integer, String> mt = (HashMap<Integer, String>)MenuType.getAllTypeMap();
			JSONObject jsonArray = new JSONObject();

			JSONArray type = new JSONArray();
			JSONArray menu = new JSONArray();
			for (MenuBase m : co.getMenuList()) {
				type.put(FormReplacer.fmtNull(mt.get(m.getTypeId())));
				menu.put(FormReplacer.fmtNull(m.getMenuName()));
			}
			jsonArray.put("menu",menu);
			jsonArray.put("type",type);

			jsonArray.put("courseName", FormReplacer.fmtNull(co.getCourseName()));
			jsonArray.put("price", co.getPrice());
			jsonArray.put("detail", FormReplacer.fmtNull(co.getDetail()));

			PrintWriter out = response.getWriter();
			out.print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
