package tw.com.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(PagePermissionPK.class)
@NamedQuery(name="PagePermission.findAll", query="SELECT p FROM PagePermission p")
public class PagePermission extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    private Integer uid;

	@Id
    @Column(name="url_id")
    private int urlId;

	@Column(name="detele_mark")
	private byte deteleMark;

}