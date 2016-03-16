package tw.com.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the member database table.
 * 
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "member")
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name="user_name")
	private String userName;

	private String addr;

	private String email;

	@Column(name="login_ip")
	private String loginIp;

	@Column(name="login_time")
	private Timestamp loginTime;

	private String name;

	private String phone;

	@NotNull
	private String pwd;

	private Short status;

}