package tw.com.model.vo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import tw.com.logic.utils.UserUtils;


/**
 * The persistent class for the expenses database table.
 * 
 */
@Data
public class BaseEntity {

  @Column(name = "creat_time")
  protected Timestamp creatTime;

  @Column(name = "creat_user")
  protected String creatUser;

  @Column(name = "update_time")
  protected Timestamp updateTime;

  @Column(name = "update_user")
  protected String updateUser;

  @PrePersist
  protected void onCreate() {
    if (creatTime == null) {
      creatTime = new Timestamp(new Date().getTime());
    }

    if (creatUser == null) {
      creatUser = UserUtils.getUser().getUserName();
    }
  }

  @PreUpdate
  protected void onUpdate() {
    updateTime = new Timestamp(new Date().getTime());
    updateUser = UserUtils.getUser().getUserName();
  }

}
