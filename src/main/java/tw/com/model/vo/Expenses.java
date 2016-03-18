package tw.com.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import tw.com.jersey.moxyAdapter.DateAdapter;


/**
 * The persistent class for the expenses database table.
 * 
 */
@Data
@Entity
@Table(name = "expenses")
@NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e")
public class Expenses extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer seq;

  @Column(name = "account_iteam")
  private String accountIteam;

  private BigDecimal amt;

  @Temporal(TemporalType.DATE)
  @Column(name = "bill_date")
  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date billDate;

  @Column(name = "bill_store")
  private String billStore;

  private String detail;

  private String mark;

  private Integer payeeUnit;

  private String payee;

  private BigDecimal price;

  private BigDecimal quantity;

  @Temporal(TemporalType.DATE)
  @Column(name = "real_date")
  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date realDate;

  @Column(name = "real_store")
  private String realStore;

  private Integer source;

  private Integer unit;

  @Column(name = "work_time")
  private String workTime;

  @Column(name = "work_type")
  private Integer workType;


}
