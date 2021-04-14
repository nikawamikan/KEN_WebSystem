package model;

import general.SQL_BeanCORE;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

public class MenuType implements Serializable,TableInter {

	private static final long serialVersionUID = 1L;
	private int typeID;
	private String typeName;

	public int getTypeID() {
		return typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * メニュータイプのリストを出力するメソッドです。<br>
	 * メニュータイプIDとメニュータイプの名前を保存してArrayListとして出力します。
	 * @return メニュータイプオブジェクトを保存したArrayList
	 * @throws IdealException データベースにエラーが発生した場合にスロー
	 */
	public static ArrayList<MenuType> getAllType() throws IdealException {

		String sql = "SELECT * FROM "+menutype.TABLE+" ORDER BY "+menutype.t_id;
		try {
			return new SQL_BeanCORE<ArrayList<MenuType>>(sql) {

				@Override
				protected ArrayList<MenuType> query(Connection con,PreparedStatement pst,
						ResultSet rs) throws SQLException {
					ArrayList<MenuType> al = new ArrayList<MenuType>();
					rs = pst.executeQuery();
					while (rs.next()) {
						MenuType mt = new MenuType();
						mt.setTypeID(rs.getInt(menutype.t_id));
						mt.setTypeName(rs.getString(menutype.t_name));
						al.add(mt);
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
	 * メニュータイプのマップを出力するメソッドです。<br>
	 * メニュータイプIDキーとしてメニュータイプの名前を保存してMapとして出力します。
	 * @return IDをキーとしてString型を返すMap型object
	 * @throws IdealException データベースにエラーが発生した場合にスロー
	 */
	public static Map<Integer,String> getAllTypeMap() throws IdealException {

		String sql = "SELECT * FROM "+menutype.TABLE+" ORDER BY "+menutype.t_id;
		try {
			return new SQL_BeanCORE<Map<Integer,String>>(sql) {

				@Override
				protected Map<Integer,String> query(Connection con,PreparedStatement pst,
						ResultSet rs) throws SQLException {
					Map<Integer, String> map = new HashMap<>();
					rs = pst.executeQuery();
					while (rs.next()) {
						map.put(rs.getInt(menutype.t_id),rs.getString(menutype.t_name));
					}
					return map;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
		return null;
	}
}
