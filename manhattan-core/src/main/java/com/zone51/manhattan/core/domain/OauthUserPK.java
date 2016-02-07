package com.zone51.manhattan.core.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oauth_users database table.
 * 
 */
@Embeddable
public class OauthUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private int userId;

	private String network;

	public OauthUserPK() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNetwork() {
		return this.network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OauthUserPK)) {
			return false;
		}
		OauthUserPK castOther = (OauthUserPK)other;
		return 
			(this.userId == castOther.userId)
			&& this.network.equals(castOther.network);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.network.hashCode();
		
		return hash;
	}
}