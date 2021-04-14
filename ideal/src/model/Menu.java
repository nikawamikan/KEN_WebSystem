package model;

import general.SQL_BeanCORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import controller.MenuOperationSvl;

public class Menu extends MenuBase implements TableInter {
	private String detail;
	private int orderFlg;
	private int price;
	private String typeName;

	public Menu() {
		super();
	}

	public Menu(int menuId, String menuName, int typeId, String detail, int orderFlg, int price, String typeName) {
		super(menuId, menuName, typeId);
		setDetail(detail);
		setOrderFlg(orderFlg);
		setPrice(price);
		setTypeName(typeName);

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

	public String getTypeName() {
		return typeName;
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

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * メニューIDとTypeIDを入力してメニューTypeIDからコース料理か一品料理かを判定して<br>
	 * メニュー型のオブジェクトを返します。
	 *
	 * @param menuID メニューのＩＤ
	 * @param typeID タイプのＩＤ
	 * @return メニュー又はコース情報を保存したMenuオブジェクト
	 * @throws IdealException データベースに例外が発生した場合にスローされます。」
	 */
	public static Menu getOneMenu(int menuID, int typeID) throws IdealException {

		String temptable = menu.TABLE;
		String tempkeyColumn = menu.m_id;
		String tempname = menu.m_Name;

		if (typeID == 100) {
			temptable = course.TABLE;
			tempkeyColumn = course.c_id;
			tempname = course.c_name;
		}
		String table = temptable;
		String keyColumn = tempkeyColumn;
		String name = tempname;

		String sql = "SELECT * FROM " + table + " JOIN " + menutype.TABLE + " USING(" + menutype.t_id + ") WHERE "
				+ keyColumn + "=? ORDER BY " + keyColumn;
		try {
			return new SQL_BeanCORE<Menu>(sql) {

				@Override
				protected Menu query(Connection con, PreparedStatement pst, ResultSet rs) throws SQLException {
					pst.setInt(1, menuID);
					rs = pst.executeQuery();
					if (rs.next()) {
						Menu mn = new Menu();
						mn.setMenuId(rs.getInt(keyColumn));
						mn.setMenuName(rs.getString(name));
						mn.setDetail(rs.getString(menu.detail));
						mn.setOrderFlg(rs.getInt(menu.orderFlg));
						mn.setPrice(rs.getInt(menu.price));
						mn.setTypeId(rs.getInt(menutype.t_id));
						mn.setTypeName(rs.getString(menutype.t_name));
						return mn;
					} else {
						return null;
					}

				}
			}.bean();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * コースを設定するクラスで、コースに設定するmenu一覧を取得します。 <br>
	 * MenuInsertSvlでtypeIDが100のときに使用
	 *
	 * @return menu型の ArrayListをArrayListにしたすべてのメニューを取得します。
	 * @throws IdealException データベースで例外が発生した場合にスローします。
	 */
	public static ArrayList<ArrayList<Menu>> getAllMenu() throws IdealException {

		ArrayList<ArrayList<Menu>> alMenu = new ArrayList<>();
		String sql = "SELECT " + menutype.t_id + " FROM " + menutype.TABLE + " WHERE NOT " + menutype.t_id + "=100";// t_id100以外を抽出
		try {
			return new SQL_BeanCORE<ArrayList<ArrayList<Menu>>>(sql) {

				@Override
				protected ArrayList<ArrayList<Menu>> query(Connection con, PreparedStatement pst, ResultSet rs)
						throws SQLException {
					// int型のArrayList "al"を生成
					ArrayList<Integer> al = new ArrayList<>();
					rs = pst.executeQuery();

					while (rs.next()) {
						// "al"にDBの1列目(t_id)の値をすべて追加格納 200,210,,,,
						al.add(rs.getInt(1));
					}
					for (Integer integer : al) {
						try {
							// ArrayList<ArrayList<Menu>>の"alMenu"に、"al"に格納されたt_idの値を、getMenuメソッドを使って追加格納
							// "al"に入っている値の数だけfor文で追加
							alMenu.add(getMenu(integer));
						} catch (IdealException e) {
							throw new SQLException();
						}
					}
					return alMenu;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
		return alMenu;

	}

	/**
	 * オーダー可能なメニュー情報を分類ID、メニューＩＤで昇順取得し、menu型のArrayListに格納して返却します。
	 *
	 * @return オーダー可能なメニューリスト
	 * @throws IdealException データベースにエラーが発生した場合にスローします。
	 */
	public static ArrayList<Menu> getMenuList() throws IdealException {
		String sql = "SELECT * FROM " + menu.TABLE + " JOIN " + menutype.TABLE + " USING(" + menutype.t_id + ") WHERE "
				+ menu.orderFlg + " = 1 ORDER BY " + menu.m_id + " , " + menu.t_id;
		try {
			return new SQL_BeanCORE<ArrayList<Menu>>(sql) {

				@Override
				protected ArrayList<Menu> query(Connection con, PreparedStatement pst, ResultSet rs)
						throws SQLException, IdealException {

					ArrayList<Menu> al = new ArrayList<Menu>();

					rs = pst.executeQuery();

					while (rs.next()) {
						Menu mn = new Menu();
						mn.setMenuId(rs.getInt(menu.m_id));// 変更
						mn.setMenuName(rs.getString(menu.m_Name));// 変更
						mn.setDetail(rs.getString(menu.detail));
						mn.setPrice(rs.getInt(menu.price));
						mn.setTypeId(rs.getInt(menu.t_id));
						mn.setTypeName(rs.getString(menutype.t_name));
						mn.setOrderFlg(rs.getInt(menu.orderFlg));
						al.add(mn);
					}

					return al;
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
	 * MenuMaintenanceSvlで、リクエストスコープ「menu」に、Menuクラス型のArrayListとしてセットする際に使用<br>
	 *
	 * @param typeID
	 * @return
	 * @throws IdealException
	 */
	public static ArrayList<Menu> getMenu(int typeID) throws IdealException {
		String table = menu.TABLE;
		if (typeID == 100) {
			table = course.TABLE;
		}

		String sql = "SELECT * FROM " + table + " JOIN " + menutype.TABLE + " USING(" + menutype.t_id + ") WHERE "
				+ menutype.t_id + " =? ORDER BY 2";
		try {
			return new SQL_BeanCORE<ArrayList<Menu>>(sql) {

				@Override
				protected ArrayList<Menu> query(Connection con, PreparedStatement pst, ResultSet rs)
						throws SQLException {

					int tId = typeID;
					String id = menu.m_id;
					String name = menu.m_Name;
					if (typeID == 100) {
						id = course.c_id;
						name = course.c_name;
					}

					ArrayList<Menu> al = new ArrayList<Menu>();

					pst.setInt(1, tId); // getOneMenuメソッドの引数
					rs = pst.executeQuery();

					while (rs.next()) {
						Menu mn = new Menu();
						mn.setMenuId(rs.getInt(id));// 変更
						mn.setMenuName(rs.getString(name));// 変更
						mn.setDetail(rs.getString(menu.detail));
						mn.setPrice(rs.getInt(menu.price));
						mn.setTypeId(tId);
						mn.setTypeName(rs.getString(menutype.t_name));
						mn.setOrderFlg(rs.getInt(menu.orderFlg));
						al.add(mn);
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
	 * 仕様変更。返り値のint型を使用しない為void型として使用する。
	 *
	 * @param m    Menu型オブジェクト 使用する
	 * @param mode
	 * @throws IdealException
	 */
	public static void updateMenu(Menu m, int mode) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;

		String sql = "";
		String table = "";
		String keyColumn = "";
		String name = "";

		if (m.getTypeId() == 100) {
			table = "course";
			keyColumn = "c_id";
			name = "c_name";
		} else {
			table = "menu";
			keyColumn = "m_id";
			name = "m_name";
		}
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			if (mode == MenuOperationSvl.INSERT) {
				sql = "INSERT INTO " + table + " VALUES( DEFAULT,?,?,?,?,?)";

				pst = con.prepareStatement(sql);
				pst.setString(1, m.getMenuName());
				pst.setString(2, m.getDetail());
				pst.setInt(3, m.getOrderFlg());
				pst.setInt(4, m.getPrice());
				pst.setInt(5, m.getTypeId());
				pst.executeUpdate();

			} else if (mode == MenuOperationSvl.UPDATE) {
				sql = "UPDATE " + table + " SET " + name + " =?,detail=?,orderFlg=?, price=?,t_id=? WHERE " + keyColumn
						+ " =?";

				pst = con.prepareStatement(sql);
				pst.setString(1, m.getMenuName());
				pst.setString(2, m.getDetail());
				pst.setInt(3, m.getOrderFlg());
				pst.setInt(4, m.getPrice());
				pst.setInt(5, m.getTypeId());
				pst.setInt(6, m.getMenuId());
				// debug pst query check
				System.out.println(pst);
				pst.executeUpdate();

			} else if (mode == MenuOperationSvl.DELETE) {
				sql = "DELETE FROM " + table + " WHERE " + keyColumn + " =?";

				pst = con.prepareStatement(sql);
				pst.setInt(1, m.getMenuId());
				pst.executeUpdate();
			}

		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




public static ArrayList<Menu> getOneMenuList() throws IdealException {
	String sql = "SELECT  + menu.t_id +  FROM menu WHERE  menu.orderFlg = 1";
	try {
		return new SQL_BeanCORE<ArrayList<Menu>>(sql) {

			@Override
			protected ArrayList<Menu> query(Connection con,
					PreparedStatement pst, ResultSet rs)
					throws SQLException, IdealException {
				ArrayList<Menu> al = new ArrayList<Menu>();
				ArrayList<Integer> i = new ArrayList<>();

				rs = pst.executeQuery();
				while (rs.next()) {
					i.add(rs.getInt(menu.m_id));
				}
				for (Integer m : i) {
					//addAllでまとめて追加
					al.addAll(Menu.getMenu(m));
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
}
