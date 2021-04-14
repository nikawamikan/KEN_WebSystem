package model;

import general.SQL_BeanCORE;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * 管理者ログイン系のBeanクラスです。<br>
 * 管理者がログインした場合に管理者のオブジェクトをsessionに格納する時などに使用されます。<br>
 *
 *
 * @author A37
 *
 */
public class Admin implements Serializable, TableInter {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String admName;
	private String password;
	private String exp;

	public Admin() {
		super();
	}

	public String getAdmName() {
		return admName;
	}

	public String getPassword() {
		return password;
	}

	public String getExp() {
		return exp;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * 管理者がログインした場合に管理者オブジェクトを作成して返却するメソッドです。<br>
	 *
	 * @param admName 管理者の名前
	 * @param password 管理者名に対応したパスワード
	 * @return ログインした管理者の情報を記録したAdminオブジェクト
	 * @throws IdealException データベースに障害が発生した際にスローされます。
	 */
	public static Admin login(String admName, String password)
			throws IdealException {
		String sql = "SELECT * FROM " + admin.TABLE + " WHERE "
				+ admin.adm_name + "=? AND " + admin.password + "=?";
		try {
			return new SQL_BeanCORE<Admin>(sql) {

				@Override
				protected Admin query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					pst.setString(1, admName);
					pst.setString(2, password);
					rs = pst.executeQuery();
					if (rs.next()) {
						Admin ad = new Admin();
						ad.setAdmName(rs.getString(admin.adm_name));
						ad.setPassword(rs.getString(admin.password));
						return ad;
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
}
