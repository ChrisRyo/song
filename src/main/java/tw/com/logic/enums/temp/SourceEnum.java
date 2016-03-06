package tw.com.logic.enums.temp;

import java.util.ArrayList;
import java.util.List;

import tw.com.model.dto.Menu;

/**
 * 
 * @author chrisryo
 *
 */
public enum SourceEnum {
  八里大支出(1), 八里未付款(2), 八里店內(3), 台北大支出(4), 台北未付款(5), 台北店內(6), 台北損益_總(6), 倉庫(6), 調貨(7);

  private final int index;

  private SourceEnum(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  /**
   * 
   * @return
   */
  public static List<Menu> getMenu() {

    List<Menu> list = new ArrayList<Menu>();

    SourceEnum[] enums = SourceEnum.values();

    for (SourceEnum e : enums) {
      list.add(new Menu(e.getIndex(), e.name()));
    }

    return list;
  }

}
