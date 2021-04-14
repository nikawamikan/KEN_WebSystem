package model;
/**
 * Menuクラスのベースとなるクラスです。<br>
 * CourseクラスのArrayListを作成しているメソッドで容量が大きくて<br>
 * 動作が遅くなりそうなので軽量化の為に本クラスを採用します。
 *
 * @author Kamishiro
 *
 */
public class MenuBase implements TableInter {

	private int menuId;
	private String menuName;
	private int typeId;

	/**
	 *
	 * @param menuId メニューID
	 * @param menuName メニューの名前
	 * @param typeId 分類ID
	 */
	public MenuBase(int menuId, String menuName, int typeId) {
		setMenuId(menuId);
		setMenuName(menuName);
		setTypeId(typeId);
	}
	public MenuBase(){
	}

	public int getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getTypeId() {
		return typeId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}