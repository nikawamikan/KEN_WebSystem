package model;
/**
 *
 * 独自例外クラス<br>
 * 主にBeanクラスで特定の条件でthrowする様に設計します。<br>
 * その際に当クラスのエラーメッセージ番号を引数にする事で特定のエラーメッセージを表示させる事が可能です。
 * @author 佐々木
 *
 */
public class IdealException extends Exception{
	/**
	 */
	private static final long serialVersionUID = 3L;
	private int errCd;
	private static String ERR_MSG[] ={"障害が発生しました。",
		                              "データベース処理で例外が発生しました。",
		                              "お客様ID、パスワードを確認してください。",
		                              "管理者名、パスワードを確認してください。",
		                              "ご指定された日時に空席がありませんでした。",
		                              "予約されているコースなので削除できません。",
		                              "コースに登録されているメニューなので削除できません。",
		                              "サーバーエンジニアが必要なエラーです。",
		                              "このアドレスは既に使用されています。",
		                              "セッションが切れています。再度ログインをしてください。",
		                              "現在このアカウントでは本日以降の予約が存在している為、削除できません。",
		                              "メールアドレスの記述が正しくありません。"
	};
	/**
	 * エラーメッセージ「障害が発生しました。」を表示
	 */
	public static int ERR_NO_EXCEPTION =0;
	/**
	 * エラーメッセージ「データベース処理で例外が発生しました。」を表示
	 */
	public static int ERR_NO_DB_EXCEPTION =1;
	/**
	 * エラーメッセージ「お客様ID、パスワードを確認してください。」を表示
	 */
	public static int ERR_NO_NOT_MEMBER_EXCEPTION =2;
	/**
	 * エラーメッセージ「管理者名、パスワードを確認してください。」を表示
	 */
	public static int ERR_NO_ADMIN_EXCEPTION =3;
	/**
	 * エラーメッセージ「ご指定された日時に空席がありませんでした。」を表示
	 */
	public static int ERR_NO_NOT_VACANCY =4;
	/**
	 * エラーメッセージ「予約されているコースなので削除できません。」を表示
	 */
	public static int ERR_NO_NOT_RESERV_DELETE =5;
	/**
	 * エラーメッセージ「コースに登録されているメニューなので削除できません。」を表示
	 */
	public static int ERR_NO_NOT_MENU_DELETE =6;

	/** エラーの中でも構文に重大なミスがある場合に表示させる（デバック用） */
	public static int ERR_NO_SERVER =7;

	/** 既に登録してあるメールアドレスが入力された時に表示 */
	public static int ERR_NO_MAIL_DOUBLING =8;

	/** セッション切れを告知するためのメッセージ */
	public static int ERR_NO_SESSION_NULL =9;

	/** 本日以降の予約が存在する顧客に対して予約をキャンセルしてからアカウントを削除していただくシステム(ドタキャン対策) */
	public static int ERR_NO_USER_DELETE =10;

	/** Mailの正規表現に間違いがある場合にスローします */
	public static int ERR_NO_MAIL_REGEX =11;


	public IdealException(int errCd){
		this.errCd = errCd;

	}

	public IdealException(){
		this.errCd = 0;
	}

	public String getMsg(){
		return ERR_MSG[this.errCd];
	}
}
