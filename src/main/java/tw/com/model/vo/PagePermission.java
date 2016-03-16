package tw.com.model.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the page_permission database table.
 * 
 */
@Data
@Entity
@Table(name="page_permission")
@NamedQuery(name="PagePermission.findAll", query="SELECT p FROM PagePermission p")
public class PagePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PagePermissionPK id;

	@Column(name="creat_time")
	private Timestamp creatTime;

	@Column(name="creat_user")
	private String creatUser;

	@Column(name="detele_mark")
	private byte deteleMark;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="update_user")
	private String updateUser;

}