package tw.com.logic.exception;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author zach.han
 * @author hansen.sen
 * @since 2016-02-02
 *
 */
@XmlRootElement
public class ErrorMessage {

  @XmlElement(name = "status")
  int status;

  @XmlElement(name = "exception")
  String exception;

  @XmlElement(name = "message")
  String msg;

  @XmlElement(name = "developerMessage")
  String devMsg;

  // @XmlElement(name = "info")
  // Map<String, Object> info = new HashMap<String, Object>();

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public ErrorMessage(Exception ex) {
    this.status = 9999;
    this.exception = ex.getClass().getSimpleName();
    this.msg = ex.getMessage();
    // this.devMsg = ex.getCause().getMessage();
  }

  public ErrorMessage() {}

}
