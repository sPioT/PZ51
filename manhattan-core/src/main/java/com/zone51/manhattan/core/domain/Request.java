package com.zone51.manhattan.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the requests database table.
 * 
 */
@Entity
@Table(name = "requests")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "sport_id", nullable = false)
	private Long sportId;

	@Column(nullable = false)
	private int skill;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;

	@Column(name = "date_range", nullable = false)
	private short dateRange;

	@Column(nullable = false, precision = 10, scale = 6)
	private BigDecimal latitude;

	@Column(nullable = false, precision = 10, scale = 6)
	private BigDecimal longitude;

	@Column(name = "max_distance", nullable = false)
	private int maxDistance;

	@Column(name = "max_skill_gap", nullable = false)
	private int maxSkillGap;

	// bi-directional many-to-one association to PotentialMatch
	@OneToMany(mappedBy = "request1", fetch = FetchType.EAGER)
	private List<PotentialMatch> potentialMatches1;

	// bi-directional many-to-one association to PotentialMatch
	@OneToMany(mappedBy = "request2", fetch = FetchType.EAGER)
	private List<PotentialMatch> potentialMatches2;

	// bi-directional many-to-one association to Sport
	@ManyToOne
	@JoinColumn(name = "sport_id", nullable = false, insertable = false, updatable = false)
	private Sport sport;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Request() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSportId() {
		return this.sportId;
	}

	public void setSportId(Long sportId) {
		this.sportId = sportId;
	}

	public int getSkill() {
		return this.skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public short getDateRange() {
		return this.dateRange;
	}

	public void setDateRange(short dateRange) {
		this.dateRange = dateRange;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public int getMaxDistance() {
		return this.maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public int getMaxSkillGap() {
		return this.maxSkillGap;
	}

	public void setMaxSkillGap(int maxSkillGap) {
		this.maxSkillGap = maxSkillGap;
	}

	public List<PotentialMatch> getPotentialMatches() {
		List<PotentialMatch> po = new ArrayList<PotentialMatch>();
		po.addAll(this.potentialMatches1);
		po.addAll(this.potentialMatches2);

		return po;
	}

	public List<PotentialMatch> getPotentialMatches1() {
		return this.potentialMatches1;
	}

	public void setPotentialMatches1(List<PotentialMatch> potentialMatches1) {
		this.potentialMatches1 = potentialMatches1;
	}

	public PotentialMatch addPotentialMatches1(PotentialMatch potentialMatches1) {
		getPotentialMatches1().add(potentialMatches1);
		potentialMatches1.setRequest1(this);

		return potentialMatches1;
	}

	public PotentialMatch removePotentialMatches1(PotentialMatch potentialMatches1) {
		getPotentialMatches1().remove(potentialMatches1);
		potentialMatches1.setRequest1(null);

		return potentialMatches1;
	}

	public List<PotentialMatch> getPotentialMatches2() {
		return this.potentialMatches2;
	}

	public void setPotentialMatches2(List<PotentialMatch> potentialMatches2) {
		this.potentialMatches2 = potentialMatches2;
	}

	public PotentialMatch addPotentialMatches2(PotentialMatch potentialMatches2) {
		getPotentialMatches2().add(potentialMatches2);
		potentialMatches2.setRequest2(this);

		return potentialMatches2;
	}

	public PotentialMatch removePotentialMatches2(PotentialMatch potentialMatches2) {
		getPotentialMatches2().remove(potentialMatches2);
		potentialMatches2.setRequest2(null);

		return potentialMatches2;
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