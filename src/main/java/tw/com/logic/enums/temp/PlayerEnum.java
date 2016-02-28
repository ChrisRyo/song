package tw.com.logic.enums.temp;

import java.util.ArrayList;
import java.util.List;

import tw.com.model.dto.Menu;

/**
 * 
 * @author chrisryo
 *
 */
public enum PlayerEnum {
  林詩婷(1), 林誠耀(2), 林戴英(3), 林騰朵(4), 林一二(5), 林老師(6);

  private final int index;

  private PlayerEnum(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  /**
   * 
   * @return
   */
  public static List<Menu> getMenu(String name) {

    List<Menu> list = new ArrayList<Menu>();

    PlayerEnum[] enums = PlayerEnum.values();

    for (PlayerEnum e : enums) {
      if (e.name().indexOf(name) > 0) {
        list.add(new Menu(e.getIndex(), e.name()));
      }
    }

    return list;
  }
}
