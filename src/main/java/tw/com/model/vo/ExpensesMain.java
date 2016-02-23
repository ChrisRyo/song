package tw.com.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the expensesMain database table.
 * 
 */
@Entity
@NamedQuery(name="ExpensesMain.findAll", query="SELECT e FROM ExpensesMain e")
public class ExpensesMain implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExpensesMainPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="creat_time")
	private Date creatTime;

	@Column(name="creat_user")
	private String creatUser;

	@Column(name="total_amt")
	private BigDecimal totalAmt;

	@Column(name="update_mark")
	private int updateMark;

	@Temporal(TemporalType.DATE)
	@Column(name="update_time")
	private Date updateTime;

	@Column(name="update_user")
	private String updateUser;

	public ExpensesMain() {
	}

	public ExpensesMainPK getId() {
		return this.id;
	}

	public void setId(ExpensesMainPK id) {
		this.id = id;
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

	public BigDecimal getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int getUpdateMark() {
		return this.updateMark;
	}

	public void setUpdateMark(int updateMark) {
		this.updateMark = updateMark;
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

}