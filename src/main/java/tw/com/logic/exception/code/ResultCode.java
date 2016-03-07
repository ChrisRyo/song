package tw.com.logic.exception.code;

/**
 * 結果代碼, 有需要請自行新增
 * 
 * @author zach.han
 *
 */
public enum ResultCode implements ErrorCode {

  /** 成功 */
  SUCCESS(0),
  /** API 參數驗證失敗，回傳data欄位中包含各參數的錯誤狀況 */
  FORMAT_FAIL(1001),
  /** 驗證碼錯誤 */
  VALIDCODE_FAIL(1002),
  /** 顯示驗證碼 */
  VALIDCODE_SHOW(1003),
  /** 未登入 */
  NOT_LOGIN(2001),
  /** 鎖定中 */
  IS_LOCK(2002),
  /** 黑名單帳號 */
  BLOCK_ACCOUNT(2003),
  /** 資料庫連線失敗 */
  DB_CONNECTION_FAIL(8001),
  /** 資料不存在 */
  NOT_EXIST(8002),
  /** 資料衝突(已重複) */
  DUPLICATE_FAIL(8003),
  /** 未知錯誤 */
  ERR_DEFIND(9999);

  private final int code;

  private ResultCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

}
