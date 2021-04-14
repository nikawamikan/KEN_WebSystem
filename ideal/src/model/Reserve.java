package model;

import general.ReserveDate;
import general.SQL_BeanCORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import controller.ReserveOperationSvl;

/**
 * 予約SQLを実行する。
 *
 * @param rsvId
 *            予約ＩＤ
 * @param usrId
 *            ユーザーＩＤ
 * @param usrName
 *            ユーザーネーム
 * @param rsvYy
 *            予約年
 * @param rsvMm
 *            予約月
 * @param rsvDd
 *            予約日
 * @param rsvHh
 *            予約時
 * @param rsvMi
 *            予約分
 * @param person
 *            予約人数
 * @param tableId
 *            座席ＩＤ
 * @param tableName
 *            座席の名前
 * @param courseId
 *            コースのＩＤ
 * @param courseName
 *            コースの名前
 * @param appDate
 *            予約された日時(文字列)
 * @param appYy
 *            予約された年
 * @param appMm
 *            予約された月
 * @param appDd
 *            予約された日
 * @param appHh
 *            予約された時
 * @param appMi
 *            予約された分
 *
 * @author Kamishiro
 *
 */
public class Reserve implements TableInter {

	/** 予約ID */
	private int rsvId;

	/** ユーザーID */
	private int usrId;

	/** ユーザーネーム */
	private String usrName;

	/** 予約年 */
	private int rsvYy;

	/** 予約月 */
	private int rsvMm;

	/** 予約日 */
	private int rsvDd;

	/** 予約時 */
	private int rsvHh;

	/** 予約分 */
	private int rsvMi;

	/** 予約人数 */
	private int person;

	/** テーブルID（店の） */
	private int tableId;

	/** テーブル名(店の) */
	private String tableName;

	/** コースID */
	private int courseId;

	/** コース名 */
	private String courseName;

	/** 登録日時（String型でTimeStamp形式で記録） */
	private String appDate;

	/** 登録年 */
	private int appYy;

	/** 登録月 */
	private int appMm;

	/** 登録日 */
	private int appDd;

	/** 登録時 */
	private int appHh;

	/** 登録分 */
	private int appMi;

	public int getRsvId() {
		return rsvId;
	}

