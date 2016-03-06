package tw.com.model.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The primary key class for the expensesMain database table.
 * 
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ExpensesMainPK implements Serializable {
  // default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Temporal(TemporalType.DATE)
  @Column(name = "bill_date")
  private Date billDate;

  @Column(name = "bill_store")
  private String billStore;

  private Integer source;

  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ExpensesMainPK)) {
      return false;
    }
    ExpensesMainPK castOther = (ExpensesMainPK) other;
    return this.billDate.equals(castOther.billDate) && this.billStore.equals(castOther.billStore)
        && this.source.equals(castOther.source);
  }

  public int hashCode() {
    final int prime = 31;
    int hash = 17;
    hash = hash * prime + this.billDate.hashCode();
    hash = hash * prime + this.billStore.hashCode();
    hash = hash * source + this.source.hashCode();

    return hash;
  }
}
