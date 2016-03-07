package tw.com.logic.exception.code;

/**
 *
 */
public enum ErrorType implements ErrorCode {

  NOT_NULL(101), // 欄位不能為空
  FORMAT_FAIL(103), // 欄位格式不正確
  VALIDCODE_FAIL(104), // 欄位驗證失敗
  DUPLICATE_FAIL(105); // 欄位資料重複

  private final int code;

  private ErrorType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

}