	public int getUsrId() {
		return usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public int getRsvYy() {
		return rsvYy;
	}

	public int getRsvMm() {
		return rsvMm;
	}

	public int getRsvDd() {
		return rsvDd;
	}

	public int getRsvHh() {
		return rsvHh;
	}

	public int getRsvMi() {
		return rsvMi;
	}

	public int getPerson() {
		return person;
	}

	public int getTableId() {
		return tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getAppDate() {
		return appDate;
	}

	public int getAppYy() {
		return appYy;
	}

	public int getAppMm() {
		return appMm;
	}

	public int getAppDd() {
		return appDd;
	}

	public int getAppHh() {
		return appHh;
	}

	public int getAppMi() {
		return appMi;
	}

	public void setRsvId(int rsvId) {
		this.rsvId = rsvId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public void setRsvYy(int rsvYy) {
		this.rsvYy = rsvYy;
	}

	public void setRsvMm(int rsvMm) {
		this.rsvMm = rsvMm;
	}

	public void setRsvDd(int rsvDd) {
		this.rsvDd = rsvDd;
	}

	public void setRsvHh(int rsvHh) {
		this.rsvHh = rsvHh;
	}

	public void setRsvMi(int rsvMi) {
		this.rsvMi = rsvMi;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCourceName(String courceName) {
		this.courseName = courceName;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
		ArrayList<Integer> date = ReserveDate.getDateIntArray(appDate);
		setAppYy(date.get(0));
		setAppMm(date.get(1));
		setAppDd(date.get(2));
		setAppHh(date.get(3));
		setAppMi(date.get(4));
	}

	public void setAppYy(int appYy) {
		this.appYy = appYy;
	}

	public void setAppMm(int appMm) {
		this.appMm = appMm;
	}

	public void setAppDd(int appDd) {
		this.appDd = appDd;
	}

	public void setAppHh(int appHh) {
		this.appHh = appHh;
	}

	public void setAppMi(int appMi) {
		this.appMi = appMi;
	}

	/**
	 * 管理者が取得する予約リスト。全てのユーザーのリストを取得<br/>
	 * 引数にtrueを入れた場合は過去のリストの取得、falseの場合は本日より先のリストを取得
	 *
	 * @param fulfilled
	 *            設定をtrue falseとして送る
	 * @return List
	 * @throws IdealException
	 *             データベースに例外が発生した場合にスローされます。
	 */
	public static ArrayList<Reserve> getAdminReserveList(boolean fulfilled)
			throws IdealException {
		String date = ReserveDate.getToday();
		String add = "";
		String add2 = "";
		if (fulfilled) {
			add = " < ";
			add2 = " DESC";
		} else {
			add = " > ";
		}

		final String sql = "SELECT " + reserve.rsv_id + comma + reserve.rsv_id
				+ comma + reserve.usr_id + comma + user.usr_name + comma
				+ reserve.rsv_date + comma + reserve.person + comma
				+ table_loc.table_id + comma + table_loc.table_name + comma
				+ course.c_id + comma + course.c_name + comma
				+ reserve.app_date + " FROM " + reserve.TABLE + " LEFT JOIN "
				+ user.TABLE + " USING(" + user.usr_id + ") LEFT JOIN "
				+ table_loc.TABLE + " USING(" + table_loc.table_id
				+ ") LEFT JOIN " + course.TABLE + " USING(" + course.c_id
				+ ") WHERE "+reserve.rsv_date + add + "? ORDER BY " + reserve.rsv_date + add2;

		ArrayList<Reserve> rsvArray = new ArrayList<Reserve>();
		try {

			return new SQL_BeanCORE<ArrayList<Reserve>>(sql) {

				@Override
				protected ArrayList<Reserve> query(Connection con,
						PreparedStatement pst, ResultSet rs)
						throws SQLException {
					pst.setString(1, date);
					rs = pst.executeQuery();

					while (rs.next()) {
						Reserve res = new Reserve();

						res.setRsvId(rs.getInt(reserve.rsv_id));
						res.setUsrId(rs.getInt(reserve.usr_id));
						res.setUsrName(rs.getString(user.usr_name));

						// TIME STAMP形式は 2014-04-23 15:26:50
						// のような文字列なので変換クラスを用意します
						ArrayList<Integer> tempDate = ReserveDate
								.getDateIntArray(rs.getString(reserve.rsv_date));
						res.setRsvYy(tempDate.get(0));
						res.setRsvMm(tempDate.get(1));
						res.setRsvDd(tempDate.get(2));
						res.setRsvHh(tempDate.get(3));
						res.setRsvMi(tempDate.get(4));

						res.setPerson(rs.getInt(reserve.person));
						res.setTableId(rs.getInt(reserve.table_id));
						res.setTableName(rs.getString(table_loc.table_name));
						res.setCourseId(rs.getInt(reserve.c_id));
						res.setCourceName(rs.getString(course.c_name));
						res.setAppDate(rs.getString(reserve.app_date));

						rsvArray.add(res);
					}

					return rsvArray;
				}

			}.bean();

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return rsvArray;
	}

	/**
	 * 顧客IDから顧客の予約情報を表示するメソッドです。
	 *
	 * @param usrId
	 *            MySQLにおけるuserテーブルを使用します。
	 * @return ArrayList<Reserve> 顧客IDから出力した予約情報
	 * @throws IdealException
	 *             データベース処理に問題が生じた場合に例外を投げます
	 */
	public static ArrayList<Reserve> getReserveList(int usrId, boolean fulfilled)
			throws IdealException {
		String date = ReserveDate.getToday();
		String add = "";
		if (fulfilled) {
			add = "AND " + reserve.rsv_date + " > ? ";
		}

		final String sql = "SELECT " + reserve.rsv_id + comma + reserve.rsv_id
				+ comma + reserve.usr_id + comma + user.usr_name + comma
				+ reserve.rsv_date + comma + reserve.person + comma
				+ table_loc.table_id + comma + table_loc.table_name + comma
				+ course.c_id + comma + course.c_name + comma
				+ reserve.app_date + " FROM " + reserve.TABLE + " LEFT JOIN "
				+ user.TABLE + " USING(" + user.usr_id + ") LEFT JOIN "
				+ table_loc.TABLE + " USING(" + table_loc.table_id
				+ ") LEFT JOIN " + course.TABLE + " USING(" + course.c_id
				+ ") WHERE " + user.usr_id + " = ? " + add + " ORDER BY "
				+ reserve.rsv_date;

		ArrayList<Reserve> rsvArray = new ArrayList<Reserve>();
		try {

			return new SQL_BeanCORE<ArrayList<Reserve>>(sql) {

				@Override
				protected ArrayList<Reserve> query(Connection con,
						PreparedStatement pst, ResultSet rs)
						throws SQLException {
					pst.setInt(1, usrId);
					if (fulfilled) {
						pst.setString(2, date);
					}
					rs = pst.executeQuery();

					while (rs.next()) {
						Reserve res = new Reserve();

						res.setRsvId(rs.getInt(reserve.rsv_id));
						res.setUsrId(rs.getInt(reserve.usr_id));
						res.setUsrName(rs.getString(user.usr_name));

						// TIME STAMP形式は 2014-04-23 15:26:50
						// のような文字列なので変換クラスを用意します
						ArrayList<Integer> tempDate = ReserveDate
								.getDateIntArray(rs.getString(reserve.rsv_date));
						res.setRsvYy(tempDate.get(0));
						res.setRsvMm(tempDate.get(1));
						res.setRsvDd(tempDate.get(2));
						res.setRsvHh(tempDate.get(3));
						res.setRsvMi(tempDate.get(4));

						res.setPerson(rs.getInt(reserve.person));
						res.setTableId(rs.getInt(reserve.table_id));
						res.setTableName(rs.getString(table_loc.table_name));
						res.setCourseId(rs.getInt(reserve.c_id));
						res.setCourceName(rs.getString(course.c_name));
						res.setAppDate(rs.getString(reserve.app_date));

						rsvArray.add(res);
					}

					return rsvArray;
				}

			}.bean();

		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return rsvArray;
	}

	/**
	 * 予約IDから予約情報をreturnするmethodです。
	 *
	 * @param rsvId
	 *            予約ID
	 * @return Reserve型の予約情報
	 * @throws IdealException
	 *             データベース処理に問題が生じた場合に例外を投げます
	 */
	public static Reserve getReserve(int rsvId) throws IdealException {

		final String sql = "SELECT " + reserve.rsv_id + comma + reserve.usr_id
				+ comma + user.usr_name + comma + reserve.rsv_date + comma
				+ reserve.person + comma + table_loc.table_id + comma
				+ table_loc.table_name + comma + course.c_id + comma
				+ course.c_name + comma + reserve.app_date + " FROM "
				+ reserve.TABLE + " LEFT JOIN " + user.TABLE + " USING("
				+ user.usr_id + ") LEFT JOIN " + table_loc.TABLE + " USING("
				+ table_loc.table_id + ") LEFT JOIN " + course.TABLE
				+ " USING(" + course.c_id + ")" + " WHERE " + reserve.rsv_id
				+ " = ?";
		try {
			return new SQL_BeanCORE<Reserve>(sql) {

				@Override
				protected Reserve query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {

					pst.setInt(1, rsvId);
					rs = pst.executeQuery();
					if (rs.next()) {
						Reserve res = new Reserve();

						res.setRsvId(rs.getInt(reserve.rsv_id));
						res.setUsrId(rs.getInt(user.usr_id));
						res.setUsrName(rs.getString(user.usr_name));

						// TIME STAMP形式は 2014-04-23 15:26:50
						// のような文字列なので変換クラスを用意します
						ArrayList<Integer> tempDate = ReserveDate
								.getDateIntArray(rs.getString(reserve.rsv_date));
						res.setRsvYy(tempDate.get(0));
						res.setRsvMm(tempDate.get(1));
						res.setRsvDd(tempDate.get(2));
						res.setRsvHh(tempDate.get(3));
						res.setRsvMi(tempDate.get(4));

						res.setPerson(rs.getInt(reserve.person));
						res.setTableId(rs.getInt(table_loc.table_id));
						res.setTableName(rs.getString(table_loc.table_name));
						res.setCourseId(rs.getInt(course.c_id));
						res.setCourceName(rs.getString(course.c_name));
						res.setAppDate(rs.getString(reserve.app_date));

						return res;
					}
					return null;
				}

			}.bean();
		} catch (NamingException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * コースが予約されている時にコースを削除すること不可にする為のメソッド<br>
	 * 本日以降に予約がある場合は独自例外をスローします。
	 *
	 * @param courseId
	 *            コースID
	 * @throws IdealException
	 *             予約がされている場合、SQLに問題がある場合にスロー
	 */
	public static void reservCourseChk(int courseId) throws IdealException {

		final String timeStamp = ReserveDate.getToday();
		final String sql = "SELECT " + course.c_id + " FROM " + reserve.TABLE
				+ " WHERE " + course.c_id + " = ? AND " + reserve.rsv_date
				+ " >= ?";

		try {
			if (new SQL_BeanCORE<Boolean>(sql) {

				@Override
				protected Boolean query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					pst.setInt(1, courseId);
					pst.setString(2, timeStamp);
					rs = pst.executeQuery();
					if (rs.next()) {
						return true;
					}
					return false;
				}
			}.bean()) {
				throw new IdealException(IdealException.ERR_NO_NOT_MENU_DELETE);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
	}

	/**
	 * 日時と人数から予約可能かをチェックして可能な場合は座席情報をreturnします。<br>
	 * 不可能な場合はnullで返します。
	 *
	 * @param dateStr
	 *            日時
	 * @param personNum
	 *            人数
	 * @throws IdealException
	 *             データベースに例外が発生した場合例外をスローします
	 * @return TableLoc 予約可能な座席をTableLoc型でreturn 存在しない場合はnull
	 */
	public static TableLoc insertChk(String dateStr, int personNum, int tableId)
			throws IdealException {
		// BETWEENでは少ない数から大きい数で実装する必要があり検出できなかった模様 BETWEEN 0 AND 12 のような感じ
		final String sql = "SELECT * FROM " + table_loc.TABLE + " WHERE NOT "
				+ table_loc.table_id + " IN" + "(SELECT " + reserve.table_id
				+ " FROM " + reserve.TABLE + " WHERE " + reserve.rsv_date
				+ " BETWEEN ? AND ? )" + "AND " + table_loc.max_capacity
				+ " >= ? AND " + table_loc.table_id + " =?";
		try {
			return new SQL_BeanCORE<TableLoc>(sql) {

				@Override
				protected TableLoc query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException, IdealException {
					ReserveDate commonDate = ReserveDate
							.getInstanceReserve(dateStr);

					pst.setString(1, commonDate.getBeforeTime());
					pst.setString(2, commonDate.getAfterTime());
					pst.setInt(3, personNum);
					pst.setInt(4, tableId);
					rs = pst.executeQuery();

					if (rs.next()) {
						TableLoc tableLoc = new TableLoc();

						tableLoc.setMaxCapacity(rs
								.getInt(table_loc.max_capacity));
						tableLoc.setTableId(rs.getInt(table_loc.table_id));
						tableLoc.setTableName(rs
								.getString(table_loc.table_name));

						return tableLoc;
					}
					return null;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
		return null;
	}

	/**
	 * 予約変更でテーブル変更可能かチェック？
	 *
	 * @param rsvID
	 * @param dateStr
	 * @param personNum
	 * @return
	 * @throws IdealException
	 */
	public static TableLoc updateChk(int rsvID, String dateStr, int personNum,
			int tableId) throws IdealException {
		final String sql = "SELECT * FROM " + table_loc.TABLE + " WHERE NOT "
				+ table_loc.table_id + " IN" + "(SELECT " + reserve.table_id
				+ " FROM " + reserve.TABLE + " WHERE " + reserve.rsv_date
				+ " BETWEEN ? AND ? AND NOT " + reserve.rsv_id + "=?)" + "AND "
				+ table_loc.max_capacity + " >= ? AND " + reserve.table_id
				+ "=?";
		try {
			return new SQL_BeanCORE<TableLoc>(sql) {

				@Override
				protected TableLoc query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					ReserveDate commonDate = ReserveDate
							.getInstanceReserve(dateStr);

					pst.setString(1, commonDate.getAfterTime());
					pst.setString(2, commonDate.getBeforeTime());
					pst.setInt(3, rsvID);
					pst.setInt(4, personNum);
					pst.setInt(5, tableId);
					rs = pst.executeQuery();

					if (rs.next()) {
						TableLoc tableLoc = new TableLoc();

						tableLoc.setMaxCapacity(rs
								.getInt(table_loc.max_capacity));
						tableLoc.setTableId(rs.getInt(table_loc.table_id));
						tableLoc.setTableName(rs
								.getString(table_loc.table_name));

						return tableLoc;
					}
					return null;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
		return null;
	}

	/**
	 * 予約のインサート
	 *
	 * @param reserve
	 * @return
	 */
	public static Reserve insert(Reserve res) throws IdealException {
		final String sql = "INSERT INTO " + reserve.TABLE + "("
				+ reserve.usr_id + comma + reserve.rsv_date + comma
				+ reserve.person + comma + reserve.c_id + comma
				+ reserve.table_id + ")" + "VALUES(?,?,?,?,?)";
		final String sql2 = "SELECT LAST_INSERT_ID() FROM " + reserve.TABLE;
		final String dateStr = ReserveDate.getTimeStamp(res.getRsvYy(),
				res.getRsvMm(), res.getRsvDd(), res.getRsvHh(), res.getRsvMi());
		TableLoc tl = insertChk(dateStr, res.person, res.tableId);
		Integer rsvId = null;
		if (tl != null) {
			try {
				rsvId = new SQL_BeanCORE<Integer>(sql) {

					@Override
					protected Integer query(Connection con,
							PreparedStatement pst, ResultSet rs)
							throws SQLException {
						pst.setInt(1, res.usrId);
						pst.setString(2, dateStr);
						pst.setInt(3, res.person);
						pst.setInt(4, res.courseId);
						pst.setInt(5, tl.getTableId());

						pst.executeUpdate();

						pst = con.prepareStatement(sql2);

						rs = pst.executeQuery();
						if (rs.next()) {
							return rs.getInt(1);
						}
						return null;
					}
				}.bean();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
			if (rsvId != null) {
				return getReserve(rsvId);
			}
		}
		return null;
	}

	/**
	 * 予約の変更
	 *
	 * @param reserve
	 * @return
	 */
	public static Reserve update(Reserve res) throws IdealException {

		final String sql = "UPDATE " + reserve.TABLE + " SET " + reserve.usr_id
				+ "=? ," + reserve.rsv_date + "=? ," + reserve.person + "=? ,"
				+ reserve.table_id + "=? ," + reserve.c_id + "=? ,"
				+ reserve.app_date + "=? " + "WHERE " + reserve.rsv_id + "=?";
		final String resDate = ReserveDate.getTimeStamp(res.rsvYy, res.rsvMm,
				res.rsvDd, res.rsvHh, res.rsvMi);
		final String appDate = ReserveDate.getNow();

		TableLoc tl = updateChk(res.rsvId, resDate, res.person, res.tableId);
		if (tl != null) {
			try {
				return new SQL_BeanCORE<Reserve>(sql) {

					@Override
					protected Reserve query(Connection con,
							PreparedStatement pst, ResultSet rs)
							throws SQLException {
						pst.setInt(1, res.usrId);
						pst.setString(2, resDate);
						pst.setInt(3, res.person);
						pst.setInt(4, tl.getTableId());
						pst.setInt(5, res.courseId);
						pst.setString(6, appDate);
						pst.setInt(7, res.rsvId);


						pst.executeUpdate();

						res.setTableId(tl.getTableId());
						res.setAppDate(appDate);

						return res;

					}
				}.bean();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return null;
	}

	/**
	 * 予約の削除
	 *
	 * @param reserve
	 */
	public static void delete(Reserve res) throws IdealException {
		final String sql = "DELETE FROM " + reserve.TABLE + " WHERE "
				+ reserve.rsv_id + " = ?";
		try {
			new SQL_BeanCORE<Void>(sql) {

				@Override
				protected Void query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					pst.setInt(1, res.getRsvId());
					pst.executeUpdate();
					return null;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_EXCEPTION);
		}
	}

	/**
	 * 何日後の数値から予約可能な席と時間帯を取得するためのメソッドです。<br>
	 * insertとupdateで使用する事を想定しています。
	 *
	 * @param today
	 *            何日後かの数値
	 * @param mode
	 *            ReserveOperationSvlから取得できるUPDATEなどの定数
	 * @param rsvId
	 *            予約ID(UPDATEの時のみ使用します。)
	 * @return List型で2次配列的な正誤判定
	 * @throws IdealException
	 *             データベース例外が発生した場合にthrowされます。
	 */
	public static List<List<Boolean>> reserveCheckList(int today, int mode,
			int rsvId) throws IdealException {
		List<List<Boolean>> list = new ArrayList<List<Boolean>>();
		String modeString = "";
		if (mode == ReserveOperationSvl.UPDATE)
			modeString = "AND NOT " + reserve.rsv_id + " =?";

		final String sql = "SELECT " + reserve.rsv_date + comma
				+ reserve.table_id + " FROM " + reserve.TABLE + " WHERE "
				+ reserve.rsv_date + " BETWEEN ? AND ? " + modeString
				+ " ORDER BY " + reserve.table_id;
		try {
			return new SQL_BeanCORE<List<List<Boolean>>>(sql, false) {

				@Override
				protected List<List<Boolean>> query(Connection con,
						PreparedStatement pst, ResultSet rs)
						throws SQLException, IdealException {

					pst.setString(1, ReserveDate.getToday(today));
					pst.setString(2, ReserveDate.getToday(today + 1));
					if (mode == ReserveOperationSvl.UPDATE)
						pst.setInt(3, rsvId);


					rs = pst.executeQuery();

					for (int i = 0; i < 7; i++) {
						list.add(new ArrayList<Boolean>());
					}
					list.forEach(li -> {
						for (int i = 0; i < 19; i++) {
							li.add(true);
						}
					});

					while (rs.next()) {
						ArrayList<Integer> date = ReserveDate
								.getDateIntArray(rs.getString(reserve.rsv_date));
						int tId = rs.getInt(reserve.table_id);
						falser(list, date, tId);
					}
					// list.forEach(lili -> {
					// lili.forEach(f -> {
					// if (f) {
					// System.out.print(1);
					// } else {
					// System.out.print(0);
					// }
					// });
					// System.out.println();
					// });
					return list;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return null;
	}

	/**
	 * 予約情報から予約可能な配列を出力するメソッドです。
	 *
	 * @param list
	 *            てーぶるID事の予約可能な時間の配列
	 * @param date
	 *            ReserveDateで定義したList型のInteger配列
	 * @param tId
	 *            DataBaseで取得したテーブルID
	 */
	private static void falser(List<List<Boolean>> list, List<Integer> date,
			int tId) {
		// 0年 1月 2日 3時 4分 5秒
		// 17

		tId -= 1;
		int time = (date.get(3) - 17) * 4 + (date.get(4) / 15);

		int start = time - 10;
		int end = time + 12;
		if (start < 0)
			start = 0;

		// System.out.println(time + " " + start + " " + end);

		try {
			for (; start < end; start++) {
				list.get(tId).set(start, false);
			}
		} catch (IndexOutOfBoundsException e) {
			return;
		}
	}

}
