package tw.com.logic.enums.temp;

import java.util.ArrayList;
import java.util.List;

import tw.com.model.dto.Menu;

/**
 * 
 * @author chrisryo
 *
 */
public enum StoreEnum {
  歌辦(1), 歌樂(2), 歌牌(3), 歌路(4), 歌美(5), 歌神(6);

  private final int index;

  private StoreEnum(int index) {
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

    StoreEnum[] enums = StoreEnum.values();

    for (StoreEnum e : enums) {
      list.add(new Menu(e.getIndex(), e.name()));
    }

    return list;
  }
}
