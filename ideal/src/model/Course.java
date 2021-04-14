package model;

import general.SQL_BeanCORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import controller.CourseOperationSvl;

public class Course implements TableInter {
	private int courseId;
	private String courseName;
	private String detail;
	private int orderFlg;
	private int price;
	private int typeId;
	private String typeName;
	private int menuId;
	private String menuName;
	private List<MenuBase> menuList = null;
	private Map<Integer, MenuBase> menuMap = null;
	private ArrayList<Integer> menuIds = new ArrayList<>();
	/** TypeID 200, 210, 220, 300, 310, 400 */
	public static final int[] COURSE = { 200, 210, 220, 300, 310, 400 };

	/**
	 * コースに含まれるメニューをTypeIdからMenuBaseオブジェクトをreturnします。<br>
	 * コース内にそのTypeIdのメニューが存在しない場合はNullをreturnします
	 *
	 * @param TypeId
	 *            200, 210, 220, 300, 310, 400 の中でのTypeId
	 * @return 対応したMenuBaseオブジェクト
	 */
	public MenuBase getOneCourseMenu(int typeId) {
		if (menuMap == null || !menuMap.containsKey(typeId)) {
			return null;
		}
		return menuMap.get(typeId);
	}

	public Map<Integer, MenuBase> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<Integer, MenuBase> menuMap) {
		this.menuMap = menuMap;
	}

	/**
	 * 本メソッドを使用する場合は本クラス内のgetOneCourseメソッドを使用して実体化する必要があります。<br>
	 * コース内のメニュー詳細情報のListを返すメソッドです。<br>
	 * 単体でのMenuBaseオブジェクトを取得する際はgetMenuListOne()メソッドにindexを入力して取得することを推奨します。
	 *
	 * @return MenuBaseオブジェクトのListです。
	 */
	public List<MenuBase> getMenuList() {
		return menuList;
	}

	/**
	 * 本メソッドを使用する場合は本クラス内のgetOneCourseメソッドを使用して実体化する必要があります。<br>
	 * コース内の詳細情報をMenuBaseオブジェクトで返すメソッドです。<br>
	 * 引数を範囲を求める場合はgetMenuListSizeメソッドを使用してください。<br>
	 * menuListがnullの場合やList内にobjectが存在しない場合はnullを返します。
	 *
	 * @return MenuBaseオブジェクト
	 */
	public MenuBase getMenuListOne(int index) {
		if (menuList != null || !menuList.isEmpty())
			return this.menuList.get(index);
		return null;
	}

	/**
	 * 本メソッドを使用する場合は本クラス内のgetOneCourseメソッドを使用して実体化する必要があります。<br>
	 * menuListのsizeを返します。 <br>
	 * menuListがnullの場合やList内にobjectが存在しない場合は0を返します。
	 *
	 * @return getMenuListOneなどで使用するindexの有効範囲となるsize
	 */
	public int getMenuListSize() {
		if (menuList != null || !menuList.isEmpty())
			return this.menuList.size();
		return 0;
	}

	/**
	 * MenuBaseオブジェクトをmenuListにaddするメソッドです。<br>
	 * このMenuBaseオブジェクトはコース内のメニューの詳細情報を保管するものです。
	 *
	 * @param menuBase
	 */
	private void setMenuListAdd(MenuBase menuBase) {
		this.menuList.add(menuBase);
	}

	/**
	 * メニューリストを引数にメニューリストを代入するメソッドです。<br>
	 * たぶん使わないですが、一応jspタグで使用される可能性を考慮して作成。
	 *
	 * @deprecated
	 * @param menuList
	 */
	public void setMenuList(List<MenuBase> menuList) {
		this.menuList = menuList;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getDetail() {
		return detail;
	}

	public int getOrderFlg() {
		return orderFlg;
	}

	public int getPrice() {
		return price;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public ArrayList<Integer> getMenuIds() {
		return menuIds;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setOrderFlg(int orderFlg) {
		this.orderFlg = orderFlg;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuIds(int menuId) {
		if (menuId != 0) {
			this.menuIds.add(menuId);
		}
	}

	/**
	 * コース情報をコースIDから取得するメソッドです。<br>
	 * このメソッドではコースに含まれるメニュー情報は出力されません。
	 *
	 * @param c_Id
	 *            コースID
	 * @return メニュー情報の存在しないコーステーブルからのコース情報のCourseオブジェクト
	 * @throws IdealException
	 *             データベースにエラーが発生した際にスローします。
	 */
	public static Course getCourse(int c_Id) throws IdealException {
		String sql = "SELECT * FROM " + course.TABLE + " WHERE " + course.c_id
				+ " =?";
		try {
			return new SQL_BeanCORE<Course>(sql) {
				@Override
				protected Course query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					pst.setInt(1, c_Id);
					rs = pst.executeQuery();

					if (rs.next()) {
						Course co = new Course();
						co.setCourseId(rs.getInt(course.c_id));
						co.setCourseName(rs.getString(course.c_name));
						co.setDetail(rs.getString(course.detail));
						co.setOrderFlg(rs.getInt(course.orderFlg));
						co.setPrice(rs.getInt(course.price));
						co.setTypeId(rs.getInt(course.t_id));
						return co;
					}
					return null;
				}
			}.bean();
		} catch (NamingException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {

			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

		}
		return null;
	}

	/**
	 * コース情報をコースIDから取得するメソッドです。<br>
	 * メニューの詳細情報をmenuList内にメニュー情報を保管します。<br>
	 * 内部ソースを利用する際はgetMenuListOne()メソッドにインデックスを入れて仕様することを推奨。
	 *
	 * @param c_Id
	 *            コースID
	 * @return Course型を格納したArrayList Menu情報の詳細が取得できます。
	 * @throws IdealException
	 *             データベースにエラーが発生した際にスローします。
	 */
	public static Course getOneCourse(int c_Id) throws IdealException {

		try {
			return new SQL_BeanCORE<Course>() {

				@Override
				protected Course query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					String sql = "SELECT course.c_id,c_name,course.detail,course.orderFlg,course.price,course.t_id,"
							+ "menu.t_id,menu.m_id,m_Name FROM coursectl "
							+ "LEFT JOIN course ON coursectl.c_id = course.c_id "
							+ "LEFT JOIN menu ON coursectl.m_id = menu.m_id "
							+ "WHERE course.c_id =?";
					pst = con.prepareStatement(sql);
					pst.setInt(1, c_Id);
					rs = pst.executeQuery();

					if (rs.next()) {
						Course co = new Course();
						// returnするobject内のmenuListをここで実体化させます。
						co.menuList = new ArrayList<MenuBase>();
						co.menuMap = new HashMap<Integer, MenuBase>();

						co.setCourseId(rs.getInt(course.c_id));
						co.setCourseName(rs.getString(course.c_name));
						co.setDetail(rs.getString(course.detail));
						co.setOrderFlg(rs.getInt(course.orderFlg));
						co.setPrice(rs.getInt(course.price));
						co.setTypeId(rs.getInt(course.t_id));

						sql = "SELECT " + menu.t_id + comma + menu.m_id + comma
								+ menu.m_Name + " FROM " + coursectl.TABLE
								+ " " + "LEFT JOIN " + menu.TABLE + " USING("
								+ menu.m_id + ") " + "WHERE " + coursectl.c_id
								+ " =?";

						pst = con.prepareStatement(sql);
						pst.setInt(1, c_Id);
						rs = pst.executeQuery();
						while (rs.next()) {
							co.setMenuListAdd(new MenuBase(
									rs.getInt(menu.m_id), rs
											.getString(menu.m_Name), rs
											.getInt(menu.t_id)));
						}

						co.menuList.forEach(bs -> {
							co.menuMap.put(bs.getTypeId(), bs);

						});

						return co;
					}
					return null;

				}

			}.bean();
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return null;
	}

	/**
	 * コースを詳細
	 *
	 * @return
	 * @throws IdealException
	 */
	public static ArrayList<Course> getCourseList() throws IdealException {
		String sql = "SELECT course.c_id,c_name,course.detail,course.orderFlg,course.price,course.t_id,"
				+ "menu.t_id,menu.m_id,m_Name FROM coursectl "
				+ "LEFT JOIN course ON coursectl.c_id = course.c_id "
				+ "LEFT JOIN menu ON coursectl.m_id = menu.m_id";

		try {
			return new SQL_BeanCORE<ArrayList<Course>>(sql) {

				@Override
				protected ArrayList<Course> query(Connection con,
						PreparedStatement pst, ResultSet rs)
						throws SQLException {
					ArrayList<Course> al = new ArrayList<Course>();

					rs = pst.executeQuery();

					while (rs.next()) {
						Course co = new Course();
						co.setCourseId(rs.getInt(course.c_id));
						co.setCourseName(rs.getString(course.c_name));
						co.setDetail(rs.getString(course.detail));
						co.setOrderFlg(rs.getInt(course.orderFlg));
						co.setPrice(rs.getInt(course.price));
						co.setTypeId(rs.getInt(course.t_id));
						// co.setTypeName("コース"); // 保留
						// 分類クラスMenuType.javaからもってくる？
						co.setMenuId(rs.getInt(menu.m_id));
						co.setMenuName(rs.getString(menu.m_Name));
						al.add(co);
					}

					return al;

				}

			}.bean();
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return null;

	}

	/**
	 * オーダー可能なコースのリストを取得する処理を行います。<br>
	 * この際に詳細情報は取得されません。
	 *
	 *
	 * @return オーダー可能なコースのArrayList
	 * @throws IdealException
	 */
	public static ArrayList<Course> getOneCourseList() throws IdealException {
		String sql = "SELECT " + course.c_id + " FROM course WHERE "
				+ course.orderFlg + " = 1";
		try {
			return new SQL_BeanCORE<ArrayList<Course>>(sql) {

				@Override
				protected ArrayList<Course> query(Connection con,
						PreparedStatement pst, ResultSet rs)
						throws SQLException, IdealException {
					ArrayList<Course> al = new ArrayList<Course>();
					ArrayList<Integer> i = new ArrayList<>();

					rs = pst.executeQuery();
					while (rs.next()) {
						i.add(rs.getInt(course.c_id));
					}
					for (Integer c : i) {

						al.add(Course.getOneCourse(c));
					}
					return al;
				}
			}.bean();
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return null;

	}

	/**
	 * 使用用途不明 タイプIDからコースのリストを取得します。<br>
	 * コースはIDが100しか存在しないので今回はなかったことになりそうです。
	 *
	 * @deprecated
	 * @param t_Id
	 * @return
	 * @throws IdealException
	 */
	public static ArrayList<Course> getTypeCourseList(int t_Id)
			throws IdealException {
		String sql = "SELECT c_id,c_name,detail,orderFlg,price,t_name FROM course "
				+ "LEFT JOIN menutype ON course.t_id = menutype.t_id "
				+ "WHERE course.t_id=?  ORDER BY c_id ASC";
		try {
			return new SQL_BeanCORE<ArrayList<Course>>(sql) {

				@Override
				protected ArrayList<Course> query(Connection con,
						PreparedStatement pst, ResultSet rs)
						throws SQLException {
					ArrayList<Course> al = new ArrayList<Course>();
					pst.setInt(1, t_Id);

					rs = pst.executeQuery();
					while (rs.next()) {
						Course co = new Course();
						co.setCourseId(rs.getInt(course.c_id));
						co.setCourseName(rs.getString(course.c_name));
						co.setDetail(rs.getString(course.detail));
						co.setOrderFlg(rs.getInt(course.orderFlg));
						co.setPrice(rs.getInt(course.price));
						co.setTypeName(rs.getString(menutype.t_name));
						al.add(co);
					}

					return al;
				}

			}.bean();
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
		return null;
	}

	public static int updateCourse(Course c, int mode) throws IdealException {

		try {
			return new SQL_BeanCORE<Integer>(false) {

				@Override
				protected Integer query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException, IdealException {

					if (mode == CourseOperationSvl.INSERT) {
						if (c.getMenuIds().isEmpty()) {
							throw new IdealException(
									IdealException.ERR_NO_SERVER);
						}

						String sql = "INSERT INTO course (c_name,detail,orderFlg,price,t_id) "
								+ "VALUES(?,?,?,?,100)";

						pst = con.prepareStatement(sql);
						pst.setString(1, c.getCourseName());
						pst.setString(2, c.getDetail());
						pst.setInt(3, c.getOrderFlg());
						pst.setInt(4, c.getPrice());
						pst.executeUpdate();

						sql = "SELECT LAST_INSERT_ID()";

						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						int courseId;
						if (rs.next()) {
							courseId = rs.getInt(1);
						} else {
							System.out
									.println("ラストインサートIDをcourseで実行して失敗している可能性");
							throw new SQLException();
						}
						c.setCourseId(courseId);
						sql = "INSERT INTO coursectl VALUES ";
						sql = getQuery(c, sql);
						pst.executeUpdate(sql);
						con.commit();
						return courseId;

					} else if (mode == CourseOperationSvl.UPDATE) {
						if (c.getMenuIds().isEmpty())
							return 0;
						int courseId = c.getCourseId();
						String sql = "UPDATE course SET c_name =?,detail =?,orderFlg =?,price =? WHERE c_id =?";
						System.out.println(pst);

						pst = con.prepareCall(sql);
						pst.setString(1, c.getCourseName());
						pst.setString(2, c.getDetail());
						pst.setInt(3, c.getOrderFlg());
						pst.setInt(4, c.getPrice());
						pst.setInt(5, courseId);
						System.out.println(pst);
						pst.executeUpdate();

						sql = "DELETE FROM coursectl WHERE c_id = ?";

						pst = con.prepareStatement(sql);
						pst.setInt(1, courseId);
						pst.executeUpdate();

						sql = "INSERT INTO coursectl VALUES ";
						sql = getQuery(c, sql);
						System.out.println(sql);
						pst.executeUpdate(sql);
						con.commit();
						return courseId;

					} else if (mode == CourseOperationSvl.DELETE) {
						String sql = "DELETE FROM coursectl WHERE "
								+ course.c_id + " = ?";
						pst = con.prepareStatement(sql);
						pst.setInt(1, c.courseId);
						System.out.println(pst);
						pst.executeUpdate();
						sql = "DELETE FROM course WHERE " + course.c_id
								+ " = ?";
						pst = con.prepareStatement(sql);
						pst.setInt(1, c.courseId);
						System.out.println(pst);
						pst.executeUpdate();

						con.commit();
						return c.courseId;

					}
					return 0;
				}
			}.bean();
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}

		return 0;
	}

	private static String getQuery(Course c, String sql) {
		StringBuilder reSql = new StringBuilder(sql);
		int courseId = c.getCourseId();

		for (int i : c.getMenuIds()) {

			reSql.append('(');
			reSql.append(courseId);
			reSql.append(',');
			reSql.append(i);
			reSql.append("),");
		}

		reSql.setLength(reSql.length() - 1);
		return reSql.toString();

	}

}
