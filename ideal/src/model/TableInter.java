package model;

/**
 * MySQLのテーブル名とカラム名を保存する為のinterfaceクラス。<br>
 * final命名規則から外してカラム名と同等の変数名としています。
 *
 * @author Kamishiro
 *
 */

public interface TableInter {
	String comma=",";

	// 重複している場合はここで宣言してアドレスを繋ぐだけにする。
	/** 重複しているカラム名 */
	static class play{
		static final String t_id = "t_id";
		static final String c_id ="c_id";
		static final String m_id ="m_id";
		static final String detail = "detail";
		static final String price = "price";
		static final String rsv_id = "rsv_id";
		static final String usr_id = "usr_id";
		static final String table_id = "table_id";
		static final String orderFlg = "orderFlg";
	}
	/** 管理者テーブル */
	static class admin {
		static final String TABLE = "admin";
		static final String adm_name = "adm_name";
		static final String password = "password";
		static final String exp = "exp";

	}
	/** コーステーブル */
	static class course{
		static final String TABLE = "course";
		static final String c_id =play.c_id;
		static final String c_name="c_name";
		static final String detail = play.detail;
		static final String orderFlg = play.orderFlg;
		static final String price = play.price;
		static final String t_id = play.t_id;
	}
	/** コースとメニュー紐づけテーブル */
	static class coursectl{
		static final String TABLE = "coursectl";
		static final String c_id = play.c_id;
		static final String m_id = play.m_id;
	}
	/** メニューテーブル */
	static class menu{
		static final String TABLE = "menu";
		static final String m_id = play.m_id;
		static final String m_Name = "m_name";
		static final String detail = play.detail;
		static final String orderFlg = play.orderFlg;
		static final String price = play.price;
		static final String t_id = play.t_id;
	}
	/** メニュータイプテーブル */
	static class menutype{
		static final String TABLE = "menutype";
		static final String t_id = play.t_id;
		static final String t_name ="t_name";
	}
	/** 予約テーブル */
	static class reserve{
		static final String TABLE = "reserve";
		static final String rsv_id = play.rsv_id;
		static final String usr_id = play.usr_id;
		static final String rsv_date = "rsv_date";
		static final String app_date = "app_date";
		static final String person = "person";
		static final String table_id =play.table_id;
		static final String c_id = play.c_id;
	}
	/** テーブルロケーションテーブル */
	static class table_loc{
		static final String TABLE = "table_loc";
		static final String table_id = play.table_id;
		static final String table_name = "table_name";
		static final String max_capacity="max_capacity";
	}
	static class user{
		static final String TABLE = "user";
		static final String usr_id=play.usr_id;
		static final String usr_name ="usr_name";
	}
}
