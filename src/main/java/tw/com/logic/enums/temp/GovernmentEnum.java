package tw.com.logic.enums.temp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import tw.com.model.dto.Menu;

/**
 * 
 * @author chrisryo
 *
 */
public enum GovernmentEnum {
  臺北市政府(1), 新北市政府(2), 總統府(3), 府府府府府(4);

  private final int index;

  private GovernmentEnum(int index) {
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

    GovernmentEnum[] enums = GovernmentEnum.values();

    for (GovernmentEnum e : enums) {
      if (StringUtils.isEmpty(name) || e.name().indexOf(name) > -1) {
        list.add(new Menu(e.getIndex(), e.name()));
      }
    }

    return list;
  }
}