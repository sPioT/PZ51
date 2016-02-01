package com.zone51.manhattan.middleware.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zone51.manhattan.core.domain.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private Long id;
	private String firstname;
	private String lastname;
	private String nickname;
	private Date birthday;
	private Character gender;
	private List<SportDTO> sports;
	private List<LocationDTO> locations;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public List<SportDTO> getSports() {
		return sports;
	}

	public void setSports(List<SportDTO> sports) {
		this.sports = sports;
	}

	public List<LocationDTO> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationDTO> locations) {
		this.locations = locations;
	}

	public UserDTO(User user, boolean shorten) {
		super();
		id = user.getId();
		firstname = user.getFirstname();
		lastname = user.getLastname();
		nickname = user.getNickname();
		gender = user.getGender();
		birthday = user.getBirthday();

		if (!shorten) {
			sports = SportDTO.usersportsToDTO(user.getUsersSports());
			locations = LocationDTO.locationsToDTO(user.getUsersLocations());
		}

	}

	/* util */
	public static UserDTO userToDTO(User user, boolean shorten) {
		UserDTO dto = null;

		if (user != null) {
			dto = new UserDTO(user, shorten);
		}

		return dto;
	}
}
