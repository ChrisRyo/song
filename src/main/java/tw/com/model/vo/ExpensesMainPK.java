package tw.com.model.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the expensesMain database table.
 * 
 */
@Embeddable
public class ExpensesMainPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="bill_date")
	private java.util.Date billDate;

	@Column(name="bill_store")
	private String billStore;

	public ExpensesMainPK() {
	}
	public java.util.Date getBillDate() {
		return this.billDate;
	}
	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
	}
	public String getBillStore() {
		return this.billStore;
	}
	public void setBillStore(String billStore) {
		this.billStore = billStore;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExpensesMainPK)) {
			return false;
		}
		ExpensesMainPK castOther = (ExpensesMainPK)other;
		return 
			this.billDate.equals(castOther.billDate)
			&& this.billStore.equals(castOther.billStore);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.billDate.hashCode();
		hash = hash * prime + this.billStore.hashCode();
		
		return hash;
	}
}