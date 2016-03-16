package tw.com.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import tw.com.jersey.moxyAdapter.DateAdapter;
import tw.com.logic.utils.UserUtils;


/**
 * The persistent class for the expensesMain database table.
 * 
 */
@Data
@Entity
@XmlRootElement
@Table(name = "expensesMain")
@IdClass(ExpensesMainPK.class)
@NamedQuery(name = "ExpensesMain.findAll", query = "SELECT e FROM ExpensesMain e")
public class ExpensesMain implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Temporal(TemporalType.DATE)
  @Column(name = "bill_date")
  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date billDate;

  @Id
  @Column(name = "bill_store")
  private String billStore;

  @Id
  private Integer source;

  @Column(name = "real_total_amt")
  private BigDecimal realTotalAmt;

  @Column(name = "creat_time")
  private Timestamp creatTime;

  @Column(name = "creat_user")
  private String creatUser;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Column(name = "update_user")
  private String updateUser;

  /**
   * 
   * @param source
   */
  public void setSource(Integer source) {
    if (source == null || source == 0) {
      this.source = null;
    } else {
      this.source = source;
    }
  }

  @PrePersist
  protected void onCreate() {
    if (creatTime == null) {
      creatTime = new Timestamp(new Date().getTime());
    }

    if (creatUser == null) {
      creatUser = UserUtils.getUser().getUserName();
    }
  }

  @PreUpdate
  protected void onUpdate() {
    updateTime = new Timestamp(new Date().getTime());
    updateUser = UserUtils.getUser().getUserName();
  }

}
