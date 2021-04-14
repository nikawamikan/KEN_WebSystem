package general;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.IdealException;

/**
 *
 * 共通した処理を定型的に処理して変更点のみを抽象的に定義した抽象クラスです。<br>
 * ジェネリクスで戻り型を指定する事ができます。複数の結果が予想される場合はジェネリクスにVoidクラスを定義します<br>
 * 本クラスはInitialContextクラスとDataSourceクラスを利用しており、DBの情報はMETA-INFにあるcontext.
 * xmlファイルで定義しなくてはなりません<br>
 * Connection、PreparedStatement、ResultSetは自動でclose処理を実行しますので実装時に記述の必要性はありません<br>
 * 使用時はConnectionオブジェクトのprepareStatement(String);
 * メソッド引数に本クラスのInstance生成時の引数のString型のsqlを使用してPreparedStatement オブジェクトを生成しています。<br>
 * ですので、executeUpdate();などのメソッドはそのまま実行する事が可能になっています。<br>
 * ResultSetはnullの状態で抽象クラスに渡しているのでrs = pst.executeQuery();などで使用可能にする必要があります。
 * 注意としては、匿名クラスを利用して使用する場合はメソッド内での変数はFinal及び変更のない変数であれば使用可能ですが、<br>
 * 条件式や、変更を伴う変数を利用する場合は使用する事が不可能です。<br>
 * Connectionメソッドを引数とすることでロールバックやクエリの変更に対応させました。<br>
 * コンストラクタを生成する際に第二引数にfalseを代入する事でAutoCommitが無効になります。<br>
 * Closeの直前にrollbackメソッドを使用している為、明示的にCommitしていない限りはUpdateされません。
 *
 * @author Kamishiro
 * @version 0.3 Connectionクラスobjectを使用する為に(
 *          ２回以上クエリを送る際に弊害があった)queryメソッドの引数にConnectionを定義しました。
 *
 */
public abstract class SQL_BeanCORE<T> {

	private boolean commit = true;
	private String sql;

	/**
	 * Beanを実行するためのクラスです。<br>
	 * PreparedStatementで使用する為のsqlを引数としています。
	 *
	 * @param sql
	 *            "SELECT ?,? FROM table" などの文字列
	 */
	public SQL_BeanCORE(String sql) {
		this.sql = sql;
	}

	public SQL_BeanCORE() {
		this.sql = "";
	}
	public SQL_BeanCORE(boolean commit) {
		this.sql = "";
		this.commit = commit;
	}

	/**
	 * Beanを実行するためのクラスです。<br>
	 * PreparedStatementで使用する為のsqlを引数としています。
	 *
	 * @param sql
	 *            "SELECT ?,? FROM table" などの文字列
	 */
	public SQL_BeanCORE(String sql, boolean commit) {
		this.commit = commit;
		this.sql = sql;
	}

	// abstractな実際の処理内容を記載するところです。例外をthrowsしとくのがポイント
	abstract protected T query(Connection con, PreparedStatement pst,
			ResultSet rs) throws SQLException,IdealException;

	/**
	 * 実行用クラスです。ジェネリクスによりreturnするobjectを指定する事が可能です。
	 *
	 * @return ジェネリクスで指定された型のオブジェクト
	 * @throws NamingException
	 *             InitialContextを使用時に発生する例外がスローされます。
	 * @throws SQLException
	 *             SQLを使用した際に構文などに誤りがある場合に例外がスローされます。
	 */
	public T bean() throws NamingException, SQLException ,IdealException{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			con.setAutoCommit(commit);
			if (!this.sql.equals(""))
				pst = con.prepareStatement(this.sql);

			// 実際の処理をここで記述する事になる
			return query(con, pst, rs);

		} finally {
			if (con != null) {
				if (!commit) {
					con.rollback();
				}
				con.close();
			}
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
		}
	}
}
