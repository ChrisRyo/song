package tw.com.view.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import tw.com.jersey.moxyAdapter.DateAdapter;
import tw.com.model.dto.PageInfo;
import tw.com.model.vo.ExpensesMain;

/**
 * 
 * @author chrisryo
 *
 */
@XmlRootElement
public class ExpensesMainBean extends PageInfo{

  private ExpensesMain entity;

  public ExpensesMainBean() {
    this.entity = new ExpensesMain();
  }

  public ExpensesMain getEntity() {
    return entity;
  }

  public void setEntity(ExpensesMain entity) {
    this.entity = entity;
  }

  /**
   * 請款日期
   * 
   * @return
   */
  @NotNull
  @Past
  @XmlJavaTypeAdapter(DateAdapter.class)
  public Date getBillDate() {
    return entity.getBillDate();
  }

  public void setBillDate(Date billDate) {
    entity.setBillDate(billDate);
  }

  /**
   * 請款店家
   * 
   * @return
   */
  @NotNull
  @Size(max = 20)
  public String getBillStore() {
    return entity.getBillStore();
  }

  public void setBillStore(String billStore) {
    entity.setBillStore(billStore);
  }

  /**
   * 來源
   * 
   * @return
   */
  @NotNull
  @Max(9999)
  public Integer getSource() {
    return entity.getSource();
  }

  public void setSource(Integer source) {
    entity.setSource(source);
  }

  /**
   * 總金額
   * 
   * @return
   */
  @DecimalMax("999999999999999.99")
  public BigDecimal getRealTotalAmt() {
    return entity.getRealTotalAmt();
  }

  public void setRealTotalAmt(BigDecimal realTotalAmt) {
    entity.setRealTotalAmt(realTotalAmt);
  }
}
