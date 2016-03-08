package tw.com.view.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import tw.com.jersey.moxyAdapter.DateAdapter;

@Data
@XmlRootElement
public class ExpensesBean {
  private Integer seq;

  private String accountIteam;

  private BigDecimal amt;

  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date billDate;

  private String billStore;

  private String detail;

  private String mark;

  private Integer payeeUnit;

  private String payee;

  private BigDecimal price;

  private BigDecimal quantity;

  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date realDate;

  private String realStore;

  private Integer source;

  private Integer unit;

  private String workTime;

  private Integer workType;
}
