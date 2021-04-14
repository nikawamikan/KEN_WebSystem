package controller;

import general.StringToIntCast;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Servlet implementation class UserOperationSvl
 */
@WebServlet("/controller/UserOperationSvl")
public class UserOperationSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	public final static int INSERT = 11;
	public final static int UPDATE = 12;
	public final static int DELETE = 13;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserOperationSvl() {
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
		int mode = StringToIntCast.castInt(request, "mode");
		User us = new User();

		if (session == null || session.getAttribute(loginVar.userInfo) == null
				&& mode != 11) {
			request.setAttribute(msg, new IdealException(
					IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		us.setUsrName(request.getParameter("usrName"));
		us.setPassword(request.getParameter("password"));
		us.setZipcode(request.getParameter("zipcode"));
		us.setAddress(request.getParameter("address"));
		us.setPhone(request.getParameter("phone"));
		us.setMail(request.getParameter("mail"));

		String url = "";
		try {
			if (mode == INSERT) {
				url = jspName.userInsert;
				if (User.checkmail(us.getMail())) {
					final String MAIL_P = "^[\\w]+((\\.[\\w-_])*[\\w-_]*)*@[\\w]+((\\.[\\w-_])*[\\w-_]*)*[\\w]+$";
					Pattern p = Pattern.compile(MAIL_P);
					Matcher matcher = p.matcher(us.getMail());
					if (!matcher.find()) {
						throw new IdealException(
								IdealException.ERR_NO_MAIL_REGEX);
					}
				}

				us = User.insert(us);
				us = User.getUser(us.getUsrId());
				User us2 = new User();
				us2.setUsrId(us.getUsrId());
				us2.setUsrName(us.getUsrName());

				session = request.getSession();
				session.setAttribute(loginVar.userInfo, us2);
				request.setAttribute(loginVar.userInfo, us);
				rd = request.getRequestDispatcher(jspName.userInsertCompletion);
				rd.forward(request, response);

				return;

			} else if (mode == UPDATE) {
				us.setUsrId(Integer.parseInt(request.getParameter("usrId")));
				us.setNewPassword(request.getParameter("newPassword"));

				url = svlNames.UserUpdateSvl;

				if (User.checkmail(us.getMail(), us.getUsrId())) {
					final String MAIL_P = "^[\\w]+((\\.[\\w-_])*[\\w-_]*)*@[\\w]+((\\.[\\w-_])*[\\w-_]*)*[\\w]+$";
					Pattern p = Pattern.compile(MAIL_P);
					Matcher matcher = p.matcher(us.getMail());
					if (!matcher.find()) {
						throw new IdealException(
								IdealException.ERR_NO_MAIL_REGEX);
					}
				}

				User.login(User.getUser(us.getUsrId()).getMail(),
						us.getPassword());
				us = User.update(us);
				session = request.getSession();
				session.setAttribute(loginVar.userInfo, us);
				response.sendRedirect("/ideal" + jspName.userIndex);

				return;

			} else if (mode == DELETE) {
				us.setUsrId(Integer.parseInt(request.getParameter("usrId")));
				url = svlNames.UserDeleteSvl;
				User.delete(us);
				session.invalidate();
				response.sendRedirect("/ideal" + jspName.home);

				return;

			} else {
				url = jspName.home;
				throw new IdealException(IdealException.ERR_NO_SERVER);
			}

		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}

	}
}
