package tw.com.model.vo;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

/**
 * The persistent class for the member database table.
 * 
 */
@Data
@Entity
@Table(name = "member")
@NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String email;

	private String phone;

	private String pwd;

}