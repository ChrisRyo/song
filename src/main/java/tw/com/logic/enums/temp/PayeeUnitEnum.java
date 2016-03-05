package tw.com.logic.enums.temp;

import java.util.ArrayList;
import java.util.List;

import tw.com.model.dto.Menu;

/**
 * 
 * @author chrisryo
 *
 */
public enum PayeeUnitEnum {
  員工(1, PlayerEnum.class), 廠商(2, CompanyEnum.class), 政府單位(3, GovernmentEnum.class);

  private final int index;
  private final Class<?> enums;

  private PayeeUnitEnum(int index, Class<?> enums) {
    this.index = index;
    this.enums = enums;
  }

  public int getIndex() {
    return index;
  }

  public Class<?> getEnums() {
    return enums;
  }

  /**
   * 
   * @return
   */
  public static List<Menu> getMenu() {

    List<Menu> list = new ArrayList<Menu>();

    PayeeUnitEnum[] enums = PayeeUnitEnum.values();

    for (PayeeUnitEnum e : enums) {
      list.add(new Menu(e.getIndex(), e.name()));
    }

    return list;
  }
  
//  /**
//   * 
//   * @return
//   */
//  @SuppressWarnings("unchecked")
//  public static List<Menu> getDetailMenu(int unit, String name) {
//
//    List<Menu> list = new ArrayList<Menu>();
//
//    PayeeUnitEnum[] enums = PayeeUnitEnum.values();
//
//    for (PayeeUnitEnum en : enums) {
//      if (en.getIndex() == unit) {
//        try {
//          Method method = en.getEnums().getMethod("getMenu", new  Class[]{String.class});
//          list = (List<Menu>) method.invoke(en.getEnums(), name);
//        } catch (Exception e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//        }
//      }
//    }
//
//    return list;
//  }
}
