package tw.com.model.vo;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import tw.com.jersey.moxyAdapter.DateAdapter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;


/**
 * The persistent class for the expenses database table.
 * 
 */
@Data
@Entity
@Table(name = "expenses")
@NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e")
public class Expenses implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer seq;

  @Column(name="account_iteam")
  private String accountIteam;

  private BigDecimal amt;

  @Temporal(TemporalType.DATE)
  @Column(name="bill_date")
  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date billDate;

  @Column(name="bill_store")
  private String billStore;

  @Column(name="creat_time")
  private Timestamp creatTime;

  @Column(name="creat_user")
  private String creatUser;

  private String detail;

  private String mark;
  
  private Integer payeeUnit;

  private String payee;

  private BigDecimal price;

  private BigDecimal quantity;

  @Temporal(TemporalType.DATE)
  @Column(name="real_date")
  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date realDate;

  @Column(name="real_store")
  private String realStore;

  private String source;

  private String unit;

  @Column(name="update_time")
  private Timestamp updateTime;

  @Column(name="update_user")
  private String updateUser;

  @Column(name="work_time")
  private String workTime;

  @Column(name="work_type")
  private Integer workType;

}
