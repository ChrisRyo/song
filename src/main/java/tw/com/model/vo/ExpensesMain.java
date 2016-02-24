package tw.com.model.vo;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


/**
 * The persistent class for the expensesMain database table.
 * 
 */
@Data
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
	
}