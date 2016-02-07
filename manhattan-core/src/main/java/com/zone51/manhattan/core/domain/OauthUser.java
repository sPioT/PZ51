package com.zone51.manhattan.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the oauth_users database table.
 * 
 */
@Entity
@Table(name = "oauth_users")
public class OauthUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OauthUserPK id;

	@Column(name = "network_id")
	private String networkId;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public OauthUser() {
	}

	public OauthUserPK getId() {
		return this.id;
	}

	public void setId(OauthUserPK id) {
		this.id = id;
	}

	public String getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}