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

import model.IdealException;
import model.Menu;
import model.MenuType;

/**
 *
 * メニューをインサート処理するサーブレット。<br>
 * メニューかコースかを判定してメニュー登録画面又は、コース登録画面へ遷移します。<br>
 * エクセプションがスローされた場合メニューメンテナンスを行うサーブレットへ遷移します。<br>
 * Servlet implementation class MenuInsertSvl
 */
@WebServlet("/controller/MenuInsertSvl")
public class MenuInsertSvl extends HttpServlet implements CtrlInter{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuInsertSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(UTF8);
		response.setContentType(CONTENT_TYPE);
		RequestDispatcher rd=null;

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(adminVar.adminInfo) == null) {
			request.setAttribute(msg, new IdealException(IdealException.ERR_NO_SESSION_NULL).getMsg());
			rd = request.getRequestDispatcher(jspName.home);
			rd.forward(request, response);
			return;
		}

		//typeIDをint型にして、100か100以外かで処理を分ける
		int typeID;
		typeID = Integer.parseInt(request.getParameter(menuVar.typeID));
		try{
			//100だったらコース構成分類ごとのメニュー一覧を取得し設定する
			if(typeID==100){
				//menuクラスにあるgetAllMenuメソッドを呼び出し
				ArrayList<ArrayList<Menu>> typeMenuList = Menu.getAllMenu();
				//リクエストオブジェクトに格納
				request.setAttribute("typeMenuList",typeMenuList);
				//遷移先URL「新規コース登録画面」に「t_idの値」を渡す
				rd=request.getRequestDispatcher(jspName.courseInsert);

			//100以外だったら、分類一覧をセットする
			}else{
				ArrayList<MenuType> al=MenuType.getAllType();
				request.setAttribute("mType",al);
				//遷移先URL「新規メニュー登録画面」に「t_idとt_nameの値」を渡す
				rd = request.getRequestDispatcher(jspName.menuInsert);
			}
			//次の処理へ情報を引き継ぐ
			rd.forward(request, response);

		//独自例外が発生した場合、リクエストオブジェクトmsgに、getMsg()で取得したメッセージを設定
		}catch(IdealException e){
			request.setAttribute(msg,e.getMsg());
			//遷移先URLにメニューメンテナンス画面表示処理(サーブレット)をセット
			rd=request.getRequestDispatcher(svlNames.MenuMaintenanceSvl);
			rd.forward(request,response);
		}

	}

}
