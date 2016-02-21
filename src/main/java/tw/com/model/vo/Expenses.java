package tw.com.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the expenses database table.
 * 
 */
@Entity
@Table(name="expenses")
@NamedQuery(name="Expenses.findAll", query="SELECT e FROM Expenses e")
public class Expenses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="account_iteam")
	private String accountIteam;

	private BigDecimal amt;

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

	public Expenses() {
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getAccountIteam() {
		return this.accountIteam;
	}

	public void setAccountIteam(String accountIteam) {
		this.accountIteam = accountIteam;
	}

	public BigDecimal getAmt() {
		return this.amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public String getBillStore() {
		return this.billStore;
	}

	public void setBillStore(String billStore) {
		this.billStore = billStore;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getCreatUser() {
		return this.creatUser;
	}

	public void setCreatUser(String creatUser) {
		this.creatUser = creatUser;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Date getRealDate() {
		return this.realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public String getRealStore() {
		return this.realStore;
	}

	public void setRealStore(String realStore) {
		this.realStore = realStore;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public int getWorkType() {
		return this.workType;
	}

	public void setWorkType(int workType) {
		this.workType = workType;
	}

}