package tw.com.model.vo;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


/**
 * The persistent class for the expenses database table.
 * 
 */
@Data
@Entity
@Table(name="expenses")
@NamedQuery(name="Expenses.findAll", query="SELECT e FROM Expenses e")
public class Expenses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="account_iteam")
	private String accountIteam;

	private BigDecimal amt;

	@Id
	@Column(name="bill_store")
	private String billStore;

	@Temporal(TemporalType.DATE)
	@Column(name="creat_time")
	private Date creatTime;

	@Column(name="creat_user")
	private String creatUser;

	private String detail;

	private String mark;

	private String payee;

	private BigDecimal price;

	private BigDecimal quantity;

	@Temporal(TemporalType.DATE)
	@Column(name="real_date")
	private Date realDate;

	@Column(name="real_store")
	private String realStore;

	private String source;

	private String unit;

	@Temporal(TemporalType.DATE)
	@Column(name="update_time")
	private Date updateTime;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="work_time")
	private String workTime;

	@Column(name="work_type")
	private int workType;

}