package tw.com.view.message.code;

/**
 * 
 * @author chrisryo
 *
 */
public enum ValidCode {
  SUCCESS(0), // 成功
  NOT_NULL(1001), // 不能為 null(必填)
  NOT_EMPTY_STRING(1002), // 不能為空字串
  FORMAT_FAIL(1003), // 格式錯誤
  VALID_FAIL(1004), // 驗證失敗
  DUPLICATE_FAIL(1005), // 資料衝突(已重複)
  NOT_EXIST(1006) // 不存在
  ;

  private final int code;

  private ValidCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

}
