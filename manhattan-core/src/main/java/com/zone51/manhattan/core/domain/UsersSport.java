package com.zone51.manhattan.core.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the users_sports database table.
 * 
 */
@Entity
@Table(name = "users_sports")
public class UsersSport implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsersSportPK id;

	private Integer skill;

	// bi-directional many-to-one association to Sport
	@ManyToOne
	private Sport sport;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UsersSport() {
	}

	public UsersSportPK getId() {
		return this.id;
	}

	public void setId(UsersSportPK id) {
		this.id = id;
	}

	public Integer getSkill() {
		return this.skill;
	}

	public void setSkill(Integer skill) {
		this.skill = skill;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}