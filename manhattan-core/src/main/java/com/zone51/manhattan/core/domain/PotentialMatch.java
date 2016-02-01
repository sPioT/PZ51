package com.zone51.manhattan.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the potential_matches database table.
 * 
 */
@Entity
@Table(name = "potential_matches")
public class PotentialMatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(nullable = false)
	private Integer distance;

	private Boolean reponse1;

	private Boolean reponse2;

	// bi-directional many-to-one association to Request
	@ManyToOne
	@JoinColumn(name = "request1_id", referencedColumnName = "id", nullable = false)
	private Request request1;

	// bi-directional many-to-one association to Request
	@ManyToOne
	@JoinColumn(name = "request2_id", referencedColumnName = "id", nullable = false)
	private Request request2;

	public PotentialMatch() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Boolean getReponse1() {
		return this.reponse1;
	}

	public void setReponse1(Boolean reponse1) {
		this.reponse1 = reponse1;
	}

	public Boolean getReponse2() {
		return this.reponse2;
	}

	public void setReponse2(Boolean reponse2) {
		this.reponse2 = reponse2;
	}

	public Request getRequest1() {
		return this.request1;
	}

	public void setRequest1(Request request1) {
		this.request1 = request1;
	}

	public Request getRequest2() {
		return this.request2;
	}

	public void setRequest2(Request request2) {
		this.request2 = request2;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}