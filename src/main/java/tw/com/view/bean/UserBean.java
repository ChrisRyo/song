package tw.com.view.bean;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserBean {

	@DecimalMin(value = "2", message = "Student shall be minimum of age 2")
	private int id;

	private String name;

	private String profession;

	@NotNull(message = "測試測試測試")
	public String getName() {
		return this.name;
	}

}
