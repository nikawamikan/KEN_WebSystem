package controller;

import general.ReserveDate;
import general.StringToIntCast;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reserve;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ReserveListAjaxSvl
 */
@WebServlet("/controller/ReserveListAjaxSvl")
public class ReserveListAjaxSvl extends HttpServlet implements CtrlInter {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveListAjaxSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * もらってくるものリスト
		 *
		 * ページを構成した日付
		 * String 型 何日後の数値 int型
		 * 更新か、新規登録か？
		 */
		request.setCharacterEncoding(UTF8);
		response.setContentType("text/plain;charset=utf-8");
		int afterDate=0;
		int mode=0;
		int rsvId=0;
		System.out.println(request.getParameter("rsvId"));
		String today=null;
		// ページと取得した日付が違う場合通信はデータを返さずfailとさせます。(その他例外でも。)
	try {
			today = request.getParameter("today");
			if(!today.equals(ReserveDate.getToday())){
//				System.out.println("日付違い？");
				throw new Exception();
			}
			afterDate = Integer.parseInt(request.getParameter("afterDate"));
			mode = Integer.parseInt(request.getParameter("mode"));
			rsvId = StringToIntCast.castInt(request, reserveVar.rsvId);
			List<List<Boolean>> reserveList = Reserve.reserveCheckList(afterDate, mode, rsvId);
			JSONObject jsonArray = new JSONObject();

			for (int i = 0; i < reserveList.size(); i++) {
				JSONArray json = new JSONArray();
				for (Boolean b : reserveList.get(i)) {
					json.put(b);
				}
				jsonArray.put(""+(i+1),json);
			}

			PrintWriter out = response.getWriter();
			out.print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}



}
