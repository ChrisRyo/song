package tw.com.model.vo;

import java.io.Serializable;

import javax.persistence.*;

import tw.com.logic.utils.UserUtils;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;


/**
 * The persistent class for the Account database table.
 * 
 */
@Data
@Entity
@Table(name = "Account")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_name")
  private String userName;

  @Column(name = "creat_time")
  private Timestamp creatTime;

  @Column(name = "creat_user")
  private String creatUser;

  private String email;

  @Column(name = "login_ip")
  private String loginIp;

  @Column(name = "login_time")
  private Timestamp loginTime;

  private String phone;

  private String pwd;

  private Integer status;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Column(name = "update_user")
  private String updateUser;

  @PrePersist
  protected void onCreate() {
    if (creatTime == null) {
      creatTime = new Timestamp(new Date().getTime());
    }

    if (creatUser == null) {
      creatUser = UserUtils.getUser().getAccount();
    }
  }

  @PreUpdate
  protected void onUpdate() {
    updateTime = new Timestamp(new Date().getTime());
    updateUser = UserUtils.getUser().getAccount();
  }

}
