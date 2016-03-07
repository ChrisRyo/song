package tw.com.view.message;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 參數驗證訊息
 * @author zach.han
 * 
 * @version 1.0
 * @version 1.1 2016-02-25 chris
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ValidMessage {

	// 欄位名稱
	private String field;

	// 輸入值
	private Object value;

	// 錯誤代碼
	private int errorCode;

	// 錯誤訊息
	private String msg;
}
