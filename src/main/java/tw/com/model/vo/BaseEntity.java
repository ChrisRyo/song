package tw.com.model.vo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import tw.com.logic.utils.UserUtils;


/**
 * The persistent class for the expenses database table.
 * 
 */
public abstract class BaseEntity {

  @Column(name = "creat_time")
  protected Timestamp creatTime;

  @Column(name = "creat_uid")
  protected Integer creatUid;

  @Column(name = "update_time")
  protected Timestamp updateTime;

  @Column(name = "update_uid")
  protected Integer updateUid;

  @PrePersist
  protected void onCreate() {
    if (creatTime == null) {
      creatTime = new Timestamp(new Date().getTime());
    }

    if (creatUid == null) {
      creatUid = UserUtils.getUser().getUid();
    }
  }

  @PreUpdate
  protected void onUpdate() {
    updateTime = new Timestamp(new Date().getTime());
    updateUid = UserUtils.getUser().getUid();
  }

}
