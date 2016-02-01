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
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	private String firstname;

	private Character gender;

	private String lastname;

	private String nickname;

	// bi-directional many-to-one association to UsersLocation
	@OneToMany(mappedBy = "user")
	private List<UsersLocation> usersLocations;

	// bi-directional many-to-one association to UsersSport
	@OneToMany(mappedBy = "user")
	private List<UsersSport> usersSports;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<UsersLocation> getUsersLocations() {
		return this.usersLocations;
	}

	public void setUsersLocations(List<UsersLocation> usersLocations) {
		this.usersLocations = usersLocations;
	}

	public UsersLocation addUsersLocation(UsersLocation usersLocation) {
		getUsersLocations().add(usersLocation);
		usersLocation.setUser(this);

		return usersLocation;
	}

	public UsersLocation removeUsersLocation(UsersLocation usersLocation) {
		getUsersLocations().remove(usersLocation);
		usersLocation.setUser(null);

		return usersLocation;
	}

	public List<UsersSport> getUsersSports() {
		return this.usersSports;
	}

	public void setUsersSports(List<UsersSport> usersSports) {
		this.usersSports = usersSports;
	}

	public UsersSport addUsersSport(UsersSport usersSport) {
		getUsersSports().add(usersSport);
		usersSport.setUser(this);

		return usersSport;
	}

	public UsersSport removeUsersSport(UsersSport usersSport) {
		getUsersSports().remove(usersSport);
		usersSport.setUser(null);

		return usersSport;
	}

}