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

import ctrl.SvlUlrl;
import model.IdealException;
import model.User;

/**
 * Servlet implementation class UserLoginSvl
 */
@WebServlet("/controller/UserLoginSvl")
public class UserLoginSvl extends HttpServlet implements CtrlInter{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginSvl() {
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
		String url = null;

		String mail = request.getParameter("mail");
		if(mail==null){
			response.sendRedirect("/ideal/home.jsp");
			return;
		}
		int mode = StringToIntCast.castInt(request, "mode");
		String password = request.getParameter(loginVar.password);

		try {
			User us = User.login(mail, password);
			if(us==null){
				throw new IdealException(IdealException.ERR_NO_NOT_MEMBER_EXCEPTION);
			}
			HttpSession session= request.getSession();
			session.setAttribute(loginVar.userInfo, us);
			if(mode==11){
				url =SvlUlrl.ReserveInsertSvl;
			}else{
				url ="/ideal/home.jsp";
			}
			response.sendRedirect(url);

			return;

		} catch (IdealException e) {
			request.setAttribute(msg, e.getMsg());
			url =jspName.userLogin;
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);;
	}
}
