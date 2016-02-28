package tw.com.view.bean;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.Delegate;
import tw.com.model.vo.Expenses;

@Data
@XmlRootElement
public class ExpensesBean {

  @Delegate
  private Expenses expenses = new Expenses(); 
}
