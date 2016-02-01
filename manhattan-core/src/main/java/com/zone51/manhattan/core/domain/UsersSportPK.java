package com.zone51.manhattan.core.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * The primary key class for the users_sports database table.
 * 
 */
@Embeddable
public class UsersSportPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Long userId;

	private Long sportId;

	public UsersSportPK() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSportId() {
		return this.sportId;
	}

	public void setSportId(Long sportId) {
		this.sportId = sportId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sportId == null) ? 0 : sportId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersSportPK other = (UsersSportPK) obj;
		if (sportId == null) {
			if (other.sportId != null)
				return false;
		} else if (!sportId.equals(other.sportId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}