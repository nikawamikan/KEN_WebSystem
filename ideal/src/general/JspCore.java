package general;

import controller.CtrlInter;
import ctrl.SvlName;
/**
 * JSPがimplements不可能な仕様な為、extendsで対応させるクラス。<br>
 * CtrlInterで定義した文字列がそのまま変数名として利用できるのでミスが削減できると推察している。
 * @author Kamishiro
 *
 */
public final class JspCore implements CtrlInter,SvlName{

	public static void main(String[] args) {
		new JspCore().test();
	}
	public void test(){

		System.out.println(String.format("みかん %s",this.getClass().getSimpleName()));
		System.out.println(SvlName.AdminLoginSvl);
	}
}
