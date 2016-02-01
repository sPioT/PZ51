package com.zone51.manhattan.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sports database table.
 * 
 */
@Entity
@Table(name = "sports")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private String sportname;

	// bi-directional many-to-one association to UsersSport
	@OneToMany(mappedBy = "sport")
	private List<UsersSport> usersSports;

	public Sport() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSportname() {
		return this.sportname;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public List<UsersSport> getUsersSports() {
		return this.usersSports;
	}

	public void setUsersSports(List<UsersSport> usersSports) {
		this.usersSports = usersSports;
	}

	public UsersSport addUsersSport(UsersSport usersSport) {
		getUsersSports().add(usersSport);
		usersSport.setSport(this);

		return usersSport;
	}

	public UsersSport removeUsersSport(UsersSport usersSport) {
		getUsersSports().remove(usersSport);
		usersSport.setSport(null);

		return usersSport;
	}

}