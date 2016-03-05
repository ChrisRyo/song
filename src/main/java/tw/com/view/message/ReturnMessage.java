package tw.com.view.message;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * 
 * @author chrisryo
 *
 */
@Data
@XmlRootElement
public class ReturnMessage {

  // 驗證結果
  private boolean status;

  // 錯誤代碼
  private int errorCode;

  // 資料
  private Object data;

  // 筆數
  private int count;

  // 擴充欄位
  private Object other;

  public ReturnMessage() {

  }

  public ReturnMessage(boolean status, int errorCode) {
    this.status = status;
    this.errorCode = errorCode;
  }

  public ReturnMessage(boolean status, int errorCode, List<?> data) {
    this.status = status;
    this.errorCode = errorCode;
    this.data = data;
  }

  public ReturnMessage(boolean status, int errorCode, List<?> data, int count) {
    this.status = status;
    this.errorCode = errorCode;
    this.data = data;
    this.count = count;
  }

  public ReturnMessage(boolean status, int errorCode, List<?> data, int count, Object other) {
    this.status = status;
    this.errorCode = errorCode;
    this.data = data;
    this.count = count;
    this.other = other;
  }
}
