package com.zone51.manhattan.middleware.rest.dto;

import com.zone51.manhattan.core.domain.User;

public class UserDTO {

	private Long id;
	private String firstname;
	private String lastname;
	private String nickname;

	public UserDTO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public UserDTO(User user) {
		super();
		id = user.getId();
		firstname = user.getFirstname();
		lastname = user.getLastname();
		nickname = user.getNickname();

	}

	/* util */
	public static UserDTO userToDTO(User user) {
		UserDTO dto = null;

		if (user != null) {
			dto = new UserDTO(user);
		}

		return dto;
	}
}
