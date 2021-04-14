package model;

import general.PasswordUtil;
import general.SQL_BeanCORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * ユーザのログイン登録等の処理を行うBeanクラスです。<br>
 *
 * @author たぶん佐々木
 *
 */
public class User {

	public User(int usrId, String usrName, String password, String address,
			String phone, String mail, String exp) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.exp = exp;
	}

	public User() {
	}


	private int usrId;
	private String usrName;
	private String password;
	private String newPassword;
	private String zipcode;
	private String address;
	private String phone;
	private String mail;
	private String exp;


	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getUsrId() {
		return usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}

	public String getExp() {
		return exp;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * ユーザーＩＤとパスワードの整合性をチェックしてユーザーobjectを返すメソッドです。
	 *
	 * @param mail
	 *            ログインしたいユーザーID
	 * @param password
	 *            ログインしたいユーザーのパスワード
	 * @return 整合性がとれた場合はUserの詳細情報を記述したUserオブジェクトを返します。
	 * @throws IdealException
	 *             データベースに例外が発生した場合にスローされます。
	 */
	public static User login(String mail, String password)
			throws IdealException {

		String sql = "SELECT usr_id,usr_name FROM user WHERE mail=? AND password=?";
		try {
			return new SQL_BeanCORE<User>(sql) {

				@Override
				protected User query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {

					String hashPass = PasswordUtil.getSafetyPassword(password,
							mail);

					pst.setString(1, mail);
					pst.setString(2, hashPass); // loginメソッドの引数
					// System.out.print(pst);
					rs = pst.executeQuery();

					if (rs.next()) {
						User us = new User();
						us.setUsrId(rs.getInt("usr_id"));
						us.setUsrName(rs.getString("usr_name"));
						return us;
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
	 * ユーザーIDからユーザー情報を取得するメソッドです。
	 *
	 * @param usr_Id
	 *            取得したいユーザーID
	 * @return ユーザーの詳細情報を格納したUserobject
	 * @throws IdealException
	 *             データベースに例外が発生した場合にスローされます。
	 */
	public static User getUser(int usr_Id) throws IdealException {

		String sql = "SELECT * FROM user WHERE usr_id=? ";
		try {
			return new SQL_BeanCORE<User>(sql) {

				@Override
				protected User query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					pst.setInt(1, usr_Id);
					rs = pst.executeQuery();
					if (rs.next()) {
						User us = new User();
						us.setUsrId(rs.getInt("usr_id"));
						us.setUsrName(rs.getString("usr_name"));
						us.setPassword(rs.getString("password"));
						us.setZipcode(rs.getString("zipcode"));
						us.setAddress(rs.getString("address"));
						us.setPhone(rs.getString("phone"));
						us.setMail(rs.getString("mail"));
						us.setExp(rs.getString("exp"));
						return us;
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
	 * ユーザー情報を新規登録するメソッドです。<br>
	 * Userobjectを引数として登録します。
	 *
	 * @param user
	 *            個人情報が記載されたUserオブジェクト
	 * @return userID情報を追加で取得したUserオブジェクト
	 * @throws IdealException
	 *             データベースに例外が発生した場合にスローされます。
	 */
	public static User insert(User user) throws IdealException {

		String sql = "INSERT INTO user VALUES( DEFAULT,?,?,?,?,?,?,DEFAULT)";

		try {
			return new SQL_BeanCORE<User>(sql) {

				@Override
				protected User query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					User us = new User();

					us.setUsrName(user.getUsrName());

					String hashPass = PasswordUtil.getSafetyPassword(
							user.password, user.mail);
					pst.setString(1, user.getUsrName());
					pst.setString(2, hashPass);
					pst.setString(3, user.getZipcode());
					pst.setString(4, user.getAddress());
					pst.setString(5, user.getPhone());
					pst.setString(6, user.getMail());

					pst.executeUpdate();

					String sql2 = null;
					sql2 = "SELECT LAST_INSERT_ID()";
					pst = con.prepareStatement(sql2);
					rs = pst.executeQuery();
					if (rs.next()) {
						us.setUsrId(rs.getInt(1));
					}
					return us;

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
	 * user情報を更新するメソッドです。<br>
	 * 更新処理のされたuserオブジェクトを引数にデータベースを更新します。
	 *
	 * @param user
	 *            更新された情報のUserオブジェクト
	 * @return 入力されたUserそのまま返します。データベースにエラーが生じた際にNullを返します。
	 * @throws IdealException
	 *             データベースにエラーが生じた際にスローします。
	 */
	public static User update(User user) throws IdealException {

		try {
			return new SQL_BeanCORE<User>() {

				@Override
				protected User query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException {
					String sql = "UPDATE user SET  usr_name=?,password =?,zipcode =?,address =?,phone =?,mail =? WHERE usr_id =?";
					if (user.getNewPassword().equals("")) {

						String hashPass = PasswordUtil.getSafetyPassword(
								user.password, user.mail);

						pst = con.prepareStatement(sql);
						pst.setString(1, user.getUsrName());
						pst.setString(2, hashPass);
						pst.setString(3, user.getZipcode());
						pst.setString(4, user.getAddress());
						pst.setString(5, user.getPhone());
						pst.setString(6, user.getMail());
						pst.setInt(7, user.getUsrId());
						System.out.println(pst);

						pst.executeUpdate();

					} else {
						pst = con.prepareStatement(sql);

						String hashPass = PasswordUtil.getSafetyPassword(
								user.newPassword, user.mail);

						pst = con.prepareStatement(sql);
						pst.setString(1, user.getUsrName());
						pst.setString(2, hashPass);
						pst.setString(3, user.getZipcode());
						pst.setString(4, user.getAddress());
						pst.setString(5, user.getPhone());
						pst.setString(6, user.getMail());
						pst.setInt(7, user.getUsrId());
						System.out.println(pst);

						pst.executeUpdate();
					}
					User us = new User();
					us.setUsrId(user.getUsrId());
					us.setUsrName(user.getUsrName());
					return (us);

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
	 * データベースからuser情報を削除するメソッドです。
	 *
	 * @param user
	 *            ユーザーIDが入力されたUserオブジェクト
	 * @throws IdealException
	 *             データベースに例外が発生した際にスローされます。
	 */
	public static void delete(User user) throws IdealException {
		// 予約を削除
		String sql = "DELETE FROM reserve WHERE usr_id =?";
		try {
			new SQL_BeanCORE<Void>(sql, false) {
				@Override
				protected Void query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException, IdealException {

					if (!Reserve.getReserveList(user.getUsrId(), true)
							.isEmpty()) {
						throw new IdealException(IdealException.ERR_NO_USER_DELETE);
					}

					pst.setInt(1, user.getUsrId());
					pst.executeUpdate();

					pst = con
							.prepareStatement("DELETE FROM user WHERE usr_id =?");
					pst.setInt(1, user.getUsrId());
					pst.executeUpdate();
					con.commit();
					return null;
				}
			}.bean();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}
	}
	public static boolean checkmail(String mail) throws IdealException {
		return checkmail(mail,0);
	}

	/**
	 * メールアドレスが登録可能な場合はtrueを返します。
	 *
	 * @param user
	 *            メールアドレスが存在しているuserオブジェクト。
	 * @return 登録可能な場合はtrue、不可能な場合はfalseを返します。
	 * @throws IdealException
	 *             データベース例外が発生したときにスローされます。
	 */
	public static boolean checkmail(String mail,int userId) throws IdealException {
		String add="";
		if(userId!=0){
			add="AND NOT usr_id ="+userId;
		}
		String sql = "SELECT mail FROM user WHERE mail=? "+add;
		try {
			return new SQL_BeanCORE<Boolean>(sql) {

				@Override
				protected Boolean query(Connection con, PreparedStatement pst,
						ResultSet rs) throws SQLException, IdealException {
					pst.setString(1, mail);
					System.out.println(pst);
					rs = pst.executeQuery();
					boolean res = !rs.next();
					if (!res) {
						throw new IdealException(
								IdealException.ERR_NO_MAIL_DOUBLING);
					}
					return res;
				}

			}.bean();
		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

		}
		return false;

	}
}
