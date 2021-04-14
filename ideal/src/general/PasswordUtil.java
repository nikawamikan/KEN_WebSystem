package general;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * パスワードをハッシュ化するためのクラスです。<br>
 * ネット上で拾ってきただけなので説明が不明瞭かもしれませんがハッシュ化する事で不可逆的な文字列を生成します。<br>
 * 認証する時は入力側が再び同じアルゴリズムでハッシュ化して送信するのでSQL側と一致させる事ができます。
 * 
 * @author 僕は作ってません(ｂｙカミシロ)
 *  @see <a href="https://www.casleyconsulting.co.jp/blog/engineer/153/">参考元のサイト</a>
 *
 */
public class PasswordUtil {

	// テスト用
	public static void main(String[] args) {
		String testSolt = "misooden";
		String testPass = "satubatu";
		// 同じパスワード生成アルゴリズムで同じソルトとパスワードを投入した状態で比較して整合性が取れるか確かめています
		
		System.out.println(getSafetyPassword(testPass, testSolt).equals(getSafetyPassword(testPass, testSolt)));
		// true が出力されるので問題なく同じハッシュ化されている事がわかります。
	}

	/** パスワードを安全にするためのアルゴリズム */
	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";// こーゆー名前のアルゴリズムがあるんです! 詳しくはウェブで!
	/** ストレッチング回数 */
	private static final int ITERATION_COUNT = 15023;// 1万回以上繰り返さないとダメらしい。でも一定数だとなんだか不安ですよね
	/** 生成される鍵の長さ */
	private static final int KEY_LENGTH = 256;// bit単位でByteコード

	/**
	 * 平文のパスワードとソルトから安全なパスワードを生成し、返却します
	 *
	 * @param password
	 *            平文のパスワード
	 * @param salt
	 *            ソルト ユーザーIDを使用します。
	 * @return 安全なパスワード
	 */
	public static String getSafetyPassword(String password, String salt) {

		// 平文のパスワード(String)からCharArrayに変換
		char[] passCharAry = password.toCharArray();
		// ソルト(今回はユーザーID)をハッシュ化します(不可逆的なコード化)
		byte[] hashedSalt = getHashedSalt(salt);

		// なんかコレが鍵の仕様を設定するところらしいです
		PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt,
				ITERATION_COUNT, KEY_LENGTH);

		SecretKeyFactory skf;
		try {
			// パスワード生成のアルゴリズムを指定して実体化
			skf = SecretKeyFactory.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		SecretKey secretKey;
		try {
			// さっき作った鍵の仕様から鍵を生成するよ
			secretKey = skf.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		
		// そのままだと使えないからByte型の配列を吐いてもらいます
		byte[] passByteAry = secretKey.getEncoded();

//		for (byte b : passByteAry) {
//			System.out.println(b);
//		}

		// 生成されたバイト配列を16進数の文字列に変換
		StringBuilder sb = new StringBuilder(64);
		for (byte b : passByteAry) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	/**
	 * ソルトをハッシュ化して返却します ※ハッシュアルゴリズムはSHA-256を使用
	 *
	 * @param salt
	 *            ソルト
	 * @return ハッシュ化されたバイト配列のソルト
	 */
	private static byte[] getHashedSalt(String salt) {
		// この人がハッシュ化する人らしい
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");// SHA-256ってアルゴリズム(上のアルゴリズムの後ろアレと一緒っぽい)
		} catch (NoSuchAlgorithmException e) {
			// 地味にここでeを引数にthrowする仕様に気づいた。
			throw new RuntimeException(e);
		}
		
		// 塩を入れてバイトコードに直してそれをバイト配列に直してポイしてくれるそうです。
		messageDigest.update(salt.getBytes());
		return messageDigest.digest();
	}
}