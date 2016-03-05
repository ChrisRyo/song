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
public enum CompanyEnum {
  鴻海(1), 奇美(2), 大立光(3), 水電木工(4), 好樂潔(5), 台塑(6);

  private final int index;

  private CompanyEnum(int index) {
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

    CompanyEnum[] enums = CompanyEnum.values();

    for (CompanyEnum e : enums) {
      if (StringUtils.isEmpty(name) || e.name().indexOf(name) > -1) {
        list.add(new Menu(e.getIndex(), e.name()));
      }
    }

    return list;
  }

}
