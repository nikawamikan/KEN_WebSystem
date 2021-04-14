package general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

// 2014-04-23 15:26:50

/**
 * SQLでTIMESTAMPやDATETIMEを取得する際や、Int型で入力された日付をTIMESTAMPで使用されるフォーマットに正規化するクラスです。<br>
 * 予約システムで使用される為、準備時間の前時間30分と後ろ時間2時間30分を計算したものを出力する事が可能です。
 *
 * @author Kamishiro
 *
 */
public class ReserveDate {


	/**
	 * Instance生成時に引数とした情報をもとに計算されたafterの時間を出力します。
	 *
	 * @return String型でMySQLのTIMESTAMP形式の文字列
	 */
	public String getAfterTime() {
		return afterTime;
	}

	/**
	 * Instance生成時に引数とした情報をもとに計算されたbeforeの時間を出力します。
	 *
	 * @return String型でMySQLのTIMESTAMP形式の文字列
	 */
	public String getBeforeTime() {
		return beforeTime;
	}

	/**
	 * オブジェクト型を出力して内部メソッドのgetAfterTime()やgetBeforeTime()メソッドを使用して<br>
	 * 予約時間をMySQLのTIMESTAMP形式で前の時間とあとの時間を出力する為に使用するメソッドです。<br>
	 * 年、月、日、時、分 をInt型で引数としています。
	 *
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @param hour
	 *            時
	 * @param min
	 *            分
	 * @return フィールドにafterTime,beforeTimeを保存したCommonDate型
	 */
	public static ReserveDate getInstanceReserve(int year, int month, int day,
			int hour, int min) {
		return new ReserveDate(getCalender(year, month, day, hour, min));
	}

	/**
	 * オブジェクト型を出力して内部メソッドのgetAfterTime()やgetBeforeTime()メソッドを使用して<br>
	 * 予約時間をMySQLのTIMESTAMP形式で前の時間とあとの時間を出力する為に使用するメソッドです。<br>
	 * TIMESTAMP形式のString型を引数としています。。
	 *
	 * @param timeStamp
	 *            String型でTimeStamp型を出力します。
	 * @return フィールドにafterTime,beforeTimeを保存したCommonDate型
	 */
	public static ReserveDate getInstanceReserve(String timeStamp) {
		ArrayList<Integer> dateArray = getDateIntArray(timeStamp);
		return getInstanceReserve(dateArray.get(0), dateArray.get(1),
				dateArray.get(2), dateArray.get(3), dateArray.get(4));
	}

	/**
	 * 現日時を取得して予約可能な日付を出力するためのgetInstanceです。
	 *
	 * @return フィールドにafterTime,beforeTimeを保存したCommonDate
	 */
	public static ReserveDate getInstanceAfterYear() {
		return new ReserveDate();
	}

	/**
	 * MySQLにおけるTIMESTAMP形式の文字列をInteger型のArrayListに直して出力します。<br>
	 * ArrayListに格納する際のindex番号は[ 0年 1月 2日 3時 4分 5秒 ]という状態で保管されています。
	 *
	 * @param timeStamp
	 *            MySQLで使用されるTIMESTAMPやDATETIMEなどの形式の文字列を入力します。
	 * @return Integer型で日時を格納したArrayListを出力します
	 */
	public static ArrayList<Integer> getDateIntArray(String timeStamp) {

		final String DATE_REGEX = "[- :.]";
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		String[] stringArray = timeStamp.split(DATE_REGEX);
		for (String string : stringArray) {
			intArray.add(Integer.parseInt(string));
		}
		return intArray;
	}

	/**
	 * 入力されたInt型をMySQLにおけるTIMESTAMP形式に直してString型で出力します。
	 *
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @param hour
	 *            時
	 * @param min
	 *            分
	 * @return TIMESTAMP形式の文字列
	 */
	public static String getTimeStamp(int year, int month, int day, int hour,
			int min) {
		return formatDate(getCalender(year, month, day, hour, min));
	}

	/**
	 * 今日の日付を0時0分0秒で取得するメソッドです。出力されるフォーマットはString型でTIMESTAMP形式です。
	 * @return 今日の日付
	 */
	public static String getToday(){
		return formatDate(cutHMS(Calendar.getInstance()));
	}
	/**
	 * 翌日以降の日付を0時0分0秒で取得するメソッドです。出力されるフォーマットはString型でTIMESTAMP形式です。
	 * @param 加算したい日数
	 *
	 * @return 翌日の日付
	 */
	public static String getToday(int date){
		Calendar calendar= Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,date);
		return formatDate(cutHMS(calendar));
	}
	public static String getNow(){
		return formatDate(Calendar.getInstance());
	}

	// ---------------------------- private -------------------------------

	/** 予約時間からの前時間 */
	private String afterTime;

	/** 予約時間からの後ろ時間 */
	private String beforeTime;

	// getInstanceで取得するのでコンストラクタは使用不能です
	private ReserveDate(Calendar calendar) {
		beforeTime = timeReturnCore(calendar, Calendar.MINUTE, -30);
		afterTime = timeReturnCore(calendar, Calendar.MINUTE, 180);
	}

	// 予約日時を取得する為のコンストラクタ
	private ReserveDate() {
		Calendar calendar =Calendar.getInstance();
		if(calendar.get(Calendar.AM_PM)==Calendar.PM){
			calendar.add(Calendar.DATE, 1);
		}
		calendar = cutHMS(calendar);
		beforeTime = formatDate(calendar);
		afterTime = timeReturnCore(calendar, Calendar.YEAR, 1);
	}

	// 文字列型に直す為に一時的に使用するカレンダーを取得するためのメソッド
	private static Calendar getCalender(int year, int month, int day, int hour,
			int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day, hour, min);
		return calendar;
	}

	// 入力された日付情報からString型でMySQLにおけるTIMESTAMP形式のカレンダーをString型に直して出力するメソッド群

	private static String timeReturnCore(Calendar calendar, int type, int minute) {
		calendar.add(type, minute);
		return formatDate(calendar);
	}

	// 時間 分 秒 を0に直します
	private static Calendar cutHMS(Calendar calendar){
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}

	// フォーマットに直すだけのメソッド
	private static String formatDate(Calendar calendar) {
		final String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(calendar.getTime());
	}
}
